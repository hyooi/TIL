package tobyspring.splearn.application.member.provided;

import org.springframework.data.repository.CrudRepository;
import tobyspring.splearn.domain.member.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
