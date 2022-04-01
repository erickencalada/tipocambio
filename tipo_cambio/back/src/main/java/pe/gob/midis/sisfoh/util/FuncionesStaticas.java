/**
 * 
 */
package pe.gob.midis.sisfoh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/*
 * CLASE CON FUNCIONES ESTATICAS DE MAYOR USO
 * 
 */
public class FuncionesStaticas implements Serializable {

	private static final long serialVersionUID = -3692694124375896948L;

	/**
	 * 
	 * @param a Objeto Destino
	 * @param b Objeto Origen
	 */
	public static void copyPropertiesObject(Object a, Object b) {
		try {
			if (a == null || b == null)
				return;
			Field camposdea[] = b.getClass().getDeclaredFields();
			for (int i = 0; i < camposdea.length; i++) {
				String camponame = camposdea[i].getName();
				String sgetMetod = "get" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
				String ssetMetod = "set" + Character.toUpperCase(camponame.charAt(0)) + camponame.substring(1);
				Class<?>[] types = new Class[] {};
				try {
					Method method = b.getClass().getMethod(sgetMetod, types);
					Object valuecampoa = method.invoke(b, new Object[0]);
					Class<?> types2 = camposdea[i].getType();
					Method method2 = a.getClass().getMethod(ssetMetod, types2);
					method2.invoke(a, valuecampoa);
				} catch (NoSuchMethodException exception) {
					// // ("Error NoSuchMethodException: " + exception.getMessage());
				}
			}
		} catch (Exception e) {
			// ("Error exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getMimeName(String name) {
		String mime = "";
		int extDot = name.lastIndexOf('.');
		if (extDot > 0) {
			String extension = name.substring(extDot + 1).toLowerCase();
			if ("bmp".equals(extension)) {
				mime = "image/bmp";
			} else if ("jpg".equals(extension)) {
				mime = "image/jpeg";
			} else if ("gif".equals(extension)) {
				mime = "image/gif";
			} else if ("png".equals(extension)) {
				mime = "image/png";
			} else if ("docx".equals(extension)) {
				mime = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
			} else if ("xlsx".equals(extension)) {
				mime = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
			} else if ("xls".equals(extension)) {
				mime = "application/vnd.ms-excel";
			} else if ("xml".equals(extension)) {
				mime = "application/xml";
			} else if ("pdf".equals(extension)) {
				mime = "application/pdf";
			} else if ("doc".equals(extension)) {
				mime = "application/msword";
			} else if ("zip".equals(extension)) {
				mime = "application/zip";
			} else if ("tar".equals(extension)) {
				mime = "application/x-tar";
			} else if ("rar".equals(extension)) {
				mime = "application/rar";
			} else {
				mime = "image/unknown";
			}
		}
		return mime;
	}

	public static String getfechaLargaFormateada(Timestamp fec) {
		if (fec == null)
			return "";
		SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm a");
		int S = 0, M = 0, A = 0, D = 0;
		Date fechax = new Date(fec.getTime());
		Calendar f = Calendar.getInstance();
		f.setTime(fechax);
		String di[] = { "", "DOMINGO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" };
		String me[] = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE",
				"OCTUBRE", "NOVIEMBRE", "DICIEMBRE" };
		S = f.get(Calendar.DAY_OF_WEEK);
		M = f.get(Calendar.MONTH);
		D = f.get(Calendar.DAY_OF_MONTH);
		A = f.get(Calendar.YEAR);
		String horaS = sdfHora.format(fechax);
		return di[S] + " " + D + " DE " + me[M] + " DEL " + A + " A LAS " + horaS + " HORAS.";
	}

	public static String getSFechaLargaFormateada(Timestamp fec) {
		if (fec == null)
			return "";

		SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss aa");// CCH: 10052019 10:58 AM
		int S = 0, M = 0, A = 0, D = 0;
		Date fechax = new Date(fec.getTime());
		Calendar f = Calendar.getInstance();
		f.setTime(fechax);
		String di[] = { "", "DOMINGO", "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" };
		String me[] = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE",
				"OCTUBRE", "NOVIEMBRE", "DICIEMBRE" };
		S = f.get(Calendar.DAY_OF_WEEK);
		M = f.get(Calendar.MONTH);
		D = f.get(Calendar.DAY_OF_MONTH);
		A = f.get(Calendar.YEAR);
		String hora = sdfHora.format(fechax);
		return di[S] + " " + D + " DE " + me[M] + " DEL " + A;
	}

	// ASANCHEZ
	public static String formatearCadena(String cadena) {
		if (cadena == null)
			return "";

		if (cadena.trim().equals(""))
			return "";

		String resultado = "";
		StringTokenizer st = new StringTokenizer(cadena);
		while (st.hasMoreTokens()) {
			resultado = resultado + st.nextToken() + " ";
		}

		return resultado.trim();
	}

	public static Timestamp getDiaMasUno(Timestamp diafin) {
		if (diafin == null)
			return null;
		GregorianCalendar calFin = new GregorianCalendar();
		// long unDia = 1000 * 60 * 60 * 24;
		calFin.setTimeInMillis(diafin.getTime());
		calFin.set(calFin.get(Calendar.YEAR), calFin.get(Calendar.MONTH), calFin.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calFin.set(Calendar.MILLISECOND, 0);
		calFin.add(Calendar.DAY_OF_MONTH, 1);
		Timestamp diafinfinal = new Timestamp(calFin.getTimeInMillis());
		return diafinfinal;
	}

	public static void copyFile(File sourceFile, File destFile) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(sourceFile);
			out = new FileOutputStream(destFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (Exception e) {
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static String convertStreamToStr(InputStream is) throws IOException {

		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				if (reader.ready()) {
					while ((n = reader.read(buffer)) != -1) {
						writer.write(buffer, 0, n);
					}
				} else {
					return "";
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	public static Timestamp StringToTimestamp(String fecha, String formato) {
		Timestamp timestamp = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			Date parsedDate = dateFormat.parse(fecha);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (Exception e) { // this generic but you can control another types of exception
			System.err.println("ERROR INESPERADO: " + e.getMessage());
		}
		return timestamp;
	}

	public static String timestampToString(Timestamp fecha, String formato) {
		String fechaString = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
			fechaString = dateFormat.format(new java.sql.Date(fecha.getTime()));

		} catch (Exception e) {
			System.err.println("ERROR INESPERADO: " + e.getMessage());
		}
		return fechaString;
	}

	public static Boolean isInteger(String txt) {
		Boolean respuesta = false;
		try {
			int numero = Integer.valueOf(txt);
			respuesta = true;
		} catch (Exception e) {
			respuesta = false;
		}
		return respuesta;
	}

}