package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
class PlayerMetadata {

    private final Fairy fairy;

    String lookupName(UUID playerId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        return fairy.person().getFirstName();
    }

}
