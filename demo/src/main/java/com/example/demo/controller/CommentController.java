package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

public class CommentController {
  private final CommentRepository repository;

  public CommentController(CommentRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  public String getAllComment(Comment comment, Model model) {
    model.addAttribute("comments", repository.findAll());
    return "list";
  }

  @PostMapping("/add")
  public String addCommnet(
    @Validated Comment comment,
    BindingResult result,
    Model model
    ) {
      model.addAttribute("comments", repository.findAll());
      if(result.hasErrors()) {
        return "list";
      }
      repository.save(comment);
      return "redirect:/";
    }
}
