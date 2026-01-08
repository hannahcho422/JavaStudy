package com.example.demo_board.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@Profile("health")
@RestController
public class HealthController {
    @GetMapping("/health")
    public Status getHealth() {
        return Status.builder().status("UP").build();
    }

    @Data
    @Builder
    private static class Status {
        public String status;
    }
    
}
