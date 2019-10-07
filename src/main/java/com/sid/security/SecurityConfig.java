package com.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder bcrypte;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DaoAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
		/*
		auth.inMemoryAuthentication().withUser("admin").password(bcrypte.encode("admin"))
		.authorities("ACCESS_PRODUCTS","ACCESS_USERS","ROLE_ADMIN");
		
		auth.inMemoryAuthentication().withUser("user").password(bcrypte.encode("user")).roles("USER");
		
		auth.inMemoryAuthentication().withUser("manager").password(bcrypte.encode("manager"))
		.authorities("ACCESS_PRODUCTS","ROLE_MANAGER");
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin().loginPage("/login").permitAll();
		http.authorizeRequests().antMatchers("/", "/index").permitAll();
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER");
		http.authorizeRequests().antMatchers("/products/**").hasRole("USER");
		http.authorizeRequests().antMatchers("/api/products/**").hasAuthority("ACCESS_PRODUCTS");
		http.authorizeRequests().antMatchers("/api/users/**").hasAuthority("ACCESS_USERS");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring()
		   .antMatchers("/resources/**", "/static/**","/webjars/**", "/favicon.ico");
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(bcrypte);
		authenticationProvider.setUserDetailsService(userDetailsService);
		
		return  authenticationProvider;
	}
	
	
	
	
	
}
