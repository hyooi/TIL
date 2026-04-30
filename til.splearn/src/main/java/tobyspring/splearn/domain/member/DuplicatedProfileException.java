package tobyspring.splearn.domain.member;

public class DuplicatedProfileException extends RuntimeException {
    public DuplicatedProfileException(String message) {
        super(message);
    }
}
