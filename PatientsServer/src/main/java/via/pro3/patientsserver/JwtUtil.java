package via.pro3.patientsserver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

  private final String SECRET_KEY = "YourSuperSecureSecretKey1234567890123456";

  private Key getSigningKey() {
    // Use HMAC-SHA key with the correct size
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }

  public Claims extractClaims(String token) {
    return Jwts.parser()
        .setSigningKey(getSigningKey()) // Set the signing key
        .build() // Build the parser
        .parseClaimsJws(token) // Parse the JWT
        .getBody(); // Extract claims
  }
  public String generateToken(String cpr) {
    // Set the JWT expiration time (e.g., 10 hours)
    long expirationTime = 1000 * 60 * 60 * 10; // 10 hours

    // Create the JWT token
    return Jwts.builder()
        .setSubject(cpr) // Set the CPR as the subject (or username)
        .setIssuedAt(new Date()) // Set the issue date
        .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Set expiration date
        .signWith(getSigningKey()) // Sign the token with the secret key
        .compact(); // Build and compact the token
  }

  public String extractUsername(String token) {
    return extractClaims(token).getSubject(); // Extract 'subject' field from JWT
  }
}
