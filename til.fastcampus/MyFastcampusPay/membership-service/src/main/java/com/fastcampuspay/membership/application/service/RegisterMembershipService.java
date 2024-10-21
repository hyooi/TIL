package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adapter.out.persistence.MembershipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.common.UseCase;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
public class RegisterMembershipService implements RegisterMembershipUseCase {
    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    @Transactional
    public Membership registerMembership(RegisterMembershipCommand command) {
        // biz logic -> DB. DB를 통하려면 port, adapter 필요
        var entity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        // entity -> Membership
        return membershipMapper.mapToDomainEntity(entity);
    }
}
