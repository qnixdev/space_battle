package dev.qnix.Controller;

import dev.qnix.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {
    private final UserService userService;

    @Autowired
    public HistoryController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String showUserHistory(String xid, Model model) {
        var user = this.userService.getUserByXid(xid);

        model.addAttribute("storyList", user.getStories());

        return "history";
    }
}