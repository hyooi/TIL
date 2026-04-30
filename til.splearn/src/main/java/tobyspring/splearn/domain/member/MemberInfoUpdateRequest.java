package tobyspring.splearn.domain.member;

import org.antlr.v4.runtime.misc.NotNull;

public record MemberInfoUpdateRequest(
        @Size(min = 5, max = 20) String nickname,
        @NotNull @Size(min = 1, max = 15) String profileAddress,
        @NotNull String introduction) {
}
