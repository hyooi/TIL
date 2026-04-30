package tobyspring.splearn.domain.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfileTest {
    @Test
    void url() {
        var profile = new Profile("tobylee");
        assertThat(profile.url()).isEqualTo("@tobylee");
    }
}