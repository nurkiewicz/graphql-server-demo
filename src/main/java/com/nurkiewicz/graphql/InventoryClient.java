package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class InventoryClient {

    private final Fairy fairy;

    ImmutableList<Item> loadInventory(UUID playerId) {
        return ImmutableList.of(new Item(fairy.baseProducer().randomElement("Sword", "Shield", "Shoes", "Spell", "Potion")));
    }

}
