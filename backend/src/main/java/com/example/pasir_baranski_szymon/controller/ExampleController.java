package com.example.pasir_baranski_szymon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class ExampleController {
    public static class Something{
        private final String appName;
        private final String version;
        private final String message;

        public Something(String appName, String version, String message) {
            this.appName = appName;
            this.version = version;
            this.message = message;
        }

        public String getAppName() {
            return appName;
        }
        public String getVersion() {
            return version;
        }
        public String getMessage() {
            return message;
        }
    }
    @GetMapping
    public ResponseEntity<Something> Test(){
        return ResponseEntity.ok(new Something("Aplikacja Budżetowa","1.0","Witaj w aplikacji budżetowej stworzonej ze Spring Boot!"));
    }
}
