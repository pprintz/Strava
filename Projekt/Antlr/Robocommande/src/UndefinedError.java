/**
 * Created by Teitur on 08-05-2017.
 */
public class UndefinedError extends Error {

    private String referenceName;

    public UndefinedError(int columnNumber, int lineNumber, String referenceName) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
    }

    @Override
    public String toString() {
        return lineNumber +  ": " + referenceName + " not defined";
    }
}
