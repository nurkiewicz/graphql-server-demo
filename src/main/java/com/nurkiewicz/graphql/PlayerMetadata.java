package com.nurkiewicz.graphql;

import com.devskiller.jfairy.Fairy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PlayerMetadata {

    private final Fairy fairy;

    String lookupName() {
        return fairy.person().getFirstName();
    }

}
