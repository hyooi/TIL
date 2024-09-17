package springreactive.springwebflux.user.controller.dto;

import lombok.Data;

@Data
public class ProfleImageResponse {
    private final String id;
    private final String name;
    private final String url;
}
