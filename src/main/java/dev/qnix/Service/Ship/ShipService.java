package dev.qnix.Service.Ship;

import dev.qnix.Entity.Ship;
import dev.qnix.Model.Ship.ShipCreateRequest;
import dev.qnix.Model.Ship.ShipUpdateRequest;
import dev.qnix.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ShipService {
    private final ShipRepository shipRepository;

    @Autowired
    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public Iterable<Ship> list() {
        return this.shipRepository.findAll();
    }

    public Ship create(@NonNull ShipCreateRequest request) {
        var ship = Ship.builder()
            .name(request.getName())
            .weaponPower(request.getWeaponPower())
            .strength(request.getStrength())
            .jediFactor(request.getJediFactor())
            .team(request.getTeam())
            .build()
        ;
        this.shipRepository.save(ship);

        return ship;
    }

    public Ship read(UUID id) {
        return this.shipRepository.findById(id).orElse(null);
    }

    public Ship update(@NonNull ShipUpdateRequest request) {
        Ship existShip = this.read(request.getId());

        if (null == existShip) {
            return null;
        }

        if (
            null != request.getName()
            && !existShip.getName().equals(request.getName())
        ) {
            existShip.setName(request.getName());
        }
        if (
            null != request.getWeaponPower()
            && request.getWeaponPower().compareTo(existShip.getWeaponPower()) != 0
        ) {
            existShip.setWeaponPower(request.getWeaponPower());
        }
        if (
            null != request.getStrength()
            && request.getStrength().compareTo(existShip.getStrength()) != 0
        ) {
            existShip.setStrength(request.getStrength());
        }
        if (
            null != request.getJediFactor()
            && !request.getJediFactor().equals(existShip.getJediFactor())
        ) {
            existShip.setJediFactor(request.getJediFactor());
        }
        if (
            null != request.getTeam()
            && !request.getTeam().equals(existShip.getTeam())
        ) {
            existShip.setTeam(request.getTeam());
        }

        this.shipRepository.save(existShip);

        return existShip;
    }

    public void delete(UUID id) {
        this.shipRepository.deleteById(id);
    }
}