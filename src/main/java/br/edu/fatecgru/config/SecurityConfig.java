package br.edu.fatecgru.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.fatecgru.security.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.cors(cors -> {
		}).csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(auth -> auth

						// público
						.requestMatchers(HttpMethod.POST, "/api/usuarios/login", "/api/usuarios/cadastro").permitAll()
						.requestMatchers("/uploads/**").permitAll().requestMatchers(HttpMethod.GET, "/api/**")
						.permitAll()

						// ADMIN
						.requestMatchers(HttpMethod.POST, "/api/brinquedos/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/brinquedos/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/brinquedos/**").hasRole("ADMIN")

						.requestMatchers(HttpMethod.PUT, "/api/categorias/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/categorias/**").hasRole("ADMIN")

						.anyRequest().authenticated())

				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}