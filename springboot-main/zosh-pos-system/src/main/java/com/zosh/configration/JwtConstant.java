package com.zosh.configration;

public final class JwtConstant {

    private JwtConstant() {
    }

    public static final String SECRET_KEY = System.getenv().getOrDefault(
            "JWT_SECRET_KEY",
            "zosh-pos-development-secret-key-change-me-please");
    public static final String JWT_HEADER = "Authorization";
}
