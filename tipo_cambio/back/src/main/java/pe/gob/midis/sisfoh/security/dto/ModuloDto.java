package pe.gob.midis.sisfoh.security.dto;

import java.io.Serializable;
import java.util.List;

public class ModuloDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4654031750244799898L;
	private String idModulo;
	private String modulo;
	private String idSistema;
	private String abreviatura;
	private String accesoSeguridad;
	private List<MenuDto> lstMenu;

	
	public ModuloDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModuloDto(String abreviatura, String accesoSeguridad, String idModulo, String idSistema, List<MenuDto> lstMenu) {
		super();
		this.abreviatura = abreviatura;
		this.accesoSeguridad = accesoSeguridad;
		this.idModulo = idModulo;
		this.idSistema = idSistema;
		this.lstMenu = lstMenu;
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

	public String getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public String getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}

	public List<MenuDto> getLstMenu() {
		return lstMenu;
	}

	public void setLstMenu(List<MenuDto> lstMenu) {
		this.lstMenu = lstMenu;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "ModuloDto [idModulo=" + idModulo + ", modulo=" + modulo + ", idSistema=" + idSistema + ", abreviatura="
				+ abreviatura + ", accesoSeguridad=" + accesoSeguridad + ", lstMenu=" + lstMenu + "]";
	}


	
}
