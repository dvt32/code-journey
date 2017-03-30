package beans;

public class Message {
	private int id;
	private String message;
	
	public Message() {
		// Default constructor
	}
	
	public Message(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	// Get & set message ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Get & set message text
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "[id: " + id + ", message: " + message + "]";
	}
}
