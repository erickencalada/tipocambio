package pe.gob.midis.sisfoh.security.jwt;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import pe.gob.midis.sisfoh.security.dto.UsuarioDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.security.service.UserDetailsServiceImpl;
import pe.gob.midis.sisfoh.util.PropertiesUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import java.util.*;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
    	logger.info("-INI- doFilterInternal");
        try {
            String token = this.getToken(req);
            logger.info("token: "+token);
            
            if(token != null && jwtProvider.validateToken(token)){
                String userName = jwtProvider.getNombreUsuarioFromToken(token);
                logger.info("Se recupera del Token. userName : "+userName);
//                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);//LLEER DE UN PROPERTIES.
                
                if(userDetailsService == null)
                	userDetailsService = new UserDetailsServiceImpl();
                
                UserDetailsServiceImpl userDetailsServiceImpl = new UserDetailsServiceImpl();
//                UsuarioDto usuarioDto = new UsuarioDto();
                UsuarioSeguridadDto usuarioSeguridadDto  = this.leerUsuarioDtoProperties(userName);
                UserDetails userDetails = userDetailsServiceImpl.generarUsuarioPrincipalBuilder(usuarioSeguridadDto);
                usuarioSeguridadDto = null;
                
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            logger.error("Fallo en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(req, res);
    }

    private String getToken(HttpServletRequest request){
    	logger.info("-INI- getToken");
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }
    
    
  
    
    public UsuarioSeguridadDto leerUsuarioDtoProperties(String username) {
   	 String[] roles = PropertiesUtil.getRoles(username);
   	    UsuarioSeguridadDto usuarioSeguridadDto = new UsuarioSeguridadDto();
	   	usuarioSeguridadDto.setAbreviaturaSistema(PropertiesUtil.getPropertiesValue(username, "abreviatura_sistema" ));
	   	usuarioSeguridadDto.setContrasena(null);
	   	usuarioSeguridadDto.setCorreoElectronico(PropertiesUtil.getPropertiesValue(username, "correo" ));
	   	usuarioSeguridadDto.setCoUbigeo(PropertiesUtil.getPropertiesValue(username, "sistema" ));
	   	usuarioSeguridadDto.setDependencia(PropertiesUtil.getPropertiesValue(username, "coubigeo" ));
	   	usuarioSeguridadDto.setIdSistema(Long.parseLong(PropertiesUtil.getPropertiesValue(username, "id_sistema" )) );
	   	usuarioSeguridadDto.setIdUsuario(Long.parseLong(PropertiesUtil.getPropertiesValue(username, "id_usuario" )));
	   	usuarioSeguridadDto.setInPassword(PropertiesUtil.getPropertiesValue(username, "sistema" ));
	   	usuarioSeguridadDto.setMaternoUsuario(PropertiesUtil.getPropertiesValue(username, "inpassword" ));
	   	usuarioSeguridadDto.setNombreUsuario(PropertiesUtil.getPropertiesValue(username, "nombre_usuario" ));
	   	usuarioSeguridadDto.setPaternoUsuario(PropertiesUtil.getPropertiesValue(username, "apellido_paterno" ));
	   	usuarioSeguridadDto.setSistema(PropertiesUtil.getPropertiesValue(username, "sistema" ));
	   	usuarioSeguridadDto.setUsuario(PropertiesUtil.getPropertiesValue(username, "usuario" ));
//        List<String> listRol = new ArrayList<String>();
        List<String> listRol = Arrays.asList(roles);
//        listRol.add("ResPlus ULE");
        usuarioSeguridadDto.setListadoRolestxt(listRol);
        
        return usuarioSeguridadDto;
   }
    
    
/*    
    public UsuarioDto leerUsuarioDtoProperties(String username) {
    	 String[] roles = PropertiesUtil.getRoles(username);
    	 UsuarioDto usuarioDto = new UsuarioDto();
         usuarioDto.setAbreviaturaSistema(PropertiesUtil.getPropertiesValue(username, "abreviatura_sistema" ));
         usuarioDto.setContrasena(null);
         usuarioDto.setCorreoElectronico(PropertiesUtil.getPropertiesValue(username, "correo" ));
         usuarioDto.setCoUbigeo(PropertiesUtil.getPropertiesValue(username, "sistema" ));
         usuarioDto.setDependencia(PropertiesUtil.getPropertiesValue(username, "coubigeo" ));
         usuarioDto.setIdSistema(Long.parseLong(PropertiesUtil.getPropertiesValue(username, "id_sistema" )) );
         usuarioDto.setIdUsuario(Long.parseLong(PropertiesUtil.getPropertiesValue(username, "id_usuario" )));
         usuarioDto.setInPassword(PropertiesUtil.getPropertiesValue(username, "sistema" ));
         usuarioDto.setMaternoUsuario(PropertiesUtil.getPropertiesValue(username, "inpassword" ));
         usuarioDto.setNombreUsuario(PropertiesUtil.getPropertiesValue(username, "nombre_usuario" ));
         usuarioDto.setPaternoUsuario(PropertiesUtil.getPropertiesValue(username, "apellido_paterno" ));
         usuarioDto.setSistema(PropertiesUtil.getPropertiesValue(username, "sistema" ));
         usuarioDto.setUsuario(PropertiesUtil.getPropertiesValue(username, "usuario" ));
//         List<String> listRol = new ArrayList<String>();
         List<String> listRol = Arrays.asList(roles);
//         listRol.add("ResPlus ULE");
         usuarioDto.setListadoRoles(listRol);
         return usuarioDto;
    }
*/
}
