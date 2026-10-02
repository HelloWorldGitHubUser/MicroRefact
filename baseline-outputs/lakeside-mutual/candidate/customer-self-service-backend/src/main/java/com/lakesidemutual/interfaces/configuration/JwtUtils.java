package com.lakesidemutual.interfaces.configuration;
 import com.lakesidemutual.domain.identityaccess.UserSecurityDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtils {

 private  SecretKey secret;

@Value("${token.expiration}")
 private  int expirationInSeconds;


public Date getExpirationDateFromToken(String token){
    Date expiration;
    try {
        final Claims claims = this.getClaimsFromToken(token);
        expiration = claims.getExpiration();
    } catch (Exception e) {
        expiration = null;
    }
    return expiration;
}


public Date generateExpirationDate(){
    return new Date(System.currentTimeMillis() + this.expirationInSeconds * 1000);
}


public Claims getClaimsFromToken(String token){
    Claims claims;
    try {
        claims = Jwts.parser().verifyWith(this.secret).build().parseSignedClaims(token).getPayload();
    } catch (Exception e) {
        claims = null;
    }
    return claims;
}


public Date generateCurrentDate(){
    return new Date(System.currentTimeMillis());
}


public String generateToken(Map<String,Object> claims){
    return Jwts.builder().claims(claims).expiration(this.generateExpirationDate()).signWith(this.secret).compact();
}


public Date getCreatedDateFromToken(String token){
    Date created;
    try {
        final Claims claims = this.getClaimsFromToken(token);
        created = new Date((Long) claims.get("created"));
    } catch (Exception e) {
        created = null;
    }
    return created;
}


public String getAudienceFromToken(String token){
    String audience;
    try {
        final Claims claims = this.getClaimsFromToken(token);
        audience = (String) claims.get("audience");
    } catch (Exception e) {
        audience = null;
    }
    return audience;
}


public String getUsernameFromToken(String token){
    String username;
    try {
        final Claims claims = this.getClaimsFromToken(token);
        username = claims.getSubject();
    } catch (Exception e) {
        username = null;
    }
    return username;
}


public Boolean isTokenExpired(String token){
    final Date expiration = this.getExpirationDateFromToken(token);
    return expiration.before(this.generateCurrentDate());
}


public String refreshToken(String token){
    String refreshedToken;
    try {
        final Claims claims = this.getClaimsFromToken(token);
        claims.put("created", this.generateCurrentDate());
        refreshedToken = this.generateToken(claims);
    } catch (Exception e) {
        refreshedToken = null;
    }
    return refreshedToken;
}


public Boolean validateToken(String token,UserDetails userDetails){
    UserSecurityDetails user = (UserSecurityDetails) userDetails;
    final String username = this.getUsernameFromToken(token);
    return username.equals(user.getUsername()) && !(this.isTokenExpired(token));
}


}