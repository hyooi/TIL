package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.common.PersistenceAdapter;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository springDataMembershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
            return springDataMembershipRepository.save(new MembershipJpaEntity(
                    membershipName.getMembershipName(),
                    membershipEmail.getMembershipEmail(),
                    membershipAddress.getMembershipAddress(),
                    membershipIsValid.isMembershipIsValid(),
                    membershipIsCorp.isMembershipIsCorp()
            ));
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return springDataMembershipRepository.getReferenceById(Long.parseLong(membershipId.getMembershipId()));
    }
}
