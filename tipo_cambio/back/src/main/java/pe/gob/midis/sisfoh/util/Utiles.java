package pe.gob.midis.sisfoh.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utiles {

	public static class Constante {
		public static final String Cant_Zona_Lista = "CANT_ZONA_LISTA";

	}

	public static class Errores {
		public static final String Cant_Zona_Lista_excedidas = "El Numero de zonas es mayor a las permitidas";
		public static final String Elemento_existe = "El Elemento ya existe";

	}

	public static class Formatos {
		public static final String Fecha_Formato_ddmmyyyy = "dd/MM/yyyy";
		public static final String Fecha_Formato_ddmmyyyy_Hora = "dd/MM/yyyy HH:mm:ss";
		public static final String Local_Fecha_Formato_ddmmyyyy = "dd/MM/yyyy";
		public static final SimpleDateFormat Fecha_ddmmyyyy = new SimpleDateFormat(Formatos.Fecha_Formato_ddmmyyyy);
		public static final DateTimeFormatter Local_Fecha_ddmmyyyy = DateTimeFormatter
				.ofPattern(Formatos.Local_Fecha_Formato_ddmmyyyy);

		public static final String Fecha_Formato_yyyyMMdd = "yyyy-MM-dd";
		public static final DateTimeFormatter DateTimeFormatter_ddmmyyyy = DateTimeFormatter
				.ofPattern(Formatos.Fecha_Formato_yyyyMMdd);
		public static final SimpleDateFormat Fecha_yyyyMMdd = new SimpleDateFormat(Formatos.Fecha_Formato_yyyyMMdd);
		public static final LocalDateTime LocalDateTime_yyyyMMdd = null;

		public static final String Local_Fecha_Formato_ddmmyyyy_2 = "d/MM/uuuu";
		public static final DateTimeFormatter Local_Fecha_ddmmyyyy_2 = DateTimeFormatter.ofPattern("d/MM/uuuu");
		public static final DateTimeFormatter Local_Fecha_ddmmyyyy_hora_min = DateTimeFormatter.ofPattern("d/MM/uuuu HH.mm.ss");
		public static final DateTimeFormatter Local_Fecha_yyyymmdd = DateTimeFormatter.ofPattern("uuuu-MM-dd");
	}

	public static class ParametrosServicio {
		public static final String todo = "*";
		public static final int todoNumeric = -1;
		public static final String todoText = "-1";
	}

	public static class TipoOperacion {
		public static final String agregar = "Agregar";
		public static final String editar = "Editar";
		public static final String listar = "Listar";
	}

}
