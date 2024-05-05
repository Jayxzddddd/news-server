package cn.smxy.newsserver.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

public class JWTUtil {
    public static String createToken(Map<String,String> payload){
        //日历
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,12*30*60*24);
        JWTCreator.Builder builder = JWT.create().withExpiresAt(calendar.getTime());
        Set<String> keys = payload.keySet();
        for(String key:keys){
            String value = payload.get(key);
            builder.withClaim(key,value);
        }
        String token = builder.sign(Algorithm.HMAC256("LYF!LYF"));
        return token;
    }
    public static DecodedJWT verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("LYF!LYF")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }


}
