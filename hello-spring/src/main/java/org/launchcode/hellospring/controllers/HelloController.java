package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring";
//    }

    //Handles request at path /goodbye
    @GetMapping("goodbye") //lives at /hello/goodbye
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //Handles request of the from /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    @GetMapping("form") //lives at /hello/form
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("JavaScript");

        model.addAttribute("names", names);

        return "hello-list";
    }
}
