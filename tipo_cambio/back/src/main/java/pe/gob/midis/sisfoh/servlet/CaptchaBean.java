package pe.gob.midis.sisfoh.servlet;

import java.io.Serializable;

public class CaptchaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4856070535494953191L;
	private String codigo;
	private String imagem;

	public CaptchaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public CaptchaBean(String codigo, String imagem) {
		super();
		this.codigo = codigo;
		this.imagem = imagem;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "CaptchaBean [codigo=" + codigo + ", imagem=" + imagem + "]";
	}

	
	
}
