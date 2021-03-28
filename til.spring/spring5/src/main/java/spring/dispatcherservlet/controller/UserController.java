package spring.dispatcherservlet.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.dispatcherservlet.model.User;
import spring.dispatcherservlet.service.UserService;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String userForm(Model model) {
    model.addAttribute("users", userService.list());

    return "editUsers";
  }

  @ModelAttribute("user")
  public User formBackingObject() {
    return new User();
  }

  @PostMapping("addUser")
  public String saveUser(@ModelAttribute("user") @Valid User user,
      BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("users", userService.list());
      return "editUsers";
    }

    userService.save(user);
    return "redirect:/";
  }
}
