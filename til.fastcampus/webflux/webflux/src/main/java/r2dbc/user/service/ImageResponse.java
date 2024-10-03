package r2dbc.user.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageResponse {
    private String id;
    private String name;
    private String url;
}
