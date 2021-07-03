package cn.itcast.Demo06;

public class RegisException extends /*Exception*/ RuntimeException{
    public RegisException() {
    }

    public RegisException(String message) {
        super(message);
    }
}
