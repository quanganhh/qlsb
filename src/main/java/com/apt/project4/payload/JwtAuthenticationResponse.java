package com.apt.project4.payload;

import com.apt.project4.config.JwtConfiguration;

public class JwtAuthenticationResponse extends BaseResponse {
    private String accessToken;

    private String userName;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = new StringBuilder(JwtConfiguration.TOKEN_PREFIX)
                .append(" ").append(accessToken).toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JwtAuthenticationResponse(String accessToken, String userName) {
        super(true, "", null);
        this.accessToken = accessToken;
        this.userName = userName;
    }

    public JwtAuthenticationResponse(boolean isSuccess, String message, String errorCode, String accessToken, String userName) {
        super(isSuccess, message, errorCode);
        this.accessToken = accessToken;
        this.userName = userName;
    }
}
