package dev.qnix.Request.Ship;

import lombok.Getter;

@Getter
public class ShipCreateRequest {
    private String name;
    private Integer weaponPower;
    private Integer strength;
    private String team;
}