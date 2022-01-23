package com.example.demo.client_ui.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        if(HomeController.languageConfig.equals("vi")) {
            return "vi/404-vi";
        }
        return "404";
    }

}
