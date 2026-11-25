package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;
    private final String environment;
    private final String version;

    public GreetingController(
            GreetingService greetingService,
            @Value("${app.environment}") String environment,
            @Value("${app.version}") String version) {

        this.greetingService = greetingService;
        this.environment = environment;
        this.version = version;
    }

    @GetMapping("/api/greet")
    public Map<String, String> greet(
            @RequestParam(defaultValue = "") String name) {

        return Map.of(
                "message", greetingService.greet(name),
                "environment", environment,
                "version", version);
    }
}
