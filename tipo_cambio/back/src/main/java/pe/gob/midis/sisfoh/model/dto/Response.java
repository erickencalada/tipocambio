package pe.gob.midis.sisfoh.model.dto;

public class Response {
	
	private boolean exito;
	private String code;
	private String description;
	
	
	public Response() {
		super();
	}
	public Response(boolean exito, String code, String description) {
		super();
		this.exito = exito;
		this.code = code;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isExito() {
		return exito;
	}
	public void setExito(boolean exito) {
		this.exito = exito;
	}

}
