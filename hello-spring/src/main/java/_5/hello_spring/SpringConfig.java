package _5.hello_spring;

import _5.hello_spring.repository.MemberRepository;
import _5.hello_spring.repository.MemoryMemberRepository;
import _5.hello_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 Spring Bean 직접 구현방법
 Controller 는 스프링이 관리하기 때문에, 컴포넌트 스캔으로 올라가므로, Autowired 설정한다.
 */

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
