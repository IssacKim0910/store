package test.store.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/category")
    public String category() {
        return "category";
    }

    @GetMapping("/local")
    public String local() {
        return "local";
    }

    @GetMapping("/hundred")
    public String hundred() {
        return "hundred";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


}
