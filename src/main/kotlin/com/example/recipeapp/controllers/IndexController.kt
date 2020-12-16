package com.example.recipeapp.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping(value = ["", "/", "/index"])
    fun getIndexPage(): String{
        return "index"
    }
}