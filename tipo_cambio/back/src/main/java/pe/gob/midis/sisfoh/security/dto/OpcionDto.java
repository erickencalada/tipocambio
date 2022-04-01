package pe.gob.midis.sisfoh.security.dto;

import java.io.Serializable;

public class OpcionDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7697875481782527493L;
	private String idOpcion;
	private String opcion;
	private String abreviatura;
	private String accesoSeguridad;
	private String ruta;

	
	
	public OpcionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpcionDto(String abreviatura, String accesoSeguridad, String idOpcion, String opcion, String ruta) {
		super();
		this.abreviatura = abreviatura;
		this.accesoSeguridad = accesoSeguridad;
		this.idOpcion = idOpcion;
		this.opcion = opcion;
		this.ruta = ruta;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getAccesoSeguridad() {
		return accesoSeguridad;
	}

	public void setAccesoSeguridad(String accesoSeguridad) {
		this.accesoSeguridad = accesoSeguridad;
	}

	public String getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(String idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Opcion [abreviatura=" + abreviatura + ", accesoSeguridad=" + accesoSeguridad + ", idOpcion=" + idOpcion
				+ ", opcion=" + opcion + ", ruta=" + ruta + "]";
	}

	
}
