package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetingMessage() {
        return computeMessage()
            .zipWith(getNameFromDB())
            .map(t -> t.getT1() + t.getT2());
    }

    public Mono<String> computeMessage() {
        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }

    public Mono<String> getNameFromDB() {
        return Mono.just("dvt32").delayElement(Duration.ofSeconds(5));
    }

}
