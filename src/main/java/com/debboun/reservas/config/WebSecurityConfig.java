package com.debboun.reservas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Autorizacion
@EnableWebSecurity
public class WebSecurityConfig  {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // Usar Bcrypt para encriptar las contraseñas
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				
				auth -> auth // Definicion de zona publica, asteriscos dobles en css y js para cubrir subcarpetas
				.requestMatchers("/", "/signin/**", "/login**", "/css/**", "/js/**", "/favicon.ico").permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/",true).permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/").permitAll());

		return http.build();
	}
}
