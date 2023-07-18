package com.example.TheCompHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/aboutus")
    public String aboutUs() {
        return "html/aboutus";
    }

    @GetMapping("/accessory")
    public String accessory() {
        return "html/accessory";
    }

    @GetMapping("/admin")
    public String admin() {
        return "html/admin";
    }

    @GetMapping("/gears")
    public String gears() {
        return "html/gears";
    }

    @GetMapping("/linkingit")
    public String linkingIt() {
        return "html/linkingit";
    }

    @GetMapping("/new-arrivals")
    public String newArrivals() {
        return "html/new-arrivals";
    }

    @GetMapping("/product")
    public String product() {
        return "html/product";
    }

    @GetMapping("/bestsellers")
    public String bestsellers() {
        return "html/bestsellers";
    }
    @GetMapping("/loginform")
    public String loginform() {
        return "html/loginform";
    }
}
