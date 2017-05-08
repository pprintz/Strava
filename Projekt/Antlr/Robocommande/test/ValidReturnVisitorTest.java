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
    private ASTNode astGood2;
    private ASTNode astGood3;
    private ASTNode astGood4;
    private ASTNode astBad1;
    private ASTNode astBad2;
    private ASTNode astBad3;
    @Before
    public void Before() throws Exception{

        astGood1 = generateAST("testFiles/good01");
        astGood2 = generateAST("testFiles/good02");
        astGood3 = generateAST("testFiles/good03");
        astGood4 = generateAST("testFiles/good04");
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
        System.out.println("... good01 passed\n");

        System.out.println("Running test on Good02...");
        validReturnVisitor.visit(astGood2);
        assertFalse(validReturnVisitor.hasReturnError);
        System.out.println("... good02 passed\n");

        System.out.println("Running test on Good03...");
        validReturnVisitor.visit(astGood3);
        assertFalse(validReturnVisitor.hasReturnError);
        System.out.println("... good03 passed\n");

        System.out.println("Running test on Good04...");
        validReturnVisitor.visit(astGood4);
        assertFalse(validReturnVisitor.hasReturnError);
        System.out.println("... good04 passed\n");

        System.out.println("Running test on Bad01...");
        validReturnVisitor.visit(astBad1);
        assertTrue(validReturnVisitor.hasReturnError);
        System.out.println("... Bad01 passed\n");

        System.out.println("Running test on Bad02...");
        validReturnVisitor.visit(astBad2);
        assertTrue(validReturnVisitor.hasReturnError);
        System.out.println("... Bad02 passed\n");

        System.out.println("Running test on Bad03...");
        validReturnVisitor.visit(astBad3);
        assertTrue(validReturnVisitor.hasReturnError);
        System.out.println("... Bad03 passed\n");
    }

}
