package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class InventoryClient {

    private final Fairy fairy;

    ImmutableList<Item> loadInventory(UUID playerId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(600);
        return ImmutableList.of(new Item(fairy.baseProducer().randomElement("Sword", "Shield", "Shoes", "Spell", "Potion")));
    }

}
