package com.apt.project4.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProviderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProviderTest.class);

    private static final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    private static final String USER_ID = "id";
//    private static final String USER_ROLE = "role";

    @Autowired
    private JwtConfiguration jwtConfiguration;


    public String generateToken(Authentication authentication) throws JsonProcessingException {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtConfiguration.getExpirationTime());

        Map<String, Object> mapModel = new HashMap<>();

        mapModel.put(USER_ID,  userPrincipal.getId());
//        mapModel.put(USER_ROLE,  userPrincipal.getTypeRole());

        return Jwts.builder()//
                .setSubject(mapper.writeValueAsString(mapModel))
                .setIssuedAt(new Date())
                .setExpiration(validity)
                .signWith(JwtConfiguration.HASH_ALGORITHM, jwtConfiguration.getSecret())
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtConfiguration.getSecret())
                .parseClaimsJws(token)
                .getBody();
        Map<String, String> mapModel;
        String strId = "";
        try {
            mapModel = mapper.readValue(claims.getSubject(), new TypeReference<Map<String, String>>(){});
            strId = mapModel.get(USER_ID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Long.parseLong(strId);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtConfiguration.JWT_HEADER_KEY);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtConfiguration.TOKEN_PREFIX)) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtConfiguration.getSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("JWT claims string is empty.");
        }
        return false;
    }

}
