package com.paymybuddy.paymybuddy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logoff")
public class LogoffController {
	
        @GetMapping
        public String logoff(HttpServletRequest request){
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            return "redirect:/login";
        }
}