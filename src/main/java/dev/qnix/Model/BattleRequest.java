package dev.qnix.Model;

import dev.qnix.Entity.Ship;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class BattleRequest {
    private Ship shipOne;
    private int shipOneQuantity;
    private Ship shipTwo;
    private int shipTwoQuantity;
    private String xid;
}