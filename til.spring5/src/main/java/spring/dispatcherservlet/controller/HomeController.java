package spring.dispatcherservlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @GetMapping("/1111")
  public String homeInit() {
    return "home";
  }

  @GetMapping("/members/{id}")
  public String getMembers() {
    return "member";
  }

  //consumes및 produces는 부정 표현도 지원함. EX.!text/plain
  @PostMapping(path = "members", consumes = "application/json", produces = "application/json")
  public void addMember() {

  }
}
