package dev.qnix.Model;

import dev.qnix.Entity.Ship;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class BattleRequest {
    private Ship shipOne;
    private int shipOneQuantity;
    private Ship shipTwo;
    private int shipTwoQuantity;
}