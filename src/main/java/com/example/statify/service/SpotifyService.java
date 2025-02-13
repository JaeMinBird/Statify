package com.example.statify.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class SpotifyService {
    @Value("${spotify.api.base-url}")
    private String spotifyApiBaseUrl;

    public String getRecentlyPlayed(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
            spotifyApiBaseUrl + "/me/player/recently-played",
            HttpMethod.GET,
            entity,
            String.class
        );

        return response.getBody();
    }
} 