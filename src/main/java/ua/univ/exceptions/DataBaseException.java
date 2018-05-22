package ua.univ.exceptions;

public class DataBaseException extends Exception {
    public DataBaseException() {
    }
    public DataBaseException(Throwable e) {
        super(e);
    }

    public DataBaseException(String s) {
        super(s);
    }
}
