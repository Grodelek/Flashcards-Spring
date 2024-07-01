package com.fishcards.card.controllers;

import com.fishcards.card.models.User;
import com.fishcards.card.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String addUser(@Valid @ModelAttribute User user, Errors errors, SessionStatus sessionStatus,
                          BindingResult bindingResult){
        boolean isUpper = false;
        for(int i=0; i<user.getPassword().length(); i++){
            if(Character.isUpperCase(user.getPassword().charAt(i))) {
                isUpper = true;
            }
        }
            if(!isUpper) {
                bindingResult.rejectValue("password", "password.uppercase", "Minimum one uppercase Letter");
            }
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
