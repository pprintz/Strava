import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class SimpleMain {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        SimpleLexer lexer = new SimpleLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpleParser parser = new SimpleParser(tokens);

        ParseTree tree = parser.prog();

        //System.out.println(tree.toStringTree(parser));
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        System.out.println(prettyPrinter.visit(tree));
    }
}