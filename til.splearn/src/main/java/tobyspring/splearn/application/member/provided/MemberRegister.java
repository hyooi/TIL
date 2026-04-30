package tobyspring.splearn.application.member.provided;

import tobyspring.splearn.domain.member.Member;
import tobyspring.splearn.domain.member.MemberInfoUpdateRequest;
import tobyspring.splearn.domain.member.MemberRegisterRequest;

public interface MemberRegister {
    Member register(@Valid MemberRegisterRequest registerRequest);
    Member activate(Long memberId);
    Member deactivate(Long memberId);
    Member updateInfo(Long memberId, @Valid MemberInfoUpdateRequest memberInfoUpdateRequest);
}
