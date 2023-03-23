package com.example.register_form.controller;

import com.example.register_form.model.User;
import com.example.register_form.service.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
  private IServiceUser iServiceUser;

    @GetMapping("show-register")
    public String showRegisterUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("do-register")
    public String doRegisterUser(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        String resover = "";
        if (bindingResult.hasErrors()) {
            resover = "regi ster";
        } else {
            iServiceUser.save(user);
            String mess = "successful";
            model.addAttribute("mess", mess);
            resover = "doneRegister";
        }
        return resover;
    }

}
