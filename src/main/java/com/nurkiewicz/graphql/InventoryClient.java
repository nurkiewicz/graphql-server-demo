package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class InventoryClient {

    private final Fairy fairy;

    Flux<Item> loadInventory(UUID playerId) {
        return Mono
                .fromCallable(() -> {
                    TimeUnit.MILLISECONDS.sleep(600);

                    return new Item(fairy.baseProducer().randomElement("Sword", "Shield", "Shoes", "Spell", "Potion"));
                })
                .subscribeOn(Schedulers.elastic())
                .flux();
    }

}
