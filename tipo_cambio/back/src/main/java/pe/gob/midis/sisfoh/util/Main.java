package pe.gob.midis.sisfoh.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fecha ="2021-10-04";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.ENGLISH);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd",Locale.ROOT);	
		LocalDateTime dateTime = LocalDate.parse(fecha, formatter).atStartOfDay();
		
		System.out.println(dateTime);

	}

}
