import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Kasper Dissing Bargsteen on 28/03/2017.
 */
public class SymbolTableBuilder extends Visitor {

    Stack<HashMap<TypeIdNode, ASTNode>> symbolTable;

    public SymbolTableBuilder() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
    }

    private void OpenScope(){
        symbolTable.push(new HashMap<>());
    }
    private void CloseScope(){
        symbolTable.pop();
    }
    private void InsertInCurrentScope(TypeIdNode key, ASTNode val){
        symbolTable.peek().put(key, val);
        System.out.println("INSERT: " + key.id + " INTO SCOPE #" + (symbolTable.size() - 1) );
    }

    private void DeclarationInCurrentScope(TypeIdNode key, ASTNode val){
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if( ! alreadyDeclared ){
            InsertInCurrentScope(key, val);
        } else {
            System.out.println("DECLARE FAILED WITH: " + key.id);
        }
    }

    private void NewDeclarationInCurrentScope(TypeIdNode key, ASTNode val){
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if( ! alreadyDeclared){
            System.out.println("WARNING: New used when no declaration in outer scope : " + key.id);
        }
        InsertInCurrentScope(key, val);
    }


    private boolean KeyExistsInCurrentOrOuterScope(TypeIdNode key) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(key)) {
                return true;
            }
        }
        return false;
    }

    private void AssignOrDeclareInCurrentScope(TypeIdNode key, ASTNode val){
        if(KeyExistsInCurrentOrOuterScope(key)){ // assign
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(key)) {
                    symbolTable.get(i).replace(key, val);
                    System.out.println("ASSIGN: " + key.id + " INTO SCOPE #" + i );
                    break;
                }

            }
        } else{ // implicit declaration
            DeclarationInCurrentScope(key, val);
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        AssignOrDeclareInCurrentScope(node.typeIdNode, node.exprNode);
    }

    @Override
    public void visit(BlockNode node) {
        OpenScope();
        super.visit(node);
        CloseScope();
    }

    @Override
    public void visit(DeclarationNode node) {
        DeclarationInCurrentScope(node.id, node.exprNode);

    }

    @Override
    public void visit(FieldAssignmentNode node) {
        super.visit(node);
    }

    @Override
    public void visit(FieldIdNode node) {
        super.visit(node);
    }


    @Override
    public void visit(NewDeclarationNode node) {
        NewDeclarationInCurrentScope(node.idNode, node.exprNode);
    }

    @Override
    public void visit(ProgNode node) {
        super.visit(node);
    }

    @Override
    public void visit(SetupBlockNode node) {
        super.visit(node);
    }

    @Override
    public void visit(StrategyDefinitionNode node) {
        super.visit(node);
    }

    @Override
    public void visit(StructDefinitionNode node) {
        super.visit(node);
    }

    @Override
    public void visit(StructInitializationNode node) {
        super.visit(node);
    }
}
