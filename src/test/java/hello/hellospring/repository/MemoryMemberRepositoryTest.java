package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*; // static import

public class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    // 단위테스트
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
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

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member memberA = new Member();
        memberA.setName("springA");
        repository.save(memberA);

        Member memberB = new Member();
        memberB.setName("springB");
        repository.save(memberB);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
