package com.example.statify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpotifyController {
    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/recently-played")
    public String getRecentlyPlayed(@AuthenticationPrincipal OAuth2User principal) {
        String accessToken = principal.getAttribute("access_token");
        return spotifyService.getRecentlyPlayed(accessToken);
    }
} 