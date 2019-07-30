package com.nurkiewicz.graphql;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
class BillingRepository {

    Billing forUser(UUID playerId) {
        return new Billing(BigDecimal.TEN, ImmutableList.of(
                new Operation(BigDecimal.TEN, "Item purchase")
        ));

    }

}
