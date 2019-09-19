package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class PlayerMetadata {

    private final Fairy fairy;

    Mono<String> lookupName(UUID playerId) {
        return Mono
                .fromCallable(() -> {
                    Thread.sleep(100);
                    return fairy.person().getFirstName();
                })
                .subscribeOn(Schedulers.elastic());
    }
}
