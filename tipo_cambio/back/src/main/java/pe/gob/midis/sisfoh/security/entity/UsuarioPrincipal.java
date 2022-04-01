package pe.gob.midis.sisfoh.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.gob.midis.sisfoh.security.dto.UbigeoDto;
import pe.gob.midis.sisfoh.security.dto.UsuarioSeguridadDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8093762021376869641L;
	
	 private String nombreUsuario;
	 private String usuario;
	 private String correoElectronico;
	 private String password;
	 private UsuarioSeguridadDto usuarioSeguridadDto;
     private Collection<? extends GrantedAuthority> authorities;

    
    
 

    public UsuarioPrincipal(String nombreUsuario, String usuario, String correoElectronico,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.usuario = usuario;
		this.correoElectronico = correoElectronico;
		this.authorities = authorities;
	}



	public UsuarioPrincipal(UsuarioSeguridadDto usuarioSeguridadDto) {
		super();
		this.usuarioSeguridadDto = usuarioSeguridadDto;
		this.usuario = usuarioSeguridadDto.getUsuario();
	}
	
	
	public UsuarioPrincipal(UsuarioSeguridadDto usuarioSeguridadDto, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.usuarioSeguridadDto = usuarioSeguridadDto;
		this.authorities = authorities;
		this.usuario = usuarioSeguridadDto.getUsuario();
	}
	
    public static UsuarioPrincipal build(UsuarioSeguridadDto usuarioSeguridadDto){
//        List<GrantedAuthority> authorities =
//        		usuarioSeguridadDto.getListadoRoles().stream().map(rolDto -> 
//        		new SimpleGrantedAuthority(rolDto.getIdRol()+"$"+rolDto.getRol())).collect(Collectors.toList());

        List<GrantedAuthority> authorities =
        		usuarioSeguridadDto.getListadoRoles().stream().map(rolDto -> 
        		new SimpleGrantedAuthority(rolDto.getRol())).collect(Collectors.toList());

        UsuarioPrincipal usuarioPrincipal = new UsuarioPrincipal(usuarioSeguridadDto,authorities);
        
        return usuarioPrincipal;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	public UsuarioSeguridadDto getUsuarioSeguridadDto() {
		return usuarioSeguridadDto;
	}

	public void setUsuarioSeguridadDto(UsuarioSeguridadDto usuarioSeguridadDto) {
		this.usuarioSeguridadDto = usuarioSeguridadDto;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
    
}
