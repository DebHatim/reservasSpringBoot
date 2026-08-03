package com.debboun.reservas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
						// Zona publica
						.requestMatchers("/", "/signin/**", "/login**", "/hotel/**", "/perfil/**",
								"/css/**", "/js/**", "/favicon.ico").permitAll()
						// Panel de administracion: solo ROLE_ADMIN
						.requestMatchers("/admin/**").hasRole("ADMIN")
						// Endpoints REST de Spring Data REST: solo ROLE_ADMIN
						.requestMatchers("/usuarios/**", "/personas/**", "/reservas/**",
								"/habitaciones/**", "/valoraciones/**", "/hoteles/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/", true)
						.permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/").permitAll());

		return http.build();
	}
}