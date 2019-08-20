package com.nurkiewicz.graphql;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
class BillingRepository {

    Billing forUser(UUID playerId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(300);
        return new Billing(BigDecimal.TEN, ImmutableList.of(
                new Operation(BigDecimal.TEN, "Item purchase")
        ));

    }

}
