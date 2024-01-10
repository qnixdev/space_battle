package dev.qnix.Controller;

import dev.qnix.Model.BattleRequest;
import dev.qnix.Service.Ship.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private final ShipService shipService;

    @Autowired
    public IndexController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public String index(Model model) {
        model
            .addAttribute("shipList", this.shipService.list())
            .addAttribute("battleRequest", new BattleRequest())
        ;

        return "index";
    }
}