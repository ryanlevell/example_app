package org.levell.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-security")
    public String testSecurity() {
        return "ok";
    }
}
