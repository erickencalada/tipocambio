package pe.gob.midis.sisfoh.util;

public class Validador extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4903924374495789768L;
	private int severidad = 2; //0 info, 1 warning, 2 error, 3 fatal 
	public static final int INFO = 0;
	public static final int WARN = 1;
	public static final int ERROR = 2;
	public static final int FATAL = 3;
	

	public Validador(int severidad, String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.severidad = severidad;
	}
	
	/**
	 * @param arg0
	 */
	public Validador(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public Validador(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Validador(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public int getSeveridad() {
		return severidad;
	}

	public void setSeveridad(int severidad) {
		this.severidad = severidad;
	}	
}