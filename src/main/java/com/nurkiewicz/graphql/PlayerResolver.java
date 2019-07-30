package com.nurkiewicz.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PlayerResolver implements GraphQLResolver<Player> {

    private final BillingRepository billingRepository;

    Billing billing(Player player) {
        return billingRepository.forUser(player.getId());
    }

}
