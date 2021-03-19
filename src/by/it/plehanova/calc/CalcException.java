package by.it.plehanova.calc;

public class CalcException extends Exception{
    public CalcException() {
        super();
        RepoVar.saveConsoleOut(this.getMessage());
    }

    public CalcException(String message) {
        super(ConsoleRunner.lang.get(Error.ERROR) + ": " + message);
        RepoVar.saveConsoleOut(this.getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.lang.get(Error.ERROR) + ": " + message, cause);
        RepoVar.saveConsoleOut(this.getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        RepoVar.saveConsoleOut(this.getMessage());
    }
}
