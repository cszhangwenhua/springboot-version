package com.fantasy.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/9.
 */
@Controller
public class HelloWorldController {

  @ResponseBody
  @RequestMapping(value = "hello", method = RequestMethod.GET)
  Message hello() {
    return new Message("hello");
  }
}

class Message {
  public String info;

  public Message(String info) {
    this.info = info;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}