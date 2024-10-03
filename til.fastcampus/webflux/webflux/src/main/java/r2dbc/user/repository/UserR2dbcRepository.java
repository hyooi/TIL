package r2dbc.user.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import r2dbc.user.common.UserEntity;

public interface UserR2dbcRepository
        extends R2dbcRepository<UserEntity, Long> {
}