package org.levell.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class DeployController {

    @PostMapping("/deploy")
    public Mono<ResponseEntity<Object>> createDeployment() {
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).build());
    }
}
