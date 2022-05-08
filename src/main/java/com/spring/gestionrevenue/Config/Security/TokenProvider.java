package com.spring.gestionrevenue.Config.Security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class    TokenProvider {

    private long tokenHours;
    private String SECRET_KEY= "kimajee";

    public long validityTime(){
//        return 1000*60*180* this.tokenHours;
        return 1000*60*180* this.tokenHours;
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token , Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Claims extractAllClaims(String token) {
        log.info(token);
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis() ))
                .setExpiration(new Date(System.currentTimeMillis() + validityTime()))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public String generateToken(UserDetails userDetails, long tokenDays){
        Map<String, Object> claims = new HashMap<>();
        this.setTokenHours(tokenDays*24);
        return createToken(claims, userDetails.getUsername());

    }

    public Boolean validateToken(String token, UserDetails userDetails){

        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("scopes").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", null);
    }

    public void setTokenHours(long tokenHours) {
        this.tokenHours = tokenHours;
    }

    public long getTokenHours() {
        return tokenHours;
    }
}
