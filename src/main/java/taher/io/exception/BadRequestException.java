package taher.io.exception;
import java.util.Arrays;
import java.util.List;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String message;
	private final Object data;

	public BadRequestException(String message) {
		super();
		this.message = message;
		this.data = null;
	}

	public BadRequestException(String message, Exception e) {
		super(e);
		this.message = message;
		this.data = null;
	}

	public BadRequestException(String message, List<String> data) {
		super();
		this.message = message;
		this.data = data;
	}

	public BadRequestException(String message, String data) {
		super();
		this.message = message;
		this.data = Arrays.asList(data.split(","));
	}

	public BadRequestException(String message, List<String> data, Exception e) {
		super(e);
		this.message = message;
		this.data = data;
	}

	public BadRequestException(String message, Object data){
		super();
		this.message = message;
		this.data = data;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}


}
