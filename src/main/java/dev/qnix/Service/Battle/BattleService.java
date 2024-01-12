package dev.qnix.Service.Battle;

import dev.qnix.Entity.Ship;
import dev.qnix.Model.BattleRequest;
import dev.qnix.Service.Battle.DTO.BattleResult;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public final class BattleService {
    public BattleResult battle(BattleRequest request) {
        var shipOne = request.getShipOne();
        var shipTwo = request.getShipTwo();
        var shipOneHealth = shipOne.getStrength() * request.getShipOneQuantity();
        var shipTwoHealth = shipTwo.getStrength() * request.getShipTwoQuantity();

        boolean isShipOneUsedJediPowers = false, isShipTwoUsedJediPowers = false;
        byte battleLimit = 0;

        do {
            if (this.isJediDestroyShipUsingTheForce(shipOne)) {
                shipTwoHealth = 0;
                isShipOneUsedJediPowers = true;

                break;
            }
            if (this.isJediDestroyShipUsingTheForce(shipTwo)) {
                shipOneHealth = 0;
                isShipTwoUsedJediPowers = true;

                break;
            }

            shipOneHealth -= (shipOne.getWeaponPower() * request.getShipOneQuantity());
            shipTwoHealth -= (shipTwo.getWeaponPower() * request.getShipTwoQuantity());

            if (battleLimit > 100) {
                shipOneHealth = shipTwoHealth = 0;
            }

            battleLimit++;
        } while (shipOneHealth > 0 && shipTwoHealth > 0);

        var story = new BattleResult.Story(
            request.getShipOneQuantity(),
            request.getShipTwoQuantity(),
            Math.max(shipOneHealth, 0),
            Math.max(shipTwoHealth, 0)
        );

        if (shipOneHealth <= 0 && shipTwoHealth <= 0) {
            return new BattleResult(null, null, false, story);
        } else {
            return shipTwoHealth <= 0
                ? new BattleResult(shipOne, shipTwo, isShipOneUsedJediPowers, story)
                : new BattleResult(shipTwo, shipOne, isShipTwoUsedJediPowers, story)
            ;
        }
    }

    private boolean isJediDestroyShipUsingTheForce(Ship ship) {
        return new Random().nextInt(100) + 1 <= ship.getJediFactor();
    }
}