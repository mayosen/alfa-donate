package ru.weblab.alfadonate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class AlfadonateApplicationTests {

    @Test
    void simpleFluxExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.log().subscribe(System.out::println);
    }

    @Test
    void mapExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }

    @Test
    void zipExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plub");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30, 40);
        Flux.zip(fluxColors, fluxFruits, fluxAmounts).subscribe(System.out::println);
    }


}
