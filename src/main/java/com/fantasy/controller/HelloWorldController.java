package com.fantasy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/9.
 */

public class HelloWorldController {

  @ResponseBody
  @RequestMapping(value = "hello", method = RequestMethod.GET)
  Message hello() {
    return new Message("hello");
  }

  static class Message {
    String info;

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


}
