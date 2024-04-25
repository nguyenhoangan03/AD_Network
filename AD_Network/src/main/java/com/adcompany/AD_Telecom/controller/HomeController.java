package com.adcompany.AD_Telecom.controller;

import com.adcompany.AD_Telecom.dao.CustomerRepository;
import com.adcompany.AD_Telecom.model.Customer;
import com.adcompany.AD_Telecom.service.ServiceManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private ServiceManagerService serviceManagerService;

    private CustomerRepository customerRepository;

    @Autowired
    public HomeController(ServiceManagerService serviceManagerService, CustomerRepository customerRepository) {
        this.serviceManagerService = serviceManagerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String viewHomePage(HttpSession session, Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();

        if (!user.equalsIgnoreCase("anonymousUser")) {
            session.setAttribute("customer", customerRepository.findByPhoneNumber(user));
        }

        return "homepage";
    }

    @GetMapping("/coming_soon")
    public String comingSoon(Model theModel) {
        return "/platforms/comingsoon";
    }

    @GetMapping("/login")
    public String login() {
        return "/platforms/login";
    }

}
