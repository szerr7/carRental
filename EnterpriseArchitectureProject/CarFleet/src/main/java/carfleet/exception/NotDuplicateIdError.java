package carfleet.exception;

public class NotDuplicateIdError extends  Exception{
   private String message ;

    public NotDuplicateIdError(String message) {
        super(message);
        System.out.println(message);
       // this.message = message1;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
