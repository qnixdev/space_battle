package dev.qnix.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @PostMapping
    public String showUserHistory(String xid, Model model) {
        model.addAttribute("storyList", new String[]{"a", "b"});

        return "history";
    }
}