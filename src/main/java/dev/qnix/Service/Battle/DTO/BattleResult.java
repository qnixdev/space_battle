package dev.qnix.Service.Battle.DTO;

import dev.qnix.Entity.Ship;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class BattleResult {
    Ship winnerShip;
    Ship loserShip;
    boolean isUsedJediPowers;
    Story story;

    @AllArgsConstructor
    @Getter
    public static final class Story {
        private int shipOneTotalQuantity;
        private int shipTwoTotalQuantity;
        private int shipOneRemainderHealth;
        private int shipTwoRemainderHealth;
    }
}