package pe.gob.midis.sisfoh.security.entity;

import java.util.List;

public class UsuarioResponse {

	private String acreditado;
	private String ubigeo;
	private String email;
	private List<AcreditaUsuarioPerfil> perfiles;

	public String getAcreditado() {
		return acreditado;
	}

	public void setAcreditado(String acreditado) {
		this.acreditado = acreditado;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AcreditaUsuarioPerfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<AcreditaUsuarioPerfil> perfiles) {
		this.perfiles = perfiles;
	}

}
