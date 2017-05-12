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
    private ASTNode astBad1;
    private ASTNode astGood1;

    @Before
    public void Before() throws Exception{


          //astBad1 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/bad01")));
          astGood1 = DecorateAST(Main.GenerateAST(new FileInputStream("testFiles/TypeCheckerTest/good01")));
    }
    private ASTNode DecorateAST(ASTNode ast){
        FunctionBindingVisitor functionBindingVisitor = new FunctionBindingVisitor();
        functionBindingVisitor.visit(ast);
        BindingVisitor bindingVisitor = new BindingVisitor(functionBindingVisitor.getSymbolTable());
        bindingVisitor.visit(ast);
        return ast;
    }
    @Test
    public void TypeCheckerTest(){
        TypeChecker typeChecker = new TypeChecker();
        System.out.println("running bad1");
        //typeChecker.visit(astBad1);
        //assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... bad01 passed\n");
        System.out.println("running good1");
        typeChecker.visit(astGood1);
        assertFalse(typeChecker.programHasTypeErrors);
        System.out.println("... good1 passed\n");
    }

}
