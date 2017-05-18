import CompilerError.OverrideDefaultFunctionError;
import CompilerError.RedeclarationError;
import CompilerError.ShadowingError;

import java.util.HashMap;
import java.util.Stack;

public class FunctionBindingVisitor extends Visitor {

    private Stack<HashMap<String, ASTNode>> symbolTable;

    public HashMap<String, HashMap<String, DefineFunctionNode>> getStrategyEnvironment() {
        return strategyEnvironment;
    }

    private HashMap<String, HashMap<String, DefineFunctionNode>> strategyEnvironment = new HashMap<>();
    private HashMap<String, DefineFunctionNode> funcEnvironment = null;
    private boolean insideStrategy = false;
    private boolean insideDefaultStrategy = false;

    public FunctionBindingVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
    }

    public Stack<HashMap<String, ASTNode>> getSymbolTable(){
        return symbolTable;
    }

    @Override
    public void visit(ProgNode node) {
        if (node.setupNode != null) {
            node.setupNode.accept(this);
        }
        for (DefineFunctionNode defineFunctionsNode : node.defineFunctionNodes) {
            defineFunctionsNode.accept(this);
        }

        node.defaultStrategyNode.accept(this);
        for (StrategyNode strategyNode : node.strategyNodes) {
            strategyNode.accept(this);
        }
    }

    @Override
    public void visit(DefaultStrategyNode node) {
        insideStrategy = true;
        insideDefaultStrategy = true;
        funcEnvironment = new HashMap<>();
        super.visit(node);
        strategyEnvironment.put("default", funcEnvironment);
        insideDefaultStrategy = false;
        insideStrategy = false;
    }

    @Override
    public void visit(StrategyNode node) {
        insideStrategy = true;
        funcEnvironment = new HashMap<>();
        super.visit(node);
        strategyEnvironment.put(node.idNode.id, funcEnvironment);
        insideStrategy = false;
    }

    @Override
    public void visit(DefineFunctionNode node) {
        if(!insideStrategy) {
            if(symbolTable.peek().containsKey(node.idNode.id)){
                Main.CompileErrors.add(new RedeclarationError(node.columnNumber, node.lineNumber, node.idNode.id));
            }
            else {
                symbolTable.peek().put(node.idNode.id, node);
            }
        }
        else if(!symbolTable.peek().containsKey(node.idNode.id)){
            if(!funcEnvironment.containsKey(node.idNode.id)) {
                if(insideDefaultStrategy){
                    funcEnvironment.put(node.idNode.id, node);
                }
                else if(!strategyEnvironment.get("default").containsKey(node.idNode.id)) {
                    funcEnvironment.put(node.idNode.id, node);
                }
                else if (!insideDefaultStrategy && strategyEnvironment.get("default").containsKey(node.idNode.id)){
                    Main.CompileErrors.add(new OverrideDefaultFunctionError(node.columnNumber,
                        node.lineNumber, node.idNode.id,
                        strategyEnvironment.get("default").get(node.idNode.id).lineNumber));
                }
            }else{
                Main.CompileErrors.add(new RedeclarationError(node.columnNumber, node.lineNumber, node.idNode.id));
            }
        }
        else{
           Main.CompileErrors.add(new ShadowingError(node.columnNumber,node.lineNumber,
               node.idNode.id, symbolTable.peek().get(node.idNode.id).lineNumber));
        }
    }
}
