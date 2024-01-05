package dev.qnix.Repository;

import dev.qnix.Entity.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ShipRepository extends CrudRepository<Ship, UUID> {
}