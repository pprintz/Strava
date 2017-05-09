import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by pprintz on 4/4/17.
 */
public class BindingVisitor extends Visitor {
    ArrayList<String> roboFunctions;

    Stack<HashMap<String, ASTNode>> symbolTable;

    public BindingVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
        roboFunctions = new ArrayList<>();
        roboFunctions.add("ahead");
        roboFunctions.add("turnGunRight");
        roboFunctions.add("back");
        roboFunctions.add("changeStrategy");
    }

    public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions) {
        symbolTable = symbolTableWithFunctions;
    }

    private void OpenScope() {
        symbolTable.push(new HashMap<>());
    }

    private void CloseScope() {
        symbolTable.pop();
    }

    private void BindIdToDeclaration(IdNode idNode) {
        boolean isDeclared = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(idNode.id)) {
                idNode.declarationNode = (DeclarationNode) symbolTable.get(i).get(idNode.id);
                isDeclared = true;
            }
        }
        if (!isDeclared) {
            hasBindingErrorOccured = true;
            PrintNotDeclaredError("id", idNode.id, idNode);
        }
    }

    private StructDefinitionNode BindFieldXToDeclaration(List<IdNode> idNodes) {
        IdNode structId = idNodes.get(0);
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(structId.id)) {
                ASTNode astNode = symbolTable.get(i).get(structId.id);
                DeclarationNode declarationNode = (DeclarationNode) astNode;
                if (declarationNode.structDefinitionNode != null) {
                    return declarationNode.structDefinitionNode;
                }
            }
        }
        return null;
    }

    private void BindFieldIdToDeclaration(FieldIdNode fieldIdNode) {
        boolean isDeclared = false;
        IdNode structId = fieldIdNode.idNodes.get(0);
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(structId.id)) {
                DeclarationNode declarationNode = (DeclarationNode) symbolTable.get(i).get(structId.id);
                if (declarationNode.structDefinitionNode != null) {
                    fieldIdNode.structDefinitionNode = declarationNode.structDefinitionNode;
                    isDeclared = true;
                }
            }
        }
        if (!isDeclared) {
            PrintNotDeclaredError("struct", structId.id, fieldIdNode);
        }
    }

    public static boolean hasBindingErrorOccured = false;

    private DefineFunctionNode BindFunctionCallToDeclaration(ASTNode node, String idName, ActualParamsNode actualParams){
        DefineFunctionNode defineFunctionNode = null;
        boolean isDeclared = false;
        if (roboFunctions.contains(fCallNode.idNode.id)) {
            isDeclared = true;
        }
        if(hasFunctionsBeenDeclared) {
            for (int i = symbolTable.size() - 1; i >= 0; i--) {
                if (symbolTable.get(i).containsKey(fCallNode.idNode)) {
                    fCallNode.defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(fCallNode.idNode);
                    isDeclared = true;
                }
            }
            if (!isDeclared) {
                hasBindingErrorOccured = true;
                PrintNotDeclaredError("function", fCallNode.idNode.id, fCallNode);
            }
        }
    }
    private void BindExprFunctionCallToDeclaration(ExprFunctionCallNode fCallNode) {
        boolean isDeclared = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(idName)) {
                defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(idName);
                isDeclared = true;
                if(actualParams != null){
                    actualParams.exprs.forEach(this::visit);
                }
            }
        }
        if (!isDeclared) {
            hasBindingErrorOccured = true;
            PrintNotDeclaredError(" function ", idName, node);
        }
        return defineFunctionNode;
    }



    private void PrintNotDeclaredError(String type, String id, ASTNode node) {
        System.out.println("There is no " + type + " named: " + id + node.toString());
    }

    private void BindStructInitializationToDefinition(StructInitializationNode structInitializationNode) {
        boolean isStructDefined = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(structInitializationNode.typeNode.type)) {
                structInitializationNode.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(structInitializationNode.typeNode.type);
                isStructDefined = true;
                checkStruckInitValidity(structInitializationNode);
            }
        }
        if (!isStructDefined) {
            PrintNotDeclaredError("struct", structInitializationNode.typeNode.type, structInitializationNode);
        }
    }

    private class DeclBoolTuple {
        DeclarationNode declarationNode;
        Boolean isBound;

        public DeclBoolTuple(DeclarationNode node) {
            declarationNode = node;
            isBound = false;
        }
    }

    private void checkStruckInitValidity(StructInitializationNode structInitializationNode) {
        HashMap<String, DeclBoolTuple> oneToOneDeclAssMap = new HashMap<>();

        structInitializationNode.structDefinitionNode.declarationNodes.forEach((d) -> oneToOneDeclAssMap.put(d.idNode.id, new DeclBoolTuple(d)));

        for (AssignmentNode assignmentNode : structInitializationNode.assignments) {
            boolean doesAssigmentMatchFieldDecl = false;
            DeclBoolTuple tuple = oneToOneDeclAssMap.get(assignmentNode.idNode.id);
            if (tuple != null && !tuple.isBound) {
                assignmentNode.idNode.declarationNode = tuple.declarationNode;
                tuple.isBound = true;
                visit(assignmentNode.exprNode);
            } else if (tuple != null) {
                System.out.println("The field '" + tuple.declarationNode.idNode.id + "' cannot be initialized multiple times.");
                break;
            } else {
                System.out.println("The field '" + assignmentNode.idNode.id + "' does not exist in the definition of struct '" + structInitializationNode.structDefinitionNode.typeNode.type + "'.");
                break;
            }
        }

        for (DeclBoolTuple tuple : oneToOneDeclAssMap.values()) {
            if (!tuple.isBound) {
                System.out.println("The field '" + tuple.declarationNode.idNode.id + "' needs to be initialized.");
            }
        }
    }

    private void BindStructDeclarationToDefinition(DeclarationNode node) {
        boolean isStructDefined = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(node.typeNode.type)) {
                node.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(node.typeNode.type);
                isStructDefined = true;
            }
        }
        if (!isStructDefined) {
            PrintNotDeclaredError("struct", node.typeNode.type, node);
        }
    }

    @Override
    public void visit(FunctionCallNode node) {
        node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id, node.actualParams);
    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id, node.actualParams);
    }

    @Override
    public void visit(IdNode node) {
        if (!node.isDeclaration)
            BindIdToDeclaration(node);
    }

    @Override
    public void visit(StructInitializationNode node) {

        BindStructInitializationToDefinition(node);

    }

    @Override
    public void visit(DeclarationNode node) {

        if (!doesDeclExistLocally(node)) {
            switch (node.typeNode.type) {
                case "num":
                case "text":
                case "bool":
                    symbolTable.peek().put(node.idNode.id, node);
                    break;
                default:
                    BindStructDeclarationToDefinition(node);
                    symbolTable.peek().put(node.idNode.id, node);
            }
            if (node.exprNode != null) {
                visit(node.exprNode);
            }
        } else hasBindingErrorOccured = true;

    }

    // TODO : fields with same names in different struct definit

    private boolean doesDeclExistLocally(DeclarationNode node) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(node.idNode.id)) {
                DeclarationNode declNodeFound = (DeclarationNode) symbolTable.get(i).get(node.idNode.id);
                if (!declNodeFound.IsGlobal) {
                    System.out.println("Already declared variable with name: " + node.idNode.id + " LINE " + declNodeFound.lineNumber);
                    return true;
                } else {
                    if (i == symbolTable.size() - 1) {
                        System.out.println("Already declared variable with name: " + node.idNode.id +
                                " LINE " + declNodeFound.lineNumber + " COLUMN " + declNodeFound.columnNumber);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public void visit(DefineFunctionNode node) {
        if (node.formalParamsNode != null) {
            isParamsVisited = true;
            formalParamsNode = node.formalParamsNode;
        }
        visit(node.blockNode);
    }

    private void includeFormalParamsInScope() {
        for (int i = 0; i < formalParamsNode.idNodes.size(); i++) {
            DeclarationNode dcNode = new DeclarationNode();
            dcNode.typeNode = formalParamsNode.typeNodes.get(i);
            dcNode.idNode = formalParamsNode.idNodes.get(i);
            visit(dcNode);
        }
        isParamsVisited = false;
    }

    @Override
    public void visit(StructDefinitionNode node) {
        symbolTable.peek().put(node.typeNode.type, node);
        node.declarationNodes.forEach((d) -> visit(d));
    }

    @Override
    public void visit(FieldIdNode node) {
        node.structDefinitionNode = BindFieldXToDeclaration(node.idNodes);
        if (node.structDefinitionNode == null) {
            PrintNotDeclaredError("struct", node.idNodes.get(0).id, node);
        }
    }

    @Override
    public void visit(FieldValueNode node) {
        node.structDefinitionNode = BindFieldXToDeclaration(node.idNodes);
        if (node.structDefinitionNode == null) {
            PrintNotDeclaredError("struct", node.idNodes.get(0).id, node);
        }
    }


    private boolean isParamsVisited = false;
    private FormalParamsNode formalParamsNode = null;

    @Override
    public void visit(BlockNode node) {
        OpenScope();
        if (isParamsVisited) includeFormalParamsInScope();
        super.visit(node);
        CloseScope();
    }
}
