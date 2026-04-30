package tobyspring.splearn.adapter;

import jakarta.annotation.Nonnull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tobyspring.splearn.domain.member.DuplicatedEmailException;
import tobyspring.splearn.domain.member.DuplicatedProfileException;

import java.time.LocalDate;

@ControllerAdvice
public class ApiControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception) {
        return getProblemDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    @ExceptionHandler({DuplicatedEmailException.class, DuplicatedProfileException.class})
    public ProblemDetail emailExceptionHandler(Exception exception) {
        // RFC9457
        return getProblemDetail(HttpStatus.CONFLICT, exception);
    }

    private static ProblemDetail getProblemDetail(HttpStatus status, Exception exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, exception.getMessage());
        problemDetail.setProperty("timestamp", LocalDate.now());
        problemDetail.setProperty("exception", exception.getClass().getSimpleName());

        return problemDetail;
    }
}
