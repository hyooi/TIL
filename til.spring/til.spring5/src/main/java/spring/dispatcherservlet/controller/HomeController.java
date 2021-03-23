package spring.dispatcherservlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * origins : 허용된 origins목록. 응답 전송 전과 실제 응답의 헤더에 access-control-allow-origin으로 입력됨
 * - *, undefined : 모든 origins가 허용됨
 * <p>
 * allowHeaders : 실제 요청 중 사용될 수 있는 요청헤더 리스트. 값은 응답헤더의 access-control-allow-headers가 사용됨
 * - *: 클라이언트가 요청한 모든 헤더가 허용됨
 * - undefined: 모든 요청 헤더가 허가됨
 */


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController {

  @CrossOrigin(origins = "http://example.com") //해당 메소드는 http://example.com을 통해서만 접근 가능
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
