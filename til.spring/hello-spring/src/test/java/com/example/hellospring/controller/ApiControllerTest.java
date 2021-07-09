package com.example.hellospring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = ApiController.class)
class ApiControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void test() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/100"))
    .andDo(print())
    .andExpect(status().isOk())
    .andExpect(header().string("test-header", "hyoin-header"))
    .andExpect(content().string("test100"));
  }
}