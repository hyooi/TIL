package spring.dispatcherservlet.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

  @PostMapping("/members")
  public void addMemberV1(@RequestBody String str) {

  }

  @PostMapping(value = "/members", produces = MediaType.APPLICATION_XML_VALUE)
  public void addMemberV2(@RequestBody String str) {

  }
}
