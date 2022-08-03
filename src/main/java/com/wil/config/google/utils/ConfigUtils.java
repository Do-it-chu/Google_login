package com.wil.config.google.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ConfigUtils {
    @Value("${google.auth.url}")
    private String googleAuthUrl;
    @Value("${google.login.url}")
    private String googleLoginUrl;
    @Value("${google.redirect.uri}")
    private String googleRedirectUri;
    @Value("${google.client.id}")
    private String googleClientId;
    @Value("${google.secret}")
    private String googleSecret;
    @Value("${google.auth.scope}")
    private String scopes;

    // Google 로그인 URL 생성 로직
    public String googleInitUrl() {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", getGoogleClientId());
        params.put("redirect_uri", getGoogleRedirectUri());
        params.put("response_type", "code");
        params.put("scope", getScopeUrl());

        String paramStr = params.entrySet().stream().map(param -> param.getKey() + "=" + param.getValue())
                .collect(Collectors.joining("&"));
        return getGoogleLoginUrl()+"/o/oauth2/v2/auth"+"?"+paramStr;
    }

    // Param을 가져오기위한 Getter
    public String getGoogleAuthUrl() {
        return googleAuthUrl;
    }

    public String getGoogleLoginUrl() {
        return googleLoginUrl;
    }

    public String getGoogleRedirectUri() {
        return googleRedirectUri;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public String getGoogleSecret() {
        return googleSecret;
    }

    public String getScopes() {
        return scopes;
    }
    // scope의 값을 보내기 위해 띄어쓰기 값을 UTF-8로 변환하는 로직 포함
    public String getScopeUrl() {
        //return scopes.stream().collect(Collectors.joining(","))
        //.replaceAll(",", "%20");
        return scopes.replaceAll(",", "%20");
    }
}
