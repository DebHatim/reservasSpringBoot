package com.debboun.reservas.config;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.debboun.reservas.entidades.Usuario;

public class UsuarioPrincipal implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private final Usuario usuario;
	
	public UsuarioPrincipal(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(usuario.getRol())); // convierte el rol a string que Spring Security entiende
	}

	@Override
	public @Nullable String getPassword() { // metodo para sacar la contraseña
		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {return true;}
	@Override
	public boolean isAccountNonLocked() {return true;}
	@Override
	public boolean isCredentialsNonExpired() {return true;}
	@Override
	public boolean isEnabled() {return true;}
	
	public String getNombreCompleto() {
		return usuario.getPersona().getNombre() + " " + usuario.getPersona().getApellido();
	}

}
