package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.config.account.CurrentAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {

    @Autowired
    private CurrentAccount currentAccount;

    @GetMapping("/payment-confirmation")
    public String getPaymentConfirmationPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";
        if (HomeController.languageConfig.equals("vi")) {
            return "vi/payment-confirmation-vi";
        }
        return "payment-confirmation";
    }

    @GetMapping("/payment-successful")
    public String getPaymentSuccessfulPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";
        if (this.currentAccount.getLanguageConfig().equals("vi")) {
            return "vi/payment-successful-vi";
        }
        return "payment-successful";
    }
}
