package app.controller;


import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUser(id);
        return "redirect:/";
    }


}
