package dev.qnix.Controller;

import dev.qnix.Model.BattleRequest;
import dev.qnix.Service.Battle.BattleService;
import dev.qnix.Service.Battle.StoryService;
import dev.qnix.Service.User.LocalStorage.LocalStorageService;
import dev.qnix.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/battle")
public class BattleController {
    private final BattleService battleService;
    private final StoryService storyService;
    private final UserService userService;

    @Autowired
    public BattleController(
        BattleService battleService,
        StoryService storyService,
        UserService userService
    ) {
        this.battleService = battleService;
        this.storyService = storyService;
        this.userService = userService;
    }

    @PostMapping
    public String processBattle(
        @ModelAttribute("battleRequest") BattleRequest request,
        Model model
    ) {
        var xid = !request.getXid().isBlank()
            ? request.getXid()
            : LocalStorageService.generateXid()
        ;
        var user = this.userService.getUserByXidOrCreate(xid);
        var response = this.battleService.battle(request);

        this.storyService.create(request, response, user);

        model.addAttribute("request", request);
        model.addAttribute("response", response);
        model.addAttribute("xid", xid);

        return "battle";
    }
}