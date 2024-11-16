package org.example.springboot.demos.web.login;

public class TokenInfo {
    private String token;

    public TokenInfo(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
