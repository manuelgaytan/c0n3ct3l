package mx.com.gahm.conenctel.exceptions;

import java.util.Map;
import java.util.TreeMap;

public class ConectelException extends Exception {

    private static final long serialVersionUID = 1L;
    protected Map<String, String> messages;

    public ConectelException() {
        super();
        messages = new TreeMap<String, String>();
    }

    public ConectelException(String message) {
        super(message);
        messages = new TreeMap<String, String>();
    }

    public ConectelException(Map<String, String> messages) {
        this.messages = messages;
    }

    public ConectelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConectelException(Throwable cause) {
        super(cause);
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }
}
