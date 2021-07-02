package com.comp2024b.tocountornot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.comp2024b.tocountornot.exception.BadRequestException;

import java.util.Calendar;
public class Token {
    private static final String secret = System.getenv("SECRET");

    public static String create(String name) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return JWT.create()
                .withAudience(name)
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(secret));
    }

    public static String decode(String token) {
        String name;
        try {
            name = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException jde) {
            throw new BadRequestException("invalid token");
        }
        return name;
    }

    public static void verify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        try {
            jwtVerifier.verify(token);
        } catch (TokenExpiredException te) {
            throw new BadRequestException("expired token");
        } catch (JWTVerificationException jve) {
            throw new BadRequestException("invalid token");
        }
    }
}
