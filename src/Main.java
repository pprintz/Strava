import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String inputFileName;
    public static List<CompilerError.Error> CompileErrors = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        ASTNode ast = null;
        if (args.length > 0) {
            inputFile = args[0];
            String[] strings = inputFile.split("/");
            int lastSubStringIndex = strings.length -1;
            inputFileName = strings[lastSubStringIndex];
            String[] sub = inputFileName.split("\\.");
            inputFileName = sub[0];

        }
        if (inputFile != null) {
            ast = GenerateAST(new FileInputStream(inputFile));
        } else {
            ast = GenerateAST(System.in);
        }

        FunctionBindingVisitor functionBindingVisitor = new FunctionBindingVisitor();
        functionBindingVisitor.visit(ast);
        BindingVisitor bindingVisitor = new BindingVisitor(functionBindingVisitor.getSymbolTable(), functionBindingVisitor.getStrategyEnvironment());
        bindingVisitor.visit(ast);
        if(!CompileErrors.isEmpty()){
            PrintErrorsAndTerminate();
        }

        ValidReturnVisitor vrv = new ValidReturnVisitor();
        vrv.visit(ast);

        if(!CompileErrors.isEmpty()){
            PrintErrorsAndTerminate();
        }

        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(ast);

        if(!CompileErrors.isEmpty()){
            PrintErrorsAndTerminate();
        }
		System.out.println("Type checking done.");

        StrategyVisitor strategyVisitor = new StrategyVisitor();
		strategyVisitor.visit(ast);

		inputFileName = "StrategyJava/StravaOutput";
		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.newCustomEvents);
		codeGenerator.visit(ast);

		System.out.println("Code generation done.");
        System.out.println("Everything went okay.");
    }
    private static void PrintErrorsAndTerminate() {
        for (CompilerError.Error e : CompileErrors) {
            System.out.println(e);
        }
        System.exit(0);
    }

    public static ASTNode GenerateAST(InputStream is) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(is);
        StravaLexer lexer = new StravaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StravaParser parser = new StravaParser(tokens);
        ParseTree cst = parser.prog();
        ASTBuilder astBuilder = new ASTBuilder();
        return astBuilder.visit(cst);
    }
}
