package _5.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        // http://localhost:8080/hello
        // http://localhost:8080/hello-static.html
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    //default 값이 value값을 넣어줘야함. 그렇지 않아도 에러가 안나려면 다음과 같이, 필수를 false로 바꿔주면 됨.
    public String helloMvc(@RequestParam("name") String name, Model model)
    //public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name; // "hello spring"
    }

    static class Hello
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //객체 반환 시 기본으로 json 으로 반환
    @GetMapping("hello-api")
    @ResponseBody // 이런 @붙은걸 애노테이션이라고 함.
    public Hello helloApi(@RequestParam("name") String name)
    {
        //ctrl shift enter 단축키 자동완성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

}
