package com.fantasy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */
@RequestMapping(value = "person")
public class PersonController {
  @ResponseBody
  @RequestMapping(value = "one", method = RequestMethod.GET)
  Person one() {
    return new Person(1000, "zhan san");
  }

  @ResponseBody
  @RequestMapping(value = "list", method = RequestMethod.GET)
  List<Person> list() {
    List<Person> list = new ArrayList<>();
    list.add(new Person(1000, "zhan san"));
    list.add(new Person(1001, "li si"));
    list.add(new Person(1002, "wang wu"));
    return list;
  }

  static class Person {
    Integer id;
    String name;

    public Person(Integer id, String name) {
      this.id = id;
      this.name = name;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
    }
  }
}
