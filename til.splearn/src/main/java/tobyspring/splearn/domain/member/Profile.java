package tobyspring.splearn.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.util.regex.Pattern;

public record Profile(String address) {
    private static final Pattern PROFILE_ADDRESS_PATTERN = Pattern.compile("[a-z0-9]+");

    public Profile {
        if (!PROFILE_ADDRESS_PATTERN.matcher(address).matches()) {
            throw new IllegalArgumentException("Invalid profile address");
        }

        if (address.length() > 15) {
            throw new IllegalArgumentException("Invalid profile address");
        }
    }

    public String url() {
        return "@" + address;
    }
}
