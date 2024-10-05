package _5.hello_spring.repository;

import _5.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

// 같은지 확인하는 코드 (1)
//import org.junit.jupiter.api.Assertions;
// 같은지 확인하는 코드 (2)
import org.assertj.core.api.Assertions;

// jupiter 에서 제공하는 Assertions 의 경우 static 선언 되어 있으므로, 해당 코드 삽입 시 생략 가능.
//import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 모든 테스트 케이스는 순서대로 동작을 보장하지 않음 -> 테스트 생성 시 Clear 함수 호출되도록 설계되어 있음
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // 같은지 확인하는 코드 (1) - 두 개의 Assertions import 주체가 다르나, 하는 역할은 동일함.
        //Assertions.assertEquals(result, member);
        //Assertions.assertEquals(result, null); // ->  이러면 실행했을 때 디버깅 창에 에러 남

        // 같은지 확인하는 코드 (2)
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
