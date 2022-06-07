package exception;

public class ProjetNotAssignableToUserExeception extends Exception {

    private static final long serialVersionUID = 1L;

    public ProjetNotAssignableToUserExeception() {
        super();
    }

    public ProjetNotAssignableToUserExeception(String message) {
        super(message);
    }

}
