package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void join() {
        Member member = new Member();
        member.setName("first");
        memberRepository.save(member);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("hi");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("hello");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
    }

    @Test
    void findMembers() {
        Member memberA = new Member();
        memberA.setName("second");
        memberRepository.save(memberA);

        MemberService memberService = new MemberService();
        Long saveId = memberA.getId();

        Member findMember = memberService.findOne(saveId).get();
        Optional<Member> result = memberRepository.findByName("second");

        Assertions.assertThat(memberA.getId()).isEqualTo(saveId);
    }
}