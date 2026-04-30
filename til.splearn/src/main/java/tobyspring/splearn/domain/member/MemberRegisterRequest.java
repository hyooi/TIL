package tobyspring.splearn.domain.member;

import tobyspring.splearn.domain.shared.Email;

public record MemberRegisterRequest(Email email, String nickname, String password) {
}
