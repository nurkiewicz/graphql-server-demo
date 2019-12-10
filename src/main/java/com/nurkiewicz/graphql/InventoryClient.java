package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Component
@RequiredArgsConstructor
class InventoryClient {

    private final Fairy fairy;
    private final ExecutorService inventoryExecutor;

    CompletableFuture<List<Item>> loadInventory(UUID playerId) {
        return CompletableFuture.supplyAsync(() -> {
            Sleeper.sleep(Duration.ofMillis(600));
            return List.of(new Item(fairy.baseProducer().randomElement("Sword", "Shield", "Shoes", "Spell", "Potion")));
        }, inventoryExecutor);
    }

}
