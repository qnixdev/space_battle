package dev.qnix.Controller;

import dev.qnix.Model.BattleRequest;
import dev.qnix.Service.Battle.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/battle")
public class BattleController {
    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping
    public String processBattle(@ModelAttribute("battleRequest") BattleRequest request) {
        var battleResult = this.battleService.battle(request);

        System.out.println(battleResult);

        return "redirect:/";
    }
}