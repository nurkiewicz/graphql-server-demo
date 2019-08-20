package com.nurkiewicz.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class PointsCalculator {

    int pointsOf(UUID playerId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        return 42;
    }

}
