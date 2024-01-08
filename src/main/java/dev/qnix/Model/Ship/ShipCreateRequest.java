package dev.qnix.Model.Ship;

import dev.qnix.Entity.Ship;
import lombok.Getter;

@Getter
public class ShipCreateRequest {
    private String name;
    private Integer weaponPower;
    private Integer strength;
    private Integer jediFactor;
    private Ship.Team team;
}