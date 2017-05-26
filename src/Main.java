import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static String inputFileName;
    public static List<CompilerError.Error> CompileErrors = new ArrayList<>();
    public static List<CompilerError.Error> CompileWarnings = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ASTNode ast;
        String inputFile = "";
        if (args.length > 0) {
            inputFile = args[0];
            String[] strings = inputFile.split("/");
            inputFileName = strings[strings.length - 1];
            String[] sub = inputFileName.split("\\.");
            inputFileName = sub[0];
        }
        if (inputFileName != null) {
            ast = GenerateAST(new FileInputStream(inputFile));
        } else {
            ast = GenerateAST(System.in);
        }
        CompileSourceAndGetTarget(ast);
    }
    private static void CompileSourceAndGetTarget(ASTNode ast){

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

        CheckBehaviorsAndEventsVisitor checkBehaviorsAndEventsVisitor = new CheckBehaviorsAndEventsVisitor();
        checkBehaviorsAndEventsVisitor.visit(ast);
        if(!CompileErrors.isEmpty()){
            PrintErrorsAndTerminate();
        }


        StrategyVisitor strategyVisitor = new StrategyVisitor();
		strategyVisitor.visit(ast);

		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.newCustomEvents);
		codeGenerator.visit(ast);

		for(CompilerError.Error e : CompileWarnings){
		    System.out.println("WARNING " + e);
        }

    }
    public static boolean parseErrorOccurred = false;
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
        parser.addErrorListener(new stravaErrorListener());
        ParseTree cst = parser.prog();
        if(parseErrorOccurred){
            System.exit(0);
        }
        ASTBuilder astBuilder = new ASTBuilder();
        return astBuilder.visit(cst);
    }
    static class stravaErrorListener implements ANTLRErrorListener {

        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            parseErrorOccurred = true;
        }

        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

        }
    }
}
