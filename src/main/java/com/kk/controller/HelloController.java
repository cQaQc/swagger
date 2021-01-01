package com.kk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kk.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/hhh")
@Api("123")
public class HelloController {

  /** 写一个hello测试工程 */
  @ApiOperation("hello控制类")
  @GetMapping("/hello")
  public String helloCon() {
    return "hello swagger";
  }

  /** 只要我们的接口返回值中存在实体类，就会自动被扫描到swagger中 */
  @ApiOperation("hello控制类")
  @GetMapping("/user")
  public String user() throws JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    User user = new User(999, "大宝贝",new Date("1997/10/10"));
    return om.writeValueAsString(user);
  }

  @GetMapping("/user1")
  public User user1() {
    return new User(999, "大宝贝", new Date("1997/12/17"));
  }

  @PostMapping("/user2")
  public User user2() {
    return new User(999, "大宝贝",new Date("1997/12/17"));
  }
}
