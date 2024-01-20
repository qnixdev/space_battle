package dev.qnix.Service.Battle;

import dev.qnix.Entity.Story;
import dev.qnix.Entity.User;
import dev.qnix.Model.BattleRequest;
import dev.qnix.Repository.StoryRepository;
import dev.qnix.Service.Battle.DTO.BattleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Story create(BattleRequest request, BattleDTO response, User user) {
        var story = Story.builder()
            .shipOne(request.getShipOne())
            .shipOneQuantity(request.getShipOneQuantity())
            .shipTwo(request.getShipTwo())
            .shipTwoQuantity(request.getShipTwoQuantity())
            .winnerShip(response.getWinnerShip())
            .shipOneRemainderHealth(response.getStory().getShipOneRemainderHealth())
            .shipTwoRemainderHealth(response.getStory().getShipTwoRemainderHealth())
            .build()
        ;
        user.addStory(story);
        this.storyRepository.save(story);

        return story;
    }
}