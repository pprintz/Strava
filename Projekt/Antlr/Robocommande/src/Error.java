/**
 * Created by Teitur on 08-05-2017.
 */
public abstract class Error {

    protected int columnNumber;
    protected int lineNumber;


    public Error(int columnNumber, int lineNumber) {
        this.columnNumber = columnNumber;
        this.lineNumber = lineNumber;
    }

}

