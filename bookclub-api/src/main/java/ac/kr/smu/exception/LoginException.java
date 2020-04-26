package ac.kr.smu.exception;

public class LoginException extends RuntimeException{
    public LoginException(String msg, Throwable t){
        super(msg,t);
    }
    public LoginException(String msg){
        super(msg);
    }
    public LoginException(){
        super();
    }
}
