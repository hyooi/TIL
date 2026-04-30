package tobyspring.splearn.domain.member;

public record MemberRegisterRequest(Email email, String nickname, String password, String passwordHash) {
}
