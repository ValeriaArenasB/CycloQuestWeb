package com.ejemplo.demo.thymeleaf.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class LoginController {

    // Modelo
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginModel {
        String login;
        String password;
    }


    @GetMapping("/login")
    public String verFormulario(){
        return "login/index";
    }

    @PostMapping("/login")
    public ModelAndView procesarFormulario(
        LoginModel login
    ) {

        System.out.println("login : " + login.getLogin());
        System.out.println("password : " + login.getPassword());

        String username = login.getLogin();
        String password = login.getPassword();

        // es OK ??
        if (username.equals(password)) {
            return new ModelAndView("redirect:/login/menu");
        }
        // no es OK
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login/menu")
    public String menu() {
        return "login/menu";
    }

}