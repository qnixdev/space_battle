package dev.qnix.Repository;

import dev.qnix.Entity.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface StoryRepository extends CrudRepository<Story, UUID> {
}