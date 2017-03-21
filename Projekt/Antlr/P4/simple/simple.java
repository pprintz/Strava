/**
 * Created by pprintz on 3/10/17.
 */

import gen.SimpleParserLexer;
import gen.SimpleParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class simple {
    public static void main(String [] args) throws Exception {
        InputStream is = (args.length == 0)
                ?  System.in
                : new FileInputStream(args[0]);

        ANTLRInputStream input = new ANTLRInputStream(is);
        SimpleParserLexer lexer = new SimpleParserLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParserParser parser = new SimpleParserParser(tokens);

        ParseTree tree = parser.prog();

        PrettyPrinter eval = new PrettyPrinter();
        eval.visit(tree);
    }
}
