package _5.hello_spring.service;

import _5.hello_spring.domain.Member;
import _5.hello_spring.repository.MemberRepository;
import _5.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 테스트 케이스 만드는 단축키 Ctrl Shift T
public class MemberService {
    private final MemberRepository memberRepository;// = new MemoryMemberRepository();

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member){
        // 메서드로 들어가는 단축키는 Ctrl B
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //함수로 생성할 부분을 드래그해서 Ctrl Alt M 누르면 함수가 생성됨.
        // 같은 이름이 있는 중복 회원 X
        memberRepository.findByName(member.getName())
            // 이 값이 null이 아닐 때 동작함.
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
