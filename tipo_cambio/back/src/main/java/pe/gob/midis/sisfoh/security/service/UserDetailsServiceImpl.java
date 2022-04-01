package pe.gob.midis.sisfoh.security.service;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.gob.midis.sisfoh.security.dto.UsuarioDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;
import pe.gob.midis.sisfoh.security.entity.UsuarioPrincipal;
import pe.gob.midis.sisfoh.util.PropertiesManager;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

 

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.info("-INI- loadUserByUsername");
        
    	return null;
    }
 
    
    public UserDetails generarUsuarioPrincipalBuilder( UsuarioSeguridadDto usuarioSeguridadDto) throws UsernameNotFoundException {
    	logger.info("-INI- generarUsuarioPrincipalBuilder");
        
 
    	
        return UsuarioPrincipal.build(usuarioSeguridadDto);
    }
    
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.info("-INI- loadUserByUsername");
    	//aqui, leer el archivo txt, en donde esta toda la info del usuario logueado.
    	//Comentar el servicio usuarioService.getByNombreUsuario(nombreUsuario).get();
    	
        
//         * 1.- Consultar info usuario properties.
//         * 2.- Construir Usuario con la info usuario properties.
         
//        Usuario usuario = usuarioService.getByNombreUsuario(username).get();
        Usuario usuario = this.getByNombreUsuario(username).get(0);
        
//        UsuarioDto usuarioDto = this.getUsuarioDto();
//        usuarioDto.setNombreUsuario(usuario.getNombre());
//        usuarioDto.setCorreoElectronico(usuario.getEmail());
//        this.inicializarPreferencias(username, usuarioDto);
        
        return UsuarioPrincipal.build(usuario);
    }
  
    */
    
    /**
     * 
     *     public Usuario(@NotNull String nombre, 
     *                    @NotNull String nombreUsuario, 
     *                    @NotNull String email, 
     *                    @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
     * 
     * */

 
    
	public UsuarioDto  getUsuarioDto() {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setAbreviaturaSistema("SIEE");
//		loginUserDto.setContrasena(null);
		usuarioDto.setCorreoElectronico("ssilva@midis.gob.pe");
		usuarioDto.setCoUbigeo("150110");
		usuarioDto.setDependencia("ULE DE COMAS");
		usuarioDto.setDiasFaltaCaduca(1283+"");
		usuarioDto.setIdDependencia(65+"");
		usuarioDto.setIdSistema((long)4);
		usuarioDto.setIdUsuario((long)2154);
//		loginUserDto.setListadoRoles(null);
		usuarioDto.setMaternoUsuario("CACHAY");
		usuarioDto.setNombreUsuario("SAUL MILCIADES");
		usuarioDto.setPaternoUsuario("SILVA");
//		loginUserDto.setResult(true);
		usuarioDto.setSistema("SIEE");
		/*
		UbigeoDto ubigeoDto = new UbigeoDto();
		ubigeoDto.setDepartamento("LIMA");
		ubigeoDto.setDistrito("COMAS");
		ubigeoDto.setId("150110");
		ubigeoDto.setProvincia("LIMA");
		ubigeoDto.setUbigeo("150110");
		
		loginUserDto.setUbigeo(ubigeoDto);
		*/
//		usuarioDto.setUsuario("41172516");
		return usuarioDto;
	}
	
    
    
	
	public void inicializarPreferencias(String username, UsuarioDto usuarioDto) {
		logger.info("-INI- inicializarPreferencias");
		Properties propertieUsuario = PropertiesManager.getUsuarioProperties(username);

		if (propertieUsuario == null) {
			this.createInfoUsuarioProperties(username, usuarioDto);
			logger.info("-INI- PROPERTIES "+username+" CREADO.");
		}else {
			this.updateInfoUsuarioProperties(username, usuarioDto);
		}
	}
	
	
	public void createInfoUsuarioProperties(String username, UsuarioDto usuarioDto) {
		logger.info("-INI- createInfoUsuarioProperties");
		
		Properties propertieUsuario = new Properties();
		propertieUsuario.put(PropertiesManager.L_NOMBRE_USUARIO,usuarioDto.getNombreUsuario());
		propertieUsuario.put(PropertiesManager.L_APE_PATERNO,usuarioDto.getPaternoUsuario());
		propertieUsuario.put(PropertiesManager.L_APE_MATERNO,usuarioDto.getMaternoUsuario());
		propertieUsuario.put(PropertiesManager.L_DEPENDENCIA,usuarioDto.getDependencia());
		PropertiesManager.saveUsuarioProperties(propertieUsuario, username);
		logger.info("-INI- PROPERTIES "+username+" CREADO.");
	}
	
	public void updateInfoUsuarioProperties(String username, UsuarioDto usuarioDto) {
		logger.info("-INI- updateInfoUsuarioProperties");
		Properties propertieUsuario = PropertiesManager.getUsuarioProperties(username);

		if (propertieUsuario != null) {
			propertieUsuario.put(PropertiesManager.L_NOMBRE_USUARIO,usuarioDto.getNombreUsuario());
			propertieUsuario.put(PropertiesManager.L_APE_PATERNO,usuarioDto.getPaternoUsuario());
			propertieUsuario.put(PropertiesManager.L_APE_MATERNO,usuarioDto.getMaternoUsuario());
			propertieUsuario.put(PropertiesManager.L_DEPENDENCIA,usuarioDto.getDependencia());
			PropertiesManager.saveUsuarioProperties(propertieUsuario, username);
		}else {
			logger.info("Properties "+username+" no existe.");
			this.createInfoUsuarioProperties(username,  usuarioDto);
		}
	}
}
