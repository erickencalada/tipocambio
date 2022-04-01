package pe.gob.midis.sisfoh.security.dto;

import java.io.Serializable;
import java.util.List;


public class UsuarioSeguridadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2732239159605880057L;
	private Long idUsuario;
	private String usuario;
	private String nombreUsuario;
	private String paternoUsuario;
	private String maternoUsuario;
	private String idDependencia;
	private String dependencia;
	private String coUbigeo;//ubigeo ule
	private String correoElectronico;
	private String inPassword;
	private String diasFaltaCaduca;
	private Long idSistema;
	private String sistema;
	private String abreviaturaSistema;
	private UbigeoDto ubigeo;
	private List<RolDto> listadoRoles;
	private List<String> listadoRolestxt;
	private String contrasena;
	
	public UsuarioSeguridadDto() {
		super();
		// TODO Auto-generated constructor stub
	}





	public UsuarioSeguridadDto(Long idUsuario, String usuario, String nombreUsuario, String paternoUsuario,
			String maternoUsuario, String idDependencia, String dependencia, String coUbigeo, String correoElectronico,
			String inPassword, String diasFaltaCaduca, Long idSistema, String sistema, String abreviaturaSistema,
			UbigeoDto ubigeo, List<RolDto> listadoRoles) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.nombreUsuario = nombreUsuario;
		this.paternoUsuario = paternoUsuario;
		this.maternoUsuario = maternoUsuario;
		this.idDependencia = idDependencia;
		this.dependencia = dependencia;
		this.coUbigeo = coUbigeo;
		this.correoElectronico = correoElectronico;
		this.inPassword = inPassword;
		this.diasFaltaCaduca = diasFaltaCaduca;
		this.idSistema = idSistema;
		this.sistema = sistema;
		this.abreviaturaSistema = abreviaturaSistema;
		this.ubigeo = ubigeo;
		this.listadoRoles = listadoRoles;
	}
	
	
	
	

	public UsuarioSeguridadDto(String usuario, String contrasena, Long idSistema) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.idSistema = idSistema;
	}





	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPaternoUsuario() {
		return paternoUsuario;
	}

	public void setPaternoUsuario(String paternoUsuario) {
		this.paternoUsuario = paternoUsuario;
	}

	public String getMaternoUsuario() {
		return maternoUsuario;
	}

	public void setMaternoUsuario(String maternoUsuario) {
		this.maternoUsuario = maternoUsuario;
	}

	public String getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getCoUbigeo() {
		return coUbigeo;
	}

	public void setCoUbigeo(String coUbigeo) {
		this.coUbigeo = coUbigeo;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getInPassword() {
		return inPassword;
	}

	public void setInPassword(String inPassword) {
		this.inPassword = inPassword;
	}

	public String getDiasFaltaCaduca() {
		return diasFaltaCaduca;
	}

	public void setDiasFaltaCaduca(String diasFaltaCaduca) {
		this.diasFaltaCaduca = diasFaltaCaduca;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getAbreviaturaSistema() {
		return abreviaturaSistema;
	}

	public void setAbreviaturaSistema(String abreviaturaSistema) {
		this.abreviaturaSistema = abreviaturaSistema;
	}

	public UbigeoDto getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(UbigeoDto ubigeo) {
		this.ubigeo = ubigeo;
	}

	public List<RolDto> getListadoRoles() {
		return listadoRoles;
	}

	public void setListadoRoles(List<RolDto> listadoRoles) {
		this.listadoRoles = listadoRoles;
	}

	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public List<String> getListadoRolestxt() {
		return listadoRolestxt;
	}

	public void setListadoRolestxt(List<String> listadoRolestxt) {
		this.listadoRolestxt = listadoRolestxt;
	}

	@Override
	public String toString() {
		return "UsuarioSeguridadDto [idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombreUsuario="
				+ nombreUsuario + ", paternoUsuario=" + paternoUsuario + ", maternoUsuario=" + maternoUsuario
				+ ", idDependencia=" + idDependencia + ", dependencia=" + dependencia + ", coUbigeo=" + coUbigeo
				+ ", correoElectronico=" + correoElectronico + ", inPassword=" + inPassword + ", diasFaltaCaduca="
				+ diasFaltaCaduca + ", idSistema=" + idSistema + ", sistema=" + sistema + ", abreviaturaSistema="
				+ abreviaturaSistema + ", ubigeo=" + ubigeo + ", listadoRoles=" + listadoRoles + "]";
	}

}
