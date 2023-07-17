package com.ftiland.travelrental.oauth.config;

import com.ftiland.travelrental.oauth.jwt.JwtTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
public class UrlConfig {

    @Value("${jwt.redirect.scheme}")
    private String scheme;
    @Value("${jwt.redirect.host}")
    private String host;
    @Value("${jwt.redirect.port}")
    private int port;
    @Value("${jwt.redirect.path}")
    private String path;

    @Bean
    public String createURI() {
        return UriComponentsBuilder
                .newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .path(path)
                .build()
                .toUriString();
    }
}
