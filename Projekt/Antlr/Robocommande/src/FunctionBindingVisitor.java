import java.util.HashMap;
import java.util.Stack;

/**
 * Created by pprintz on 4/4/17.
 */
public class FunctionBindingVisitor extends Visitor {

    Stack<HashMap<String, ASTNode>> symbolTable;

    public FunctionBindingVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
    }

    public Stack<HashMap<String, ASTNode>> getSymbolTable(){
        return symbolTable;
    }

    @Override
    public void visit(DefineFunctionNode node) {
        symbolTable.peek().put(node.idNode.id, node);
    }
}
