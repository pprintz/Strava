import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Error> CompileErrors = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        ASTNode ast = null;
        if (args.length > 0) {
            inputFile = args[0];
        }
        if (inputFile != null) {
            ast = GenerateAST(new FileInputStream(inputFile));
        } else {
            ast = GenerateAST(System.in);
        }

        FunctionBindingVisitor functionBindingVisitor = new FunctionBindingVisitor();
        functionBindingVisitor.visit(ast);
        BindingVisitor bindingVisitor = new BindingVisitor(functionBindingVisitor.getSymbolTable());
        bindingVisitor.visit(ast);


        ValidReturnVisitor vrv = new ValidReturnVisitor();
        vrv.visit(ast);

        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(ast);
		System.out.println("Type checking done.");


		if (BindingVisitor.hasBindingErrorOccured || typeChecker.programHasTypeErrors || vrv.hasReturnError) {
            for(Error e : Main.CompileErrors){
                System.out.println(e.toString());
            }
            System.exit(0);
        }
        StrategyVisitor strategyVisitor = new StrategyVisitor();
		strategyVisitor.visit(ast);
		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.newCustomEvents);
		codeGenerator.visit(ast);

		System.out.println("Code generation done.");
        System.out.println("Everything went okay.");
    }

    public static ASTNode GenerateAST(InputStream is) throws Exception {

        ANTLRInputStream input = new ANTLRInputStream(is);

        RobocommandeLexer lexer = new RobocommandeLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RobocommandeParser parser = new RobocommandeParser(tokens);

        ParseTree cst = parser.prog();
        ASTBuilder astBuilder = new ASTBuilder();
        return astBuilder.visit(cst);
    }
}
