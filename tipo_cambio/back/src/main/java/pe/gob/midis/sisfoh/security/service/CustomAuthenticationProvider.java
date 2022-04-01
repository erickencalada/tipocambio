package pe.gob.midis.sisfoh.security.service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException.BadGateway;

import pe.gob.midis.sisfoh.security.dto.RolDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.util.PropertiesUtil;
import pe.gob.midis.sisfoh.util.Validador;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
//	@Autowired
//	UserDetailsService userDetailsService;

	private UserDetailsServiceImpl userDetailsServiceImpl;
	
    @Autowired
    private SisfohComunService sisfohComunServiceRest;

//    @Value("${midis.ws.usuarioseguridad}")
//	private String urlUsuarioSeguridad;
    
//	private Long idSistema  = 51L;

    public static String idSistema;
	
    
    @Value("${seguridad.idsistema}")
    public  void setIdSistema(String idSistema) {
		CustomAuthenticationProvider.idSistema = idSistema;
	}

	public static String urlUsuarioSeguridad;
    
    public void setUrlUsuarioSeguridad(String urlUsuarioSeguridad) {
       this.urlUsuarioSeguridad= urlUsuarioSeguridad;
    }

    public CustomAuthenticationProvider() {
    	
    }
    
	 
	 public Authentication authenticate(Authentication authentication)  throws BadCredentialsException{
		logger.info("-INI- authenticate");
		String username = authentication.getName(); // (1)
		String password = authentication.getCredentials().toString(); // (1)
		
		if(sisfohComunServiceRest == null) {
			sisfohComunServiceRest = new SisfohComunService();
		}
		
		UsuarioSeguridadDto usuarioSeguridadDtoResponse = null;
		Authentication auth = null;
	
			try {
				usuarioSeguridadDtoResponse = sisfohComunServiceRest.getUsuarioSeguridadDto(urlUsuarioSeguridad, username, password, new Long(idSistema));
			} catch (Validador e) {
				logger.error(e.getMessage());
			}
			
			
			if(usuarioSeguridadDtoResponse.getIdUsuario() == null) {
				throw new BadCredentialsException("Usuario no existe en el sistema de seguridad.");	
			}
			
			if(usuarioSeguridadDtoResponse.getListadoRoles() == null) {
				throw new BadCredentialsException("Usuario o Password incorrecto.");	
			}
			
			if(usuarioSeguridadDtoResponse.getDiasFaltaCaduca().trim().equalsIgnoreCase("0") ) {
				throw new BadCredentialsException("Usuario caducado.");	
			}
			 
			List<String> listaRolestxt = new ArrayList<String>();
			
			for(RolDto rolDto : usuarioSeguridadDtoResponse.getListadoRoles()) {
				listaRolestxt.add(rolDto.getIdRol()+"-"+rolDto.getRol());
			}
			usuarioSeguridadDtoResponse.setListadoRolestxt(listaRolestxt);
//	        PropertiesUtil.inicializarPreferencias(username, usuarioSeguridadDtoResponse);
			
	        if(userDetailsServiceImpl == null) {
	        	userDetailsServiceImpl = new UserDetailsServiceImpl();
			}
	        
			UserDetails userDetails = userDetailsServiceImpl.generarUsuarioPrincipalBuilder(usuarioSeguridadDtoResponse);
			userDetailsServiceImpl = null;
			
			auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

			
		
		
		
		return auth;
	}



	
	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}



	
	
}
