import java.util.HashMap;
import java.util.Stack;

/**
 * Created by pprintz on 3/31/17.
 */
public class SemanticsVisitor extends Visitor {

    Stack<HashMap<String, ASTNode>> symbolTable;

    public SemanticsVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
    }


    private void OpenScope() {
        symbolTable.push(new HashMap<>());
    }

    private void CloseScope() {
        symbolTable.pop();
    }

    private void InsertInCurrentScope(String key, ASTNode val) {
        symbolTable.peek().put(key, val);
        System.out.println("INSERT: " + key + " INTO SCOPE #" + (symbolTable.size() - 1));
    }

    private void DeclarationInCurrentScope(String key, ASTNode val) {
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if (!alreadyDeclared) {
            InsertInCurrentScope(key, val);
        } else {
            System.out.println("DECLARE FAILED WITH: " + key);
        }
    }

    private void NewDeclarationInCurrentScope(String key, ASTNode val) {
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if (!alreadyDeclared) {
            System.out.println("WARNING: New used when no declaration in outer scope : " + key);
        }
        InsertInCurrentScope(key, val);
    }


    private boolean KeyExistsInCurrentOrOuterScope(String key) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    private void AssignOrDeclareInCurrentScope(String key, ASTNode val) {
        if (KeyExistsInCurrentOrOuterScope(key)) { // assign
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(key)) {
                    symbolTable.get(i).replace(key, val);
                    System.out.println("ASSIGN: " + key + " INTO SCOPE #" + i);
                    break;
                }

            }
        } else { // implicit declaration
            DeclarationInCurrentScope(key, val);
        }
    }

    private void LookUpStructAndPutFieldsInSymbolTable(String structName, String id) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            int len;
        }
    }

    @Override
    public void visit(ActualParamsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(AssignmentNode node) {
        super.visit(node);
    }

}
