package places.exception;

public class FoursquareFailedException extends BaseException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FoursquareFailedException(ErrorData errorData) {
        super(errorData);
    }

    public FoursquareFailedException(ErrorData errorData, Throwable cause) {
        super(errorData, cause);
    }

    public FoursquareFailedException(String message) {
        super(new ErrorData(message));
    }

    public FoursquareFailedException(String message, Throwable cause) {
        super(new ErrorData(message), cause);
    }

    public FoursquareFailedException(String message, String code) {
        super(new ErrorData(message, code));
    }

    public FoursquareFailedException(String message, String code, Throwable cause) {
        super(new ErrorData(message, code), cause);
    }
}
