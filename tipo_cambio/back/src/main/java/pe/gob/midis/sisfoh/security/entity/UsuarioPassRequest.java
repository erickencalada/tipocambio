package pe.gob.midis.sisfoh.security.entity;

import java.io.Serializable;

public class UsuarioPassRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7647527420456066267L;
	private String nuDni;
	private String pwUsuario;

	public UsuarioPassRequest() {
	}

	public UsuarioPassRequest(String nuDni, String pwUsuario) {
		this.nuDni = nuDni;
		this.pwUsuario = pwUsuario;
	}

	public String getNuDni() {
		return nuDni;
	}

	public void setNuDni(String nuDni) {
		this.nuDni = nuDni;
	}

	public String getPwUsuario() {
		return pwUsuario;
	}

	public void setPwUsuario(String pwUsuario) {
		this.pwUsuario = pwUsuario;
	}

	@Override
	public String toString() {
		return "UsuarioPassRequest{" + "nuDni=" + nuDni + ", pwUsuario=" + pwUsuario + '}';
	}

}
