import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import org.apache.commons.cli.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Main {
    public static String inputFileName;
    public static List<CompilerError.Error> CompileErrors = new ArrayList<>();
    public static List<CompilerError.Error> CompileWarnings = new ArrayList<>();
    public static void main(String[] args) throws Exception {


        Options options = new Options();

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("o", "output", true, "output file path");
        input.setOptionalArg(true);
        options.addOption(output);

        Option rcJar = new Option("rjar", "robojar", true, "path to robocode jar");
        input.setOptionalArg(true);
        options.addOption(rcJar);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Strava", options);

            System.exit(1);
            return;
        }
        String inputFile = cmd.getOptionValue("input");
        ASTNode ast;
        if (args.length > 0) {
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
        if(cmd.hasOption("output")){
            Runtime.getRuntime().exec("javac -d " + cmd.getOptionValue("output") +  inputFileName + ".java");
        }
        else{
            Runtime.getRuntime().exec("javac -cp " + cmd.getOptionValue("robojar") + ":." + inputFileName + ".java" );
        }
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
		System.out.println("Type checking done.");

        StrategyVisitor strategyVisitor = new StrategyVisitor();
		strategyVisitor.visit(ast);

		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.newCustomEvents);
		codeGenerator.visit(ast);

		System.out.println("Code generation done.");
		for(CompilerError.Error e : CompileWarnings){
		    System.out.println("WARNING " + e);
        }
        System.out.println("Everything went okay.");

    }
    public static boolean parseErrorOccured = false;
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
        if(parseErrorOccured){
            System.exit(0);
        }
        ASTBuilder astBuilder = new ASTBuilder();
        return astBuilder.visit(cst);
    }
    static class stravaErrorListener implements ANTLRErrorListener {

        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            parseErrorOccured = true;
        }

        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

        }
    }
}
