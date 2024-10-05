package _5.hello_spring.repository;

import _5.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //Optional은 java8에 들어간건데, 없으면 NULL로 반환을 해주니까 감싸서 반환을 해줌.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
