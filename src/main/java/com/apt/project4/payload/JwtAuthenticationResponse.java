package com.apt.project4.payload;

import com.apt.project4.config.JwtConfiguration;

public class JwtAuthenticationResponse extends BaseResponse {
    private String accessToken;

    private String userName;
    
    
    private int userId;
    
    
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public JwtAuthenticationResponse(String accessToken, String userName,int userId, Long roleId) {
        super(true, "", null);
        this.accessToken = accessToken;
        this.userName = userName;
        this.userId = userId;
        this.roleId = roleId;
    }

    public JwtAuthenticationResponse(boolean isSuccess, String message, String errorCode, String accessToken, String userName, int userId,  Long roleId) {
        super(isSuccess, message, errorCode);
        this.accessToken = accessToken;
        this.userName = userName;
        this.userId = userId;
        this.roleId = roleId;
    }
}
