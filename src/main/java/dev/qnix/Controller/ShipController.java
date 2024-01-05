package dev.qnix.Controller;

import dev.qnix.Entity.Ship;
import dev.qnix.Request.Ship.ShipCreateRequest;
import dev.qnix.Request.Ship.ShipUpdateRequest;
import dev.qnix.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/ship")
public class ShipController {
    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public Iterable<Ship> list() {
        return this.shipService.list();
    }

    @PutMapping
    public Ship create(@RequestBody ShipCreateRequest request) {
        return this.shipService.create(request);
    }

    @GetMapping("/{id}")
    public Ship read(@PathVariable UUID id) {
        return this.shipService.read(id);
    }

    @PostMapping
    public Ship update(@RequestBody ShipUpdateRequest request) {
        return this.shipService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.shipService.delete(id);
    }
}