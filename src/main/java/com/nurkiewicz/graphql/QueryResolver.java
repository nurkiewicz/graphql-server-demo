package com.nurkiewicz.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.ImmutableList;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
class QueryResolver implements GraphQLQueryResolver {

    Player currentPlayer() {
        return somePlayer();
    }

    @NotNull
    private Player somePlayer() {
        UUID playerId = UUID.randomUUID();
        return new Player(playerId);
    }

}

@Value
class Player {
    UUID id;
}

@Value
class Item {
    String name;
}

@Value
class Billing {
    BigDecimal balance;
    ImmutableList<Operation> operations;
}

@Value
class Operation {
    BigDecimal amount;
    String description;
}