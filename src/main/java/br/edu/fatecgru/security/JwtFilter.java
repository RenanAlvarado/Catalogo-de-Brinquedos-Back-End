package br.edu.fatecgru.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			String token = header.substring(7);

			try {
				if (jwtUtil.validarToken(token)) {

					String email = jwtUtil.extrairEmail(token);

					if (SecurityContextHolder.getContext().getAuthentication() == null) {

						String role = jwtUtil.extrairRole(token);

						String normalizedRole = role.toUpperCase();

						if (!normalizedRole.startsWith("ROLE_")) {
							normalizedRole = "ROLE_" + normalizedRole;
						}

						List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(normalizedRole));

						UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, null,
								authorities);
						SecurityContextHolder.getContext().setAuthentication(auth);

					}
				}
			} catch (Exception e) {
				// opcional: logar erro
			}
		}

		filterChain.doFilter(request, response);
	}
}
