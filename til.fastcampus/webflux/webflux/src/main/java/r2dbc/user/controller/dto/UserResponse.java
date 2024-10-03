package r2dbc.user.controller.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class UserResponse {
    private final long id;
    private final String name;
    private final int age;
    private final long followCount;
    private final Optional<ProfleImageResponse> image;
}
