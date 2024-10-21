package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.common.WebAdapter;
import com.fastcampuspay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request
        // request -> command(request가 변동되더라도 command에 영향가지 않도록 설정)
        // usecase

        var command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
