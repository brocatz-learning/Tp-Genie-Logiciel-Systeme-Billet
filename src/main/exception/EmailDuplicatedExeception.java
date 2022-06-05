package exception;

public class EmailDuplicatedExeception extends Exception {

    public EmailDuplicatedExeception() {
        super();
    }

    public EmailDuplicatedExeception(String message) {
        super(message);
    }
}

