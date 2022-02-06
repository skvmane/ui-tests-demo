package exceptions;

public class BrowserNotSupportedException extends IllegalStateException {
    public BrowserNotSupportedException (String message) {
        super(message);
    }
}