package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class PlayerMetadata {

    private final Fairy fairy;

    String lookupName(UUID playerId) {
        return fairy.person().getFirstName();
    }

}
