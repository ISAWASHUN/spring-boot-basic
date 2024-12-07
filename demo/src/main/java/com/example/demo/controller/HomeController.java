package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Inquiry;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @GetMapping("/form")
  private String readForm(@ModelAttribute User user) {
    return "form";
  }

  @PostMapping("/form")
  private String confirm(@ModelAttribute User user) {
    return "confirm";
  }

  @GetMapping("/")
  public String index(Inquiry inquiry) {
    return "index";
  }

  @PostMapping("/")
  public String confirm(@Validated Inquiry inquiry, BindingResult result) {
    if(result.hasErrors()) {
      return "index";
    }
    return "confirm";
  }
}
