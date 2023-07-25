package demo.member.service.exception;

public class MemberNotFoundException extends IllegalArgumentException {

    public MemberNotFoundException(final String message) {
        super(message);
    }
}
