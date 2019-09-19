package com.nurkiewicz.graphql;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
class BillingRepository {

    Mono<Billing> forUser(UUID playerId) {
        return Mono
                .fromCallable(() -> {
                    TimeUnit.MILLISECONDS.sleep(300);
                    return new Billing(BigDecimal.TEN, ImmutableList.of(
                            new Operation(BigDecimal.TEN, "Item purchase")
                    ));
                }).subscribeOn(Schedulers.elastic());
    }

}
