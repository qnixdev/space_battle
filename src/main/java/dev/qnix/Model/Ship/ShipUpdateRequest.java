package dev.qnix.Model.Ship;

import dev.qnix.Entity.Ship;
import lombok.Getter;
import java.util.UUID;

@Getter
public class ShipUpdateRequest {
    private UUID id;
    private String name = null;
    private Integer weaponPower = null;
    private Integer strength = null;
    private Integer jediFactor = null;
    private Ship.Team team = null;
}