package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));
        /*
        ReactiveSources.intNumberMono().subscribe(
            number -> System.out.println(number),
            throwable -> System.out.println(throwable.getMessage()),
            () -> System.out.println("Done")
        );
        */

        // Get the value from the Mono into an integer variable
        Integer number = ReactiveSources.intNumberMono().block();
        Optional<Integer> numberOptional = ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
