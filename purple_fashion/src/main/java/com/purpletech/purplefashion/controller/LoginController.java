package com.purpletech.purplefashion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {GET, POST})
    public String displayLoginPage(@RequestParam(required = false) String error,
                                   @RequestParam(required = false) String logout, Model model) {
        String errorMessage = null;
        if(error != null)
            errorMessage = "Username or Password is incorrect";
        if(logout != null)
            errorMessage = "Logged out successfully!!!";
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }

}
