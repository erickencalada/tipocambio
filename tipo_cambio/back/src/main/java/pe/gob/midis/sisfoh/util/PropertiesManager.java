/**
 * 
 */
package pe.gob.midis.sisfoh.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Vector;

/**
 * Clase para el manejo de las constantes del Sistema.
 *  
 * 
 */
public class PropertiesManager implements Serializable {

	private final static Logger logger = LoggerFactory.getLogger(PropertiesManager.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 6902971621524908967L;
	private static Properties propertieSistema = null;
	private static final String archivo = "pe.gob.midis.sisfoh.util.Rutas";
	private static ResourceBundle bundle = null;
	private static ResourceBundle msgbundle = null;
	private static String rootfolder = null;
	public static final String L_NOMBRE_USUARIO = "nombre_usuario";
	public static final String L_APE_PATERNO = "apellido_paterno";
	public static final String L_APE_MATERNO = "apellido_materno";
	public static final String L_DEPENDENCIA = "dependencia";
	
	public static final String L_IDUSUARIO = "id_usuario";
	public static final String L_USUARIO = "usuario";
	public static final String L_ID_DEPENDENCIA = "id_dependencia";
	public static final String L_COUBIGEO = "coubigeo";
	public static final String L_CORREO = "correo";
	public static final String L_INPASSWORD = "inpassword";
	public static final String L_DIAS_FALTA_CADUCA = "dias_falta_caduca";
	public static final String L_ID_SISTEMA = "id_sistema";
	public static final String L_SISTEMA = "sistema";
	public static final String L_ABREVIATURA_SISTEMA = "abreviatura_sistema";
	public static final String L_ROLES = "roles";
	
	private static String CATEGORIAS_INSTITUCIONES[] = null;
	
	public static Properties getUsuarioProperties(String usuario) {
		    Properties propertieUsuario = null;
			String PROPERTIE_USUARIO = usuario + ".properties";
			File propertiesfile = new File(getROOTPROPERTIES()+ System.getProperty("file.separator") + PROPERTIE_USUARIO);
			
			if(propertiesfile != null) {
				if (propertiesfile.exists()) {

					FileInputStream input = null;
					propertieUsuario = new Properties();
					try {
						input = new FileInputStream(propertiesfile);
						propertieUsuario.load(input);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (null != input)
							try {
								input.close();
							} catch (IOException e) {
								logger.info("-ERROR INESPERADO: "+e.getMessage());
							}
					}
				} else {					
					logger.info("PROPERTIES NO EXISTE");
				}
			}
		
		return propertieUsuario;
	}
	
	public static String getROOTPROPERTIES() {
//		String sdirpropiedades = getROOTDIR()+ System.getProperty("file.separator")+ bundle.getString("RUTA_PROPERTIES");
		String sdirpropiedades = getROOTDIR();
		File roodirfile = new File(sdirpropiedades);
		if(!roodirfile.exists()){
			roodirfile.mkdirs();
		}
		return sdirpropiedades;
	}
	
	
	public static String getROOTDIR() {
		if (rootfolder == null) {
			rootfolder = 	"/constatessisfoh";
		}
		return rootfolder;
	}

	
	public synchronized static void saveUsuarioProperties(Properties p, String usuario) {
		
		String PROPERTIE_USUARIO = usuario + ".properties";
		File propertiesfile = new File(getROOTPROPERTIES()+ System.getProperty("file.separator") + PROPERTIE_USUARIO);

		FileOutputStream ouput = null;
		try {
			ouput = new FileOutputStream(propertiesfile);
			p.store(ouput, "PREFERENCIAS DEL USUARIO " + usuario);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != ouput)
				try {
					ouput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	public static Properties deletetUsuarioProperties(String usuario) {
		Properties propertieUsuario = null;
		
		if (propertieUsuario == null) {
			String PROPERTIE_USUARIO = usuario + ".properties";
			File propertiesfile = new File(getROOTPROPERTIES()+ System.getProperty("file.separator") + PROPERTIE_USUARIO);
			
			if(propertiesfile != null) {
				if (propertiesfile.exists()) {
					boolean esborrado = propertiesfile.delete();
					logger.info("esborrado: "+esborrado);
				
				} else {
					logger.error("propertiesfile no existe.");
				}
			}
		}
		return propertieUsuario;
	}

}
