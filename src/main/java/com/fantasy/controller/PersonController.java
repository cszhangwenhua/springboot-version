package com.fantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */
@RequestMapping(value = "person")
@Controller
public class PersonController {

  @ResponseBody
  @RequestMapping(value = "", method = RequestMethod.GET)
  Person oneQueryParameter(@RequestParam Integer id) {
    return new Person(id, "zhang " + id);
  }

  @ResponseBody
  @RequestMapping(value = "{id}", method = RequestMethod.GET)
  Person one(@PathVariable Integer id) {
    return new Person(id, "zhang " + id);
  }

  @ResponseBody
  @RequestMapping(value = "/goods/{personId}", method = RequestMethod.GET)
  Goods one(@PathVariable Integer personId, @RequestParam Integer goodsId) {
    Person person = new Person(personId, "zhang " + personId);
    return new Goods(goodsId, "Goods" + goodsId, person);
  }

  @ResponseBody
  @RequestMapping(value = "list", method = RequestMethod.GET)
  List<Person> list() {
    List<Person> list = new ArrayList<>();
    list.add(new Person(1000, "zhang san"));
    list.add(new Person(1001, "li si"));
    list.add(new Person(1002, "wang wu"));
    return list;
  }
}

class Person {
  public Integer id;
  public String name;

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


class Goods {
  public Integer id;
  public String name;
  public Person owner;

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

  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public Goods() {
  }

  public Goods(Integer id, String name, Person owner) {
    this.id = id;
    this.name = name;
    this.owner = owner;
  }
}