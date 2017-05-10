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
        BindingVisitor bindingVisitor = new BindingVisitor();
        bindingVisitor.visit(ast);
        BindingVisitor.hasFunctionsBeenDeclared = true;
        bindingVisitor.visit(ast);

        if(BindingVisitor.hasBindingErrorOccured){
            System.exit(0);
        }


        //TypeChecker typeChecker = new TypeChecker();
        //typeChecker.visit(ast);

        //if (typeChecker.programHasTypeErrors){
          //  System.out.println("Program has type errors, exiting ..");
            //System.exit(0);
        //} else {
          //  System.out.println("No errors occured during type checking");
        //}

        //PrettyPrintVisitor prettyPrintVisitor = new PrettyPrintVisitor();
        //prettyPrintVisitor.visit(ast);

		StrategyVisitor strategyVisitor = new StrategyVisitor();
        strategyVisitor.visit(ast);

//        TypeChecker typeChecker = new TypeChecker();
//        typeChecker.visit(ast);

		System.out.println("Type checking done.");

		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.newCustomEvents);
		codeGenerator.visit(ast);

        System.out.println("Code generation done.");
    }
}
