import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pprintz on 5/10/17.
 */
public class TypeCheckerTest {
    private ASTNode astGood1;
    private ASTNode astGood2;
    private ASTNode astGood3;
    private ASTNode astGood4;
    private ASTNode astBad1;
    private ASTNode astBad2;
    private ASTNode astBad3;
    @Before
    public void Before() throws Exception{


          astBad1 = Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/bad01"));
    }
    @Test
    public void TypeCheckerTest(){
        TypeChecker typeChecker = new TypeChecker();
        System.out.println("running bad1");
        typeChecker.visit(astBad1);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... bad01 passed\n");
    }

}
