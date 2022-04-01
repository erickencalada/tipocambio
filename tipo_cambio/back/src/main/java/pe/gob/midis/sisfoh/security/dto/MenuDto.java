package pe.gob.midis.sisfoh.security.dto;

import java.io.Serializable;
import java.util.List;

public class MenuDto  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9179592451989925601L;
	private String idMenu;
	private String menu;
	private String abreviatura;
	private String ruta;
	private String accesoSeguridad;
	private List<OpcionDto> lstOpcion;
	
	public MenuDto(String idMenu, String abreviatura, String accesoSeguridad, String menu, String ruta) {
		super();
		this.idMenu = idMenu;
		this.abreviatura = abreviatura;
		this.accesoSeguridad = accesoSeguridad;
		this.menu = menu;
		this.ruta = ruta;
	}

	
	
	public MenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<OpcionDto> getLstOpcion() {
		return lstOpcion;
	}

	public void setLstOpcion(List<OpcionDto> lstOpcion) {
		this.lstOpcion = lstOpcion;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", abreviatura=" + abreviatura + ", accesoSeguridad=" + accesoSeguridad
				+ ", menu=" + menu + ", ruta=" + ruta + "]";
	}

	
}
