package cosmetic.controller.web;

import cosmetic.entity.MessageEntity;
import cosmetic.entity.ProductEntity;
import cosmetic.repository.MessageRepository;
import cosmetic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("listProduct",productService.findRandomPro());
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

    @GetMapping("/search")
    @ResponseBody
    public List<ProductEntity> find(@RequestParam("key") String key) {
        System.out.println(key+"-----------------------------");
        return productService.search(key);
    }
}
