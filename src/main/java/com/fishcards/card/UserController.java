package com.fishcards.card;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;


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
    public String addUser(@Valid @ModelAttribute User user, Errors errors, SessionStatus sessionStatus){
      if(errors.hasErrors()){
          return "userForm";
      }
        userService.save(user);
      sessionStatus.setComplete();
        return "redirect:/success";
  }

  @GetMapping("/success")
    public String success(){
        return "result";
  }
}
