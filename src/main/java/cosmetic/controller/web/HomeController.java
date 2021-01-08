package cosmetic.controller.web;

import cosmetic.entity.MessageEntity;
import cosmetic.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String showHome(){
        return "web/index";
    }

    @GetMapping("/login")
    public String home(Model model) {
        model.addAttribute("msgs", messageRepository.findAll());
        return "web/login";
    }

    @PostMapping("/messages")
    public String saveMessage(MessageEntity message) {
        messageRepository.save(message);
        return "redirect:/login";
    }
}
