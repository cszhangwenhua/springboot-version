package com.fantasy;

import com.fantasy.controller.HelloWorldController;
import com.fantasy.controller.PersonController;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * Created by Administrator on 2018/3/9.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class ContractVerifierBase {
  @Before
  public void setup() {
    System.out.println("before:--------------------------------------------------");
    RestAssuredMockMvc.standaloneSetup(new HelloWorldController(), new PersonController());
  }

}
