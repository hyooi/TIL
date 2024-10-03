package r2dbc.image.common;

import lombok.Data;
import springreactive.springwebflux.image.common.Image;

import java.util.List;
import java.util.Optional;

@Data
public class User {
    private final String id;
    private final String name;
    private final int age;
    private final Optional<Image> profileImage;
    private final List<Article> articleList;
    private final Long followCount;
}