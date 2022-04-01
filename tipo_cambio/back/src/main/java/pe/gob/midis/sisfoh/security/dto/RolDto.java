package pe.gob.midis.sisfoh.security.dto;

import java.io.Serializable;
import java.util.List;

public class RolDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5959971058042131629L;
	private Long idRol;
	private String rol;
	private String accesoSeguridad;
	private Long idSistema;
	private String esRol;// 0 no seleccion ; 1:rol seleccion.
	private List<ModuloDto> lstModulo;
	
	public RolDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolDto(Long idRol, String accesoSeguridad, Long idSistema, String rol, List<ModuloDto> lstModulo) {
		super();
		this.idRol = idRol;
		this.accesoSeguridad = accesoSeguridad;
		this.idSistema = idSistema;
		this.rol = rol;
		this.lstModulo = lstModulo;
	}

	public String getAccesoSeguridad() {
		return accesoSeguridad;
	}

	public void setAccesoSeguridad(String accesoSeguridad) {
		this.accesoSeguridad = accesoSeguridad;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<ModuloDto> getLstModulo() {
		return lstModulo;
	}

	public void setLstModulo(List<ModuloDto> lstModulo) {
		this.lstModulo = lstModulo;
	}

	
	
	public String getEsRol() {
		return esRol;
	}

	public void setEsRol(String esRol) {
		this.esRol = esRol;
	}

	@Override
	public String toString() {
		return "RolDto [idRol=" + idRol + ", rol=" + rol + ", accesoSeguridad=" + accesoSeguridad + ", idSistema="
				+ idSistema + ", lstModulo=" + lstModulo + ", esRol=" + esRol + "]";
	}


	
	
}
