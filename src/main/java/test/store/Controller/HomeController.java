package test.store.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import test.store.service.AuthService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final AuthService authService;

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

//    @GetMapping("/hundred")
//    public String hundred() {
//        return "hundred";
//    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/insertPost")
    public String insertPost() {
        return "post";
    }

    @GetMapping("/cs")
    public String cs() {
        return "cs";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String username, String password, Model model, HttpSession session) {
        if (authService.authenticate(username, password)) {
            // 로그인 성공
            String role = authService.getRole(username);
            if ("ADMIN".equals(role)) {
                session.setAttribute("role", role);
                return "redirect:/"; // 관리자 페이지로 리디렉션
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; // 로그인 실패 시 다시 로그인 페이지로
    }
}
