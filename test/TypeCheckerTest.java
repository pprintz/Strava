import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pprintz on 5/10/17.
 */
public class TypeCheckerTest {
    private ASTNode astBad1;
    private ASTNode astBad2;
    private ASTNode astBad3;
    private ASTNode astGood1;
    private ASTNode astGood2;
    private ASTNode astGood3;
    private ASTNode astGood4;

    @Before
    public void Before() throws Exception {


        astBad1 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/bad02")));
        astBad2 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/bad03")));
        astBad3 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/bad04")));
        astGood1 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/good01")));
        astGood2 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/good02")));
        astGood3 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/good03")));
        astGood4 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/good04")));
    }

    private ASTNode DecorateAST(ASTNode ast) {
        FunctionBindingVisitor functionBindingVisitor = new FunctionBindingVisitor();
        functionBindingVisitor.visit(ast);
        BindingVisitor bindingVisitor = new BindingVisitor(functionBindingVisitor.getSymbolTable(), functionBindingVisitor.getStrategyEnvironment());
        bindingVisitor.visit(ast);
        return ast;
    }

    @Test
    public void TypeCheckerTest() {
        TypeChecker typeChecker = new TypeChecker();
        System.out.println("running bad1");
        typeChecker.visit(astBad1);
        assertTrue(typeChecker.programHasTypeErrors);
        System.out.println("... bad01 passed\n");

        typeChecker.programHasTypeErrors = false;
        System.out.println("running bad2");
        typeChecker.visit(astBad2);
        assertTrue(typeChecker.programHasTypeErrors);
        System.out.println("... bad02 passed\n");


        typeChecker.programHasTypeErrors = false;
        System.out.println("running bad3");
        typeChecker.visit(astBad3);
        assertTrue(typeChecker.programHasTypeErrors);
        System.out.println("... bad03 passed\n");

        typeChecker.programHasTypeErrors = false;
        System.out.println("running good1");
        typeChecker.visit(astGood1);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... good1 passed\n");


        typeChecker.programHasTypeErrors = false;
        System.out.println("running good2");
        typeChecker.visit(astGood2);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... good2 passed\n");


        typeChecker.programHasTypeErrors = false;
        System.out.println("running good3");
        typeChecker.visit(astGood3);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... good3 passed\n");

        typeChecker.programHasTypeErrors = false;
        System.out.println("running good4");
        typeChecker.visit(astGood4);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... good4 passed\n");
    }

}
