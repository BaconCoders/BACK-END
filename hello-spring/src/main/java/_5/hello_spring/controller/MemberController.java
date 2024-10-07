package _5.hello_spring.controller;

import _5.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // new 해서 사용하면, 멤버컨트롤러를 사용하는 모든 곳에서 멤버 서비스 인스턴스를 생성함
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    //Autowired 는 스프링 컨테이너에서 MemberService 를 가져오게 됨.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
