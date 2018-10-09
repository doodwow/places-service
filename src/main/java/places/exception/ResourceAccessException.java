package places.exception;

public class ResourceAccessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1019822640826392842L;

	public ResourceAccessException(ErrorData errorData) {
		super(errorData);
	}

	public ResourceAccessException(ErrorData errorData, Throwable t) {
		super(errorData, t);
	}

}
