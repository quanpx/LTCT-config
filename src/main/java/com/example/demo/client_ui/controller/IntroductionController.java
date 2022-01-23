package com.example.demo.client_ui.controller;

import com.example.demo.config.account.CurrentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroductionController {

    @Autowired
    private CurrentAccount currentAccount;

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        if (HomeController.languageConfig.equals("vi")) {
            return "vi/about-vi";
        }
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(Model model) {
        if (HomeController.languageConfig.equals("vi")) {
            return "vi/contact-vi";
        }
        return "contact";
    }

    @GetMapping("/faq")
    public String getFAQPage(Model model) {
        if (HomeController.languageConfig.equals("vi") || this.currentAccount.getLanguageConfig().equals("vi")) {
            return "vi/faq-vi";
        }
        return "faq";
    }
}
