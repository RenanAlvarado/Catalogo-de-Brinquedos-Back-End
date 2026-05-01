package br.edu.fatecgru.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	private Key getKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}

	public String extrairEmail(String token) {
		return Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validarToken(String token) {
		try {
			Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String gerarToken(String email, String tipo) {
		return Jwts.builder().setSubject(email).claim("role", tipo).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(getKey()).compact();
	}

	public String extrairRole(String token) {
		return Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token).getBody().get("role", String.class);
	}
}