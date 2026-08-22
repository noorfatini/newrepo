package com.example.AssetTracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
 * Simple health/about controller.
 * - @RestController: a specialization of @Controller that assumes
 *   every method returns a domain object rather than a view.
 * - These endpoints are useful for students to quickly verify the app is running.
 */
@RestController
public class HealthController {

    @GetMapping("/api/health")
    public Map<String, String> health() {
        // Returning a small JSON object. Spring MVC converts Map -> JSON automatically.
        return Map.of(
                "status", "UP",
                "service", "asset-tracker-api"
        );
    }

    @GetMapping("/api/about")
    public Map<String, String> about() {
        return Map.of(
                "appName", "Asset Tracker API",
                "version", "1.0.0",
                "description", "API for tracking company assets"
        );
    }
}
