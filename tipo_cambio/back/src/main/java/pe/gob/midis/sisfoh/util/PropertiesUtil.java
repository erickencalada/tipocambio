package pe.gob.midis.sisfoh.util;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.midis.sisfoh.security.dto.UsuarioDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;


public class PropertiesUtil {
	private final static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	public static void inicializarPreferencias(String username, UsuarioSeguridadDto usuarioSeguridadDto) {
		logger.info("-INI- inicializarPreferencias");
		Properties propertieUsuario = PropertiesManager.getUsuarioProperties(username);

		if (propertieUsuario == null) {
			createInfoUsuarioProperties(username, usuarioSeguridadDto);
			logger.info("-INI- PROPERTIES "+username+" CREADO.");
		}else {
			updateInfoUsuarioProperties(username, usuarioSeguridadDto);
		}
	}
	
	
	
	public static void createInfoUsuarioProperties(String username, UsuarioSeguridadDto usuarioSeguridadDto) {
		logger.info("-INI- createInfoUsuarioProperties");
		
		Properties propertieUsuario = new Properties();
		propertieUsuario.put(PropertiesManager.L_NOMBRE_USUARIO,usuarioSeguridadDto.getNombreUsuario());
		propertieUsuario.put(PropertiesManager.L_APE_PATERNO,usuarioSeguridadDto.getPaternoUsuario());
		propertieUsuario.put(PropertiesManager.L_APE_MATERNO,usuarioSeguridadDto.getMaternoUsuario());
		propertieUsuario.put(PropertiesManager.L_DEPENDENCIA,usuarioSeguridadDto.getDependencia());
		propertieUsuario.put(PropertiesManager.L_IDUSUARIO,usuarioSeguridadDto.getIdUsuario()+"");
		propertieUsuario.put(PropertiesManager.L_USUARIO,usuarioSeguridadDto.getUsuario());
		propertieUsuario.put(PropertiesManager.L_ID_DEPENDENCIA,usuarioSeguridadDto.getIdDependencia());
		propertieUsuario.put(PropertiesManager.L_COUBIGEO,usuarioSeguridadDto.getCoUbigeo());
		propertieUsuario.put(PropertiesManager.L_CORREO,usuarioSeguridadDto.getCorreoElectronico());
		propertieUsuario.put(PropertiesManager.L_INPASSWORD,usuarioSeguridadDto.getInPassword());
		propertieUsuario.put(PropertiesManager.L_DIAS_FALTA_CADUCA,usuarioSeguridadDto.getDiasFaltaCaduca());
		propertieUsuario.put(PropertiesManager.L_ID_SISTEMA,usuarioSeguridadDto.getIdSistema()+"");
		propertieUsuario.put(PropertiesManager.L_SISTEMA,usuarioSeguridadDto.getSistema());
		propertieUsuario.put(PropertiesManager.L_ABREVIATURA_SISTEMA,usuarioSeguridadDto.getAbreviaturaSistema());
//		propertieUsuario.put(PropertiesManager.L_ROLES, usuarioSeguridadDto.getListadoRoles().toString());
		propertieUsuario.put(PropertiesManager.L_ROLES, usuarioSeguridadDto.getListadoRolestxt().toString());
		
		PropertiesManager.saveUsuarioProperties(propertieUsuario, username);
		logger.info("-INI- PROPERTIES "+username+" CREADO.");
	}

	
	
	public static void updateInfoUsuarioProperties(String username, UsuarioSeguridadDto usuarioSeguridadDto) {
		logger.info("-INI- updateInfoUsuarioProperties");
		Properties propertieUsuario = PropertiesManager.getUsuarioProperties(username);

		if (propertieUsuario != null) {
			propertieUsuario.put(PropertiesManager.L_NOMBRE_USUARIO,usuarioSeguridadDto.getNombreUsuario());
			propertieUsuario.put(PropertiesManager.L_APE_PATERNO,usuarioSeguridadDto.getPaternoUsuario());
			propertieUsuario.put(PropertiesManager.L_APE_MATERNO,usuarioSeguridadDto.getMaternoUsuario());
			propertieUsuario.put(PropertiesManager.L_DEPENDENCIA,usuarioSeguridadDto.getDependencia());
			propertieUsuario.put(PropertiesManager.L_IDUSUARIO,usuarioSeguridadDto.getIdUsuario()+"");
			propertieUsuario.put(PropertiesManager.L_USUARIO,usuarioSeguridadDto.getUsuario());
			propertieUsuario.put(PropertiesManager.L_ID_DEPENDENCIA,usuarioSeguridadDto.getIdDependencia());
			propertieUsuario.put(PropertiesManager.L_COUBIGEO,usuarioSeguridadDto.getCoUbigeo());
			propertieUsuario.put(PropertiesManager.L_CORREO,usuarioSeguridadDto.getCorreoElectronico());
			propertieUsuario.put(PropertiesManager.L_INPASSWORD,usuarioSeguridadDto.getInPassword());
			propertieUsuario.put(PropertiesManager.L_DIAS_FALTA_CADUCA,usuarioSeguridadDto.getDiasFaltaCaduca());
			propertieUsuario.put(PropertiesManager.L_ID_SISTEMA,usuarioSeguridadDto.getIdSistema()+"");
			propertieUsuario.put(PropertiesManager.L_SISTEMA,usuarioSeguridadDto.getSistema());
			propertieUsuario.put(PropertiesManager.L_ABREVIATURA_SISTEMA,usuarioSeguridadDto.getAbreviaturaSistema());
//			propertieUsuario.put(PropertiesManager.L_ROLES, usuarioSeguridadDto.getListadoRoles().toString());
			propertieUsuario.put(PropertiesManager.L_ROLES, usuarioSeguridadDto.getListadoRolestxt().toString());
			PropertiesManager.saveUsuarioProperties(propertieUsuario, username);
		}else {
			logger.info("Properties "+username+" no existe.");
			createInfoUsuarioProperties(username,  usuarioSeguridadDto);
		}
	}

	public synchronized static String[] getRoles(String username) {
		    String roles[] = null;
			String s = getPropertiesValue(username, PropertiesManager.L_ROLES);
			
			if (s != null) {
				
				s = s.split("\\[")[1];
				s = s.split("\\]")[0];
				System.out.println("s: "+s);
				
				StringTokenizer stk = new StringTokenizer(s, ",");
				Vector<String> tokens = new Vector<String>();
//				tokens.add("OTRAS INSTITUCIONES");
				while (stk.hasMoreTokens()) {
					tokens.addElement(stk.nextToken().trim());
				}
				roles = new String[tokens.size()];
				tokens.toArray(roles);
			}
		return roles;
	}
	
	
	public static String getPropertiesValue(String username,  String key){
		String output = null;
		
		if(PropertiesManager.getUsuarioProperties(username) == null) {
			System.err.println(""+username+".properties no existe.");
			return null;
		
		}
		
		output = PropertiesManager.getUsuarioProperties(username).getProperty(key);
		if(output == null) {
			System.err.println(username+"."+key+" sin valor.");
			return null;
		}
			
		output = output.trim().length()<=0?null:output.trim();
		return output;
	}
}
