package com.fishcards.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userForm")
    public String getUserForm(Model model){
      model.addAttribute("user", new User());
      return "userForm";
  }

  @PostMapping("/userForm")
    public String addUser(@ModelAttribute User user, Model model){
        userService.save(user);
        return "redirect:/success";
  }

  @GetMapping("/success")
    public String success(Model model){
        return "result";
  }
}
