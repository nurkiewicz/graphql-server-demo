package com.nurkiewicz.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
class PlayerResolver implements GraphQLResolver<Player> {

    private final BillingRepository billingRepository;
    private final InventoryClient inventoryClient;
    private final PlayerMetadata playerMetadata;
    private final PointsCalculator pointsCalculator;

    CompletableFuture<Billing> billing(Player player) {
        return billingRepository
                .forUser(player.getId())
                .toFuture();
    }

    CompletableFuture<String> name(Player player) {
        return playerMetadata
                .lookupName(player.getId())
                .toFuture();
    }

    CompletableFuture<Integer> points(Player player) {
        return pointsCalculator
                .pointsOf(player.getId())
                .toFuture();
    }

    CompletableFuture<List<Item>> inventory(Player player) {
        return inventoryClient
                .loadInventory(player.getId())
                .collectList()
                .toFuture();
    }

}
