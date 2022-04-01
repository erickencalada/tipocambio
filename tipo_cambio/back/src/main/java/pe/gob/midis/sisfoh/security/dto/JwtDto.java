package pe.gob.midis.sisfoh.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private String coUbigeoUle;//ubigeo ule
	private String correoElectronico;
	private String nombreUsuario;
	private String paternoUsuario;
	private String maternoUsuario;
	private String idDependencia;
	private String dependencia;
	private String diasFaltaCaduca;
	private Long idSistema;
	private String sistema;
	private String abreviaturaSistema;
	private UbigeoDto ubigeo;
	private List<RolDto> listadoRoles;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }

    
    public JwtDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

	public String getCoUbigeoUle() {
		return coUbigeoUle;
	}

	public void setCoUbigeoUle(String coUbigeoUle) {
		this.coUbigeoUle = coUbigeoUle;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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

	
}
