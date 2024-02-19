package ECommerce.Exception;


public final class UserWithSameNameAlreadyExistException extends RuntimeException {

    public UserWithSameNameAlreadyExistException() {
        super();
    }

    public UserWithSameNameAlreadyExistException(String message) {
        super(message);
    }

    public UserWithSameNameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserWithSameNameAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public UserWithSameNameAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
