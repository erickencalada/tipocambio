package pe.gob.midis.sisfoh.security.service;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.gob.midis.sisfoh.security.dto.UsuarioDto;
import pe.gob.midis.sisfoh.util.PropertiesManager;


@Service
public class UsuarioPropertiesService {
	private final static Logger logger = LoggerFactory.getLogger(UsuarioPropertiesService.class);
	
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
