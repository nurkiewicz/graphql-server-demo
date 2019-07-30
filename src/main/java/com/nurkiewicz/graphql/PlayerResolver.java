package com.nurkiewicz.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PlayerResolver implements GraphQLResolver<Player> {

    private final BillingRepository billingRepository;
    private final InventoryClient inventoryClient;
    private final PlayerMetadata playerMetadata;
    private final PointsCalculator pointsCalculator;

    Billing billing(Player player) {
        return billingRepository.forUser(player.getId());
    }

    String name(Player player) {
        return playerMetadata.lookupName(player.getId());
    }

    int points(Player player) {
        return pointsCalculator.pointsOf(player.getId());
    }

    ImmutableList<Item> inventory(Player player) {
        return inventoryClient.loadInventory(player.getId());
    }


}
