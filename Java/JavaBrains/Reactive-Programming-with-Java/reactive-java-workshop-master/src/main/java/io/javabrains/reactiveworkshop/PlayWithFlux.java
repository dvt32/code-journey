package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

public class PlayWithFlux {

    public static void main(String[] args) {
        Flux.just(1, 2, 3).subscribe(System.out::println);
    }

}
