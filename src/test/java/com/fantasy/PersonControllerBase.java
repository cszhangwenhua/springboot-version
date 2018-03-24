package com.fantasy;

import com.fantasy.controller.person.PersonController;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * Created by Administrator on 2018/3/20.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class PersonControllerBase {
  @Before
  public void setup() {
    System.out.println("before:--------------------------------------------------");
    RestAssuredMockMvc.standaloneSetup(new PersonController());
  }

  @After
  public void tearDown() {
    System.out.println("end:--------------------------------------------------");
  }
}
