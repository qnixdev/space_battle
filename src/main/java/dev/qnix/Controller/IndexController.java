package dev.qnix.Controller;

import dev.qnix.Service.Ship.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    private final ShipService shipService;

    public IndexController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("shipList", this.shipService.list());

        return "index";
    }
}