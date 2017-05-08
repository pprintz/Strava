import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by pprintz on 5/8/17.
 */
public class ValidReturnVisitorTest {
    private ASTNode astGood1;
    private ASTNode astBad1;
    private ASTNode astBad2;
    private ASTNode astBad3;
    @Before
    public void Before() throws Exception{

        astGood1 = generateAST("testFiles/good01");
        astBad1 = generateAST("testFiles/bad01");
        astBad2 = generateAST("testFiles/bad02");
        astBad3 = generateAST("testFiles/bad03");

    }
    private ASTNode generateAST(String path) throws Exception{

        InputStream is = new FileInputStream(path);

        ANTLRInputStream input = new ANTLRInputStream(is);

        RobocommandeLexer lexer = new RobocommandeLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RobocommandeParser parser = new RobocommandeParser(tokens);

        ParseTree cst = parser.prog();

        ASTBuilder astBuilder = new ASTBuilder();

        return astBuilder.visit(cst);
    }
    @Test
    public void ValidReturnTest(){
        ValidReturnVisitor validReturnVisitor = new ValidReturnVisitor();
        System.out.println("Running test on Good01...");
        validReturnVisitor.visit(astGood1);
        assertFalse(validReturnVisitor.hasReturnError);
        System.out.println("Running test on Bad01...");
        validReturnVisitor.visit(astBad1);
        assertTrue(validReturnVisitor.hasReturnError);
        System.out.println("Running test on Bad02...");
        validReturnVisitor.visit(astBad2);
        assertTrue(validReturnVisitor.hasReturnError);
        System.out.println("Running test on Bad03...");
        validReturnVisitor.visit(astBad3);
        assertTrue(validReturnVisitor.hasReturnError);
    }

}
