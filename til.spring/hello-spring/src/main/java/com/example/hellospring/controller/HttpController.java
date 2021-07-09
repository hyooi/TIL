package com.example.hellospring.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HttpController {

  @GetMapping("/home/{data}")
  public String helloWord(@PathVariable String data, Model model) {
    model.addAttribute("message", data);
    model.addAttribute("servertime", LocalDateTime.now().toString());

    return "hello-world";
  }
}
