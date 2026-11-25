package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService service =
            new GreetingService();

    @Test
    void shouldGreetUser() {

        assertEquals(
                "Hello, Alice!",
                service.greet("Alice")
        );
    }

    @Test
    void shouldHandleNullName() {

        assertEquals(
                "Hello, World!",
                service.greet(null)
        );
    }

    @Test
    void shouldHandleBlankName() {

        assertEquals(
                "Hello, World!",
                service.greet("   ")
        );
    }

    @Test
    void shouldTrimName() {

        assertEquals(
                "Hello, Alice!",
                service.greet(" Alice ")
        );
    }
}