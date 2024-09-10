// update the class
class BadRequestException extends Exception{
    public String message;

    public BadRequestException(String message){
        super(message);
    }
}