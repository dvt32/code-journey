package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources.intNumbersFlux()
                                               .log() // good for debugging
                                               .toStream()
                                               .toList();
        System.out.println(numbers);
        System.out.println(numbers.size());
        
        // Blocking operation above, so below is not needed
        // System.out.println("Press a key to end");
        // System.in.read();
    }

}
