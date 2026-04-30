package tobyspring.splearn.application.member.provided;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobyspring.splearn.domain.member.Member;

@RequiredArgsConstructor
@Service
public class MemberFinder {
    private final MemberRepository repository;

    public Member find(Long memberId) {
        return repository.findById(memberId).orElseThrow();
    }
}
