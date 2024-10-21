package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {
    @NotNull
    private final String membershipId;


    public FindMembershipCommand(String membershipId) {
        this.membershipId = membershipId;

        this.validateSelf();
    }
}
