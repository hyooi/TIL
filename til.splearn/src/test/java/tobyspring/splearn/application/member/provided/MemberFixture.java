package tobyspring.splearn.application.member.provided;

import org.springframework.test.util.ReflectionTestUtils;
import tobyspring.splearn.domain.member.Member;
import tobyspring.splearn.domain.member.MemberRegisterRequest;
import tobyspring.splearn.domain.member.PasswordEncoder;

public class MemberFixture {
    public static MemberRegisterRequest createMemberRegisterRequest(String email) {
        return null;
    }

    public static MemberRegisterRequest createMemberRegisterRequest() {
            return null;
    }

    public static Member createMember(Long id) {
        Member member = Member.register(createMemberRegisterRequest(), createPasswordEncoder());
        ReflectionTestUtils.setField(member, "id", id);

        return member;
    }

    private static PasswordEncoder createPasswordEncoder() {
        return  new PasswordEncoder() {};
    }
}
