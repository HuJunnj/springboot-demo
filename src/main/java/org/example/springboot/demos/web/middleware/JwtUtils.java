package org.example.springboot.demos.web.middleware;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    // Secret key for signing and verifying JWT
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 256-bit key for HS256

    // Token expiration time (1 day in milliseconds)
    private static final long EXPIRATION_TIME = 86400000L;

    /**
     * Generate JWT token for a given username.
     *
     * @param username The username for which the token is generated
     * @return A JWT token as a String
     */
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // Set the subject (username) of the token
                .setIssuedAt(new Date())  // Set the issued date
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Set expiration (1 day)
                .signWith(SECRET_KEY)  // Sign the token with the secret key
                .compact();  // Return the compact string representing the JWT token
    }

    /**
     * Parse the JWT token and retrieve the claims.
     *
     * @param token The JWT token to be parsed
     * @return Claims object containing the token information
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)  // Set the same secret key used for signing
                .build()
                .parseClaimsJws(token)  // Parse the token and return claims
                .getBody();  // Extract the body (claims) from the token
    }

    /**
     * Validate the JWT token and check if it's expired.
     *
     * @param token The JWT token to be validated
     * @return True if the token is valid and not expired, otherwise false
     */
    public static boolean isValidToken(String token) {
        try {
            Claims claims = parseToken(token);  // Parse the claims from the token
            return !claims.getExpiration().before(new Date());  // Check if token is expired
        } catch (Exception e) {
            // Token parsing failed, probably due to invalid signature or expiration
            return false;
        }
    }

    // Example usage:
    public static void main(String[] args) {
        // Generate a token for a user
        String username = "john_doe";
        String token = generateToken(username);
        System.out.println("Generated Token: " + token);

        // Parse the token and retrieve claims
        Claims claims = parseToken(token);
        System.out.println("Subject (Username): " + claims.getSubject());
        System.out.println("Issued At: " + claims.getIssuedAt());
        System.out.println("Expiration: " + claims.getExpiration());

        // Validate the token
        boolean isValid = isValidToken(token);
        System.out.println("Is the token valid? " + isValid);
    }
}
