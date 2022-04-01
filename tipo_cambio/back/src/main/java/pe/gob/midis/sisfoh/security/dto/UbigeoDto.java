package pe.gob.midis.sisfoh.security.dto;

public class UbigeoDto {

	private String id;
	private String departamento;
	private String provincia;
	private String distrito;
	private String ubigeo;
	public UbigeoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UbigeoDto(String id, String departamento, String provincia, String distrito, String ubigeo) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.ubigeo = ubigeo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	@Override
	public String toString() {
		return "UbigeoDto [id=" + id + ", departamento=" + departamento + ", provincia=" + provincia + ", distrito="
				+ distrito + ", ubigeo=" + ubigeo + "]";
	}
	
	
	
}
