package com.nurkiewicz.graphql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PointsCalculator {

    int pointsOfCurrentUser() {
        return 42;
    }

}
