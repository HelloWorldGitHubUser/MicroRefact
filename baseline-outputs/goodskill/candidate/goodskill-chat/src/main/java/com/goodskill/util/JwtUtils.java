package com.goodskill.util;
 import io.jsonwebtoken;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Slf4j
public class JwtUtils {

 private  String SECRET_KEY;

 private  long TOKEN_EXPIRE_MILLIS;


public Key generateKey(){
    return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
}


public int verifyToken(String token){
    try {
        Jwts.parserBuilder().setSigningKey(generateKey()).build().parseClaimsJws(token);
        return 0;
    } catch (ExpiredJwtException e) {
        log.warn(e.getMessage(), e);
        return 1;
    } catch (UnsupportedJwtException e) {
        log.warn(e.getMessage(), e);
        return 2;
    } catch (MalformedJwtException e) {
        log.warn(e.getMessage(), e);
        return 3;
    } catch (SignatureException e) {
        log.warn(e.getMessage(), e);
        return 4;
    } catch (IllegalArgumentException e) {
        log.warn(e.getMessage(), e);
        return 5;
    }
}


public Map<String,Object> parseToken(String token){
    return Jwts.parserBuilder().setSigningKey(generateKey()).build().parseClaimsJws(token).getBody();
}


public String createToken(Map<String,Object> claimMap){
    long currentTimeMillis = System.currentTimeMillis();
    return Jwts.builder().setId(UUID.randomUUID().toString()).setIssuedAt(new Date(currentTimeMillis)).setExpiration(new Date(currentTimeMillis + TOKEN_EXPIRE_MILLIS)).addClaims(claimMap).signWith(generateKey()).compact();
}


public void main(String[] args) throws InterruptedException{
    Map<String, Object> map = new HashMap<>();
    map.put("name", "1");
    map.put("age", "1");
    String token = createToken(map);
    System.out.println(token);
    Thread.sleep(2000);
    System.out.println(parseToken(token));
}


}