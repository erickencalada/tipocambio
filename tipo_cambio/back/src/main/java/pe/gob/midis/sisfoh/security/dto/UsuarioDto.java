package pe.gob.midis.sisfoh.security.dto;

import java.util.List;

public class UsuarioDto {
	private Long idUsuario;
	private String usuario;
	private String nombreUsuario;
	private String paternoUsuario;
	private String maternoUsuario;
	private String idDependencia;
	private String dependencia;
	private String coUbigeo;
	private String correoElectronico;
	private String inPassword;
	private String diasFaltaCaduca;
	private Long idSistema;
	private String sistema;
	private String abreviaturaSistema;
	private UbigeoDto ubigeo;
	private List<String> listadoRoles;
	private String contrasena;
	private Boolean result;
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
	public List<String> getListadoRoles() {
		return listadoRoles;
	}
	public void setListadoRoles(List<String> listadoRoles) {
		this.listadoRoles = listadoRoles;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	
	
	
}
