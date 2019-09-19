package com.nurkiewicz.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class PointsCalculator {

    Mono<Integer> pointsOf(UUID playerId) {
        return Mono
                .fromCallable(() -> {
                    TimeUnit.MILLISECONDS.sleep(100);
                    return 42;
                })
                .subscribeOn(Schedulers.elastic());
    }

}
