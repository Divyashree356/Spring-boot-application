package com.divyashree.af.controller;

import com.divyashree.af.service.RequestIP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{
    @Autowired
    private RequestIP requestIP;

    @GetMapping("/")
    public  String index(HttpServletRequest request , Model model)
    {
        String clientIPAddress= requestIP.getClientIPaddress(request);
        model.addAttribute("clientIPAddresss" , clientIPAddress);
        return "index";
    }

}
