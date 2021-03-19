package by.it.soldatenko.calc;

public class CalcException extends Exception {
    public CalcException() { super();    }

    public CalcException(String message) {super(Language.get(Messages.ERROR) +" : " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Language.get(Messages.ERROR) +" : "+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
