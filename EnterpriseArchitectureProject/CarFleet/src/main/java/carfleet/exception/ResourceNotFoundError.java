package carfleet.exception;

public class ResourceNotFoundError extends Exception{
    private String message;

    public ResourceNotFoundError( String message1) {
      //  super(message);
        this.message = message1;
    }
}
