package spring.dispatcherservlet.controller;

import java.lang.reflect.Member;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homeInit(Locale locale, Model model) {
    return "home";
  }

  @GetMapping("/members/{id}")
  public String getMembers(Model model) {
    return "member";
  }

  //consumes및 produces는 부정 표현도 지원함. EX.!text/plain
  @PostMapping(path = "members", consumes = "application/json", produces = "application/json")
  public void addMember(@RequestBody Member member) {

  }
}
