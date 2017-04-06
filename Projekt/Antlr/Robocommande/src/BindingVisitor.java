import java.util.HashMap;
import java.util.Stack;

/**
 * Created by pprintz on 4/4/17.
 */
public class BindingVisitor extends Visitor {

    public static boolean hasFunctionsBeenDeclared = false;
    Stack<HashMap<IdNode, ASTNode>> symbolTable;

    public BindingVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
    }
    private void OpenScope(){
        symbolTable.push(new HashMap<>());
    }
    private void CloseScope(){
        symbolTable.pop();
    }

    @Override
    public void visit(TypeNode node) {
    }

    @Override
    public void visit(BlockNode node) {
        OpenScope();
        super.visit(node);
        CloseScope();
    }

    @Override
    public void visit(DeclarationNode node) {
        symbolTable.peek().put(node.idNode, node);
    }

    @Override
    public void visit(DefineFunctionNode node) {
        symbolTable.peek().put(node.idNode, node);
    }
    @Override
    public void visit(StructDefinitionNode node) {
        symbolTable.peek().put(node.structIdNode, node);
    }

    @Override
    public void visit(FieldIdNode node) {
        super.visit(node);
    }
    private void BindIdToDeclaration(IdNode idNode) {
        boolean isDeclared = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(idNode.id)) {
                idNode.declarationNode = (DeclarationNode)symbolTable.get(i).get(idNode.id);
                isDeclared = true;
            }
        }
        if(!isDeclared){
            hasRefError = true;
            PrintNotDeclaredError(" id ", idNode.id);
        }
    }
    public static boolean hasRefError = false;
    private void BindFunctionCallToDeclaration(FunctionCallNode fCallNode) {
        boolean isDeclared = false;
        if(hasFunctionsBeenDeclared) {
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(fCallNode.idNode)) {
                    fCallNode.defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(fCallNode.idNode);
                    isDeclared = true;
                }
            }

            if (!isDeclared) {
                hasRefError = true;
                PrintNotDeclaredError(" function ", fCallNode.idNode.id);
            }
        }
    }
    private void BindExprFunctionCallToDeclaration(ExprFunctionCallNode fCallNode) {
        boolean isDeclared = false;
        if(hasFunctionsBeenDeclared) {
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(fCallNode.idNode.id)) {
                    fCallNode.defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(fCallNode.idNode);
                    isDeclared = true;
                }
            }

            if (!isDeclared) {
                hasRefError = true;
                PrintNotDeclaredError(" function ", fCallNode.idNode.id);
            }
        }
    }
    private void PrintNotDeclaredError(String type, String id){
        System.out.println("There is no" + type + "named: " + id);
    }
    private void BindStructInitializationToDefinition(StructInitializationNode structInitializationNode) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(structInitializationNode.typeNode.type)) {
                structInitializationNode.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(structInitializationNode.typeNode.type);
            }
        }
    }
    @Override
    public void visit(FunctionCallNode node) {
        BindFunctionCallToDeclaration(node);
    }
    @Override
    public void visit(ExprFunctionCallNode node){
        BindExprFunctionCallToDeclaration(node);
    }
    @Override
    public void visit(IdNode node) {
        BindIdToDeclaration(node);
    }

}
