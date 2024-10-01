package _5.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        // http://localhost:8080/hello
        // 강의 듣다가 멈춤.... hello!!가 안나와!!!
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
