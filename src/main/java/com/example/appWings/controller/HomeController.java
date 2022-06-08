/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appWings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author SAMIR
 */
@Controller
public class HomeController {

    @GetMapping
    public String goHome(Model model) {
        model.addAttribute("titulo", "Bienvenido a Thymeleaf");
        return "index";

    }
}
