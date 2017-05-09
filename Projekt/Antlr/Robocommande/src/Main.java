import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        RobocommandeLexer lexer = new RobocommandeLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        RobocommandeParser parser = new RobocommandeParser(tokens);

        ParseTree cst = parser.prog();

        //System.out.println(tree.toStringTree(parser));
        //PrettyPrinter prettyPrinter = new PrettyPrinter();
        //System.out.println(prettyPrinter.visit(tree));

        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(cst);

        FunctionBindingVisitor functionBindingVisitor = new FunctionBindingVisitor();
        functionBindingVisitor.visit(ast);
        BindingVisitor bindingVisitor = new BindingVisitor(functionBindingVisitor.getSymbolTable());
        bindingVisitor.visit(ast);

        if(BindingVisitor.hasBindingErrorOccured){
            System.exit(0);
        }

		//StrategyVisitor strategyVisitor = new StrategyVisitor();
        //strategyVisitor.visit(ast);

        ValidReturnVisitor vrv = new ValidReturnVisitor();
        vrv.visit(ast);

        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(ast);

        //JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies);
        //codeGenerator.visit(ast);

		System.out.println("Everything went okay.");


        System.out.println("Everything went okay.");
    }
}
