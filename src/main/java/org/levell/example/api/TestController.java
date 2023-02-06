package org.levell.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/test-security")
    public Mono<String> testSecurity() {
        return Mono.empty();
    }
}
