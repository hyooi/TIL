package springreactive.springwebflux.user.controller.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class UserResponse {
    private final String id;
    private final String name;
    private final int age;
    private final long followCount;
    private final Optional<ProfleImageResponse> image;
}
