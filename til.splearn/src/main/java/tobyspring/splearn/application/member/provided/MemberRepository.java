package tobyspring.splearn.application.member.provided;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tobyspring.splearn.domain.member.Member;
import tobyspring.splearn.domain.member.Profile;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Query("select m from Member m where m.detail.profile = :profile")
    Optional<Member> findByProfile(Profile profile);
}
