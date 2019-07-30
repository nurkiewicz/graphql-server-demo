package com.nurkiewicz.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class PointsCalculator {

    int pointsOf(UUID playerId) {
        return 42;
    }

}
