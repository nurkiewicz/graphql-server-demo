package com.nurkiewicz.graphql;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class BillingRepository {

    Billing forCurrentUser() {
        return new Billing(BigDecimal.TEN, ImmutableList.of(
                new Operation(BigDecimal.TEN, "Item purchase")
        ));

    }

}
