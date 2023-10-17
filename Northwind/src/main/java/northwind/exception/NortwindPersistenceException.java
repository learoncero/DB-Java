package northwind.exception;

public class NortwindPersistenceException extends Throwable {
	private static final long serialVersionUID = 1L;

	public NortwindPersistenceException(String message) {
		super(message);
	}
}