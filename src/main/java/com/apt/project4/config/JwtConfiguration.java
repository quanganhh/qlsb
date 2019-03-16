package com.apt.project4.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfiguration {
    public static final String JWT_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final SignatureAlgorithm HASH_ALGORITHM = SignatureAlgorithm.HS256;

    private static JwtConfiguration jwtConfiguration;

    public static JwtConfiguration getJwtConfiguration() {
        if (jwtConfiguration == null) {
            jwtConfiguration = new JwtConfiguration();
        }
        return jwtConfiguration;
    }


    private long expirationTime = 864_000_000;
    private String secret = "DEFAULT_KN_SECRET";
    private String issuer = "eTra.com";

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        if (expirationTime > 0) {
            this.expirationTime = expirationTime;
        }
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        if (StringUtils.isEmpty(secret))
            return;
        this.secret = secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        if (StringUtils.isEmpty(issuer))
            return;
        this.issuer = issuer;
    }
}
