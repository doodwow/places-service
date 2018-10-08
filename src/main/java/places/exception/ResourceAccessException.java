package places.exception;

public class ResourceAccessException extends BaseException {

	public ResourceAccessException(ErrorData errorData) {
		super(errorData);
	}

	public ResourceAccessException(ErrorData errorData, Throwable t) {
		super(errorData, t);
	}

}
