package pe.gob.midis.sisfoh.security.entity;

import java.io.Serializable;

public class AcreditaUsuarioResponse implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -367227471641834348L;
	
	private String coResul;
	    private String deResul;
	    private UsuarioResponse usuario;

	    public AcreditaUsuarioResponse() {
	    }

	    public AcreditaUsuarioResponse(String coResul, String deResul, UsuarioResponse usuario) {
	        this.coResul = coResul;
	        this.deResul = deResul;
	        this.usuario = usuario;
	    }
	    
	    public String getCoResul() {
	        return coResul;
	    }

	    public void setCoResul(String coResul) {
	        this.coResul = coResul;
	    }

	    public String getDeResul() {
	        return deResul;
	    }

	    public void setDeResul(String deResul) {
	        this.deResul = deResul;
	    }

	    public UsuarioResponse getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(UsuarioResponse usuario) {
	        this.usuario = usuario;
	    }   

	    @Override
	    public String toString() {
	        return "AcreditaUsuarioResponse{" + "coResul=" + coResul + ", deResul=" + deResul + ", usuario=" + usuario + '}';
	    }
	 
}
