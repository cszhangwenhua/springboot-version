package com.fantasy;

import com.fantasy.controller.hello.HelloWorldController;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * Created by Administrator on 2018/3/20.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class HelloWorldControllerBase {
  @Before
  public void setup() {
    System.out.println("before:--------------------------------------------------");
    RestAssuredMockMvc.standaloneSetup(new HelloWorldController());
  }

  @After
  public void tearDown() {
    System.out.println("end:--------------------------------------------------");
  }
}
