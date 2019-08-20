package com.nurkiewicz.graphql;

import brave.ScopedSpan;
import brave.Tracer;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@RequiredArgsConstructor
class PlayerResolver implements GraphQLResolver<Player> {

    private final BillingRepository billingRepository;
    private final InventoryClient inventoryClient;
    private final PlayerMetadata playerMetadata;
    private final PointsCalculator pointsCalculator;
    private final Tracer tracer;

    Billing billing(Player player) throws InterruptedException {
        return inSpan("billing",
                () -> billingRepository.forUser(player.getId())
        );
    }

    String name(Player player) throws InterruptedException {
        return inSpan("name",
                () -> playerMetadata.lookupName(player.getId())
        );
    }

    int points(Player player) throws InterruptedException {
        return inSpan("points",
                () -> pointsCalculator.pointsOf(player.getId())
        );
    }

    ImmutableList<Item> inventory(Player player) throws InterruptedException {
        return inSpan("inventory",
                () -> inventoryClient.loadInventory(player.getId())
        );
    }

    private <T> T inSpan(String name, Callable<T> action) {
        ScopedSpan span = tracer.startScopedSpan(name);
        try {
            return action.call();
        } catch (Exception e) {
            span.error(e);
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        } finally {
            span.finish();
        }
    }

}
