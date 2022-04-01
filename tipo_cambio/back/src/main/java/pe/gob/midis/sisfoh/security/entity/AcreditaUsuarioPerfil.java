package pe.gob.midis.sisfoh.security.entity;

import java.io.Serializable;

public class AcreditaUsuarioPerfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7743032684847083397L;
	private String formulario;
	private String control;
	private String link;
	private String esPerfil;

	public String getFormulario() {
		return formulario;
	}

	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEsPerfil() {
		return esPerfil;
	}

	public void setEsPerfil(String esPerfil) {
		this.esPerfil = esPerfil;
	}

}
