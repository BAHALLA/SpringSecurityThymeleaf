package com.sid.userDetais;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sid.entities.User;

public class UserPrincipale implements UserDetails{

	private User user;
	
	 public UserPrincipale(User user) {
		// TODO Auto-generated constructor stub
		 this.user = user ;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		//get user roles
		this.user.getRolesList().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+r));
		});
		
		//get user permissions
		this.user.getPersmissinsList().forEach(p -> {
			authorities.add(new SimpleGrantedAuthority(p));
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.user.getActive() == 1;
	}

}
