import org.junit.Before;
import org.junit.Test;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 * Created by pprintz on 5/8/17.
 */
public class ValidReturnVisitorTest {
    @Before
    public void Before() throws Exception{

        InputStream is = new FileInputStream("testFiles/testfile_1");
        ANTLRInputStream input = new ANTLRInputStream(is);
        RobocommandeLexer lexer = new RobocommandeLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RobocommandeParser parser = new RobocommandeParser(tokens);

        ParseTree cst = parser.prog();

        //System.out.println(tree.toStringTree(parser));
        //PrettyPrinter prettyPrinter = new PrettyPrinter();
        //System.out.println(prettyPrinter.visit(tree));

        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode astOne = astBuilder.visit(cst);
        ASTNode astTwo = astBuilder.visit(cst);
        ASTNode astThree = astBuilder.visit(cst);
        ASTNode astFour = astBuilder.visit(cst);
    }
    @Test
    public void ValidReturnTest(){

    }

}
