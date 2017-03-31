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


    private void OpenScope(){
        symbolTable.push(new HashMap<>());
    }
    private void CloseScope(){
        symbolTable.pop();
    }
    private void InsertInCurrentScope(String key, ASTNode val){
        symbolTable.peek().put(key, val);
        System.out.println("INSERT: " + key + " INTO SCOPE #" + (symbolTable.size() - 1) );
    }

    private void DeclarationInCurrentScope(String key, ASTNode val){
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if( ! alreadyDeclared ){
            InsertInCurrentScope(key, val);
        } else {
            System.out.println("DECLARE FAILED WITH: " + key);
        }
    }

    private void NewDeclarationInCurrentScope(String key, ASTNode val){
        boolean alreadyDeclared = KeyExistsInCurrentOrOuterScope(key);
        if( ! alreadyDeclared){
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

    private void AssignOrDeclareInCurrentScope(String key, ASTNode val){
        if(KeyExistsInCurrentOrOuterScope(key)){ // assign
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(key)) {
                    symbolTable.get(i).replace(key, val);
                    System.out.println("ASSIGN: " + key + " INTO SCOPE #" + i );
                    break;
                }

            }
        } else{ // implicit declaration
            DeclarationInCurrentScope(key, val);
        }
    }
    private void LookUpStructAndPutFieldsInSymbolTable(String structName, String id){
        for(int i = symbolTable.size()-1; i >= 0; i--){
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

    @Override
    public void visit(DeclarationNode node) {
        if(node.typeIdNode.type.equals("num") ||
                node.typeIdNode.type.equals("text") ||
                node.typeIdNode.type.equals("bool")){
            DeclarationInCurrentScope(node.typeIdNode.id, node);
        }
        else {
            LookUpStructAndPutFieldsInSymbolTable(node.typeIdNode.type, node.typeIdNode.id);
        }
    }

    @Override
    public void visit(DivNode node) {
        super.visit(node);
    }

    @Override
    public void visit(FieldIdNode node) {
        super.visit(node);
    }

    @Override
    public void visit(FormalParamsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(GeqThanNode node) {
        super.visit(node);
    }

    @Override
    public void visit(GreaterThanNode node) {
        super.visit(node);
    }

    @Override
    public void visit(GroupedExpressionNode node) {
        super.visit(node);
    }

    @Override
    public void visit(TypeIdNode node) {
        super.visit(node);
    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        super.visit(node);
    }

    @Override
    public void visit(InEqualityNode node) {
        super.visit(node);
    }

    @Override
    public void visit(LeqThanNode node) {
        super.visit(node);
    }

    @Override
    public void visit(LessThanNode node) {
        super.visit(node);
    }

    @Override
    public void visit(MinusNode node) {
        super.visit(node);
    }

    @Override
    public void visit(ModNode node) {
        super.visit(node);
    }

    @Override
    public void visit(MultNode node) {
        super.visit(node);
    }

    @Override
    public void visit(NegateBoolNode node) {
        super.visit(node);
    }

    @Override
    public void visit(NegateExpressionNode node) {
        super.visit(node);
    }
    @Override
    public void visit(AndNode node) {
        super.visit(node);
    }

    @Override
    public void visit(OrNode node) {
        super.visit(node);
    }

    @Override
    public void visit(PlusNode node) {
        super.visit(node);
    }

    @Override
    public void visit(PowerNode node) {
        super.visit(node);
    }

    @Override
    public void visit(ReturnStatementNode node) {
        super.visit(node);
    }

    @Override
    public void visit(StructDefinitionNode node) {
        for(TypeIdNode id : node.typeIdNodes){
            InsertInCurrentScope(node.structIdNode.id + "." + id.id, id);
        }
        for(AssignmentNode ass : node.assignments){
            InsertInCurrentScope(node.structIdNode.id + "." + ass.typeIdNode.id, ass);
        }
    }

    @Override
    public void visit(StructInitializationNode node) {
        for(AssignmentNode ass : node.assignments){

        }
    }
}
