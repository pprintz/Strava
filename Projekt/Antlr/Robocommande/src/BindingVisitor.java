import java.util.HashMap;
import java.util.Stack;

public class BindingVisitor extends Visitor {
    public static HashMap<String, String> roboFunctions;

    public static boolean hasFunctionsBeenDeclared = false;
    Stack<HashMap<IdNode, ASTNode>> symbolTable;

    public BindingVisitor() {
        symbolTable = new Stack<>();
        symbolTable.push(new HashMap<>());
        roboFunctions = new HashMap<>();
        AddRoboFunctionsToHashMap();
    }
    private void OpenScope(){
        symbolTable.push(new HashMap<>());
    }
    private void CloseScope(){
        symbolTable.pop();
    }

    private void AddRoboFunctionsToHashMap() {
        roboFunctions.put("ahead", "ahead"); // void -> void
        roboFunctions.put("back", "back"); // double -> void
        roboFunctions.put("changeStrategy", "changeStrategy"); // String
        roboFunctions.put("doNothing", "doNothing"); // void -> void
        roboFunctions.put("fire", "fireBullet"); // double -> Bullet
        roboFunctions.put("getBattleFieldHeight", "getBattleFieldHeight"); // void -> double
        roboFunctions.put("getBattleFieldWidth", "getBattleFieldWidth"); // void -> double
        roboFunctions.put("getEnergy", "getEnergy"); // void -> double
        roboFunctions.put("getGunCoolingRate", "getGunCoolingRate"); // void -> double
        roboFunctions.put("getGunHeading", "getGunHeading"); // void -> double
        roboFunctions.put("getGunHeat", "getGunHeat"); // void -> double
        roboFunctions.put("getHeading", "getHeading"); // void -> double
        roboFunctions.put("getName", "getName"); // void -> String
        roboFunctions.put("getNumRounds", "getNumRounds"); // void -> int
        roboFunctions.put("getOthers", "getOthers"); // void -> int
        roboFunctions.put("getRadarHeading", "getRadarHeading"); // void -> double
        roboFunctions.put("getRoundNum", "getRoundNum"); // void -> int
        roboFunctions.put("getTime", "getTime"); // void -> long
        roboFunctions.put("getVelocity", "getVelocity"); // void -> double
        roboFunctions.put("getX", "getX"); // void -> double
        roboFunctions.put("getY", "getY"); // void -> double
        roboFunctions.put("log", "System.out.println"); // String --
        roboFunctions.put("resume", "resume"); // void -> void
        roboFunctions.put("rotate", "turnGunRight"); // double -> void
        roboFunctions.put("scan", "scan"); // void -> void
        roboFunctions.put("setAdjustGunForRobotTurn", "setAdjustGunForRobotTurn"); // bool -> void
        roboFunctions.put("setAdjustRadarForGunTurn", "setAdjustRadarForGunTurn"); // bool -> void
        roboFunctions.put("setAdjustRadarForRobotTurn", "setAdjustRadarForRobotTurn"); // bool -> void
        roboFunctions.put("setAllColors", "setAllColors"); // Color -> void
        roboFunctions.put("setBodyColor", "setBodyColor"); // Color -> void
        roboFunctions.put("setBulletColor", "setBulletColor"); // Color -> void
        roboFunctions.put("setColors", "setColors"); // Color, Color, Color, Color, Color -> void
        roboFunctions.put("setGunColor", "setGunColor"); // Color -> void
        roboFunctions.put("setRadarColor", "setRadarColor"); // Color -> void
        roboFunctions.put("setScanColor", "setScanColor"); // Color -> void
        roboFunctions.put("stop", "stop"); // void -> void
        roboFunctions.put("turnGunLeft", "turnGunLeft"); // double -> void
        roboFunctions.put("turnGunRight", "turnGunRight"); // double -> void
        roboFunctions.put("turnLeft", "turnLeft"); // double -> void
        roboFunctions.put("turnRadarLeft", "turnRadarLeft"); // double -> void
        roboFunctions.put("turnRadarRight", "turnRadarRight"); // double -> void
        roboFunctions.put("turnRight", "turnRight"); // double -> void
    }
    private void BindIdToDeclaration(IdNode idNode) {
        boolean isDeclared = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(idNode)) {
                idNode.declarationNode = (DeclarationNode)symbolTable.get(i).get(idNode);
                isDeclared = true;
            }
        }
        if(!isDeclared){
            hasBindingErrorOccured = true;
            PrintNotDeclaredError("id", idNode.id, idNode);
        }
    }

    private void BindFieldIdToDeclaration(FieldIdNode fieldIdNode) {
        boolean isDeclared = false;
        IdNode structId = fieldIdNode.idNodes.get(0);
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if(symbolTable.get(i).containsKey(structId)){
                ASTNode astNode = symbolTable.get(i).get(structId);
                DeclarationNode declarationNode = (DeclarationNode) astNode;
                if(declarationNode.structDefinitionNode != null) {
                    fieldIdNode.structDefinitionNode = declarationNode.structDefinitionNode;
                    isDeclared = true;
                }
            }
        }
        if(!isDeclared){
            PrintNotDeclaredError("struct", structId.id, fieldIdNode);
        }
    }

    static boolean hasBindingErrorOccured = false;
    private void BindFunctionCallToDeclaration(FunctionCallNode fCallNode) {
        boolean isDeclared = false;
        if (roboFunctions.containsKey(fCallNode.idNode.id)) {
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
            if (symbolTable.get(i).containsKey(fCallNode.idNode)) {
                fCallNode.defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(fCallNode.idNode);
                isDeclared = true;
            }
        }
        if (!isDeclared) {
            hasBindingErrorOccured = true;
            PrintNotDeclaredError(" function ", fCallNode.idNode.id, fCallNode);
        }
    }
    private void PrintNotDeclaredError(String type, String id, ASTNode node){
        System.out.println("There is no " + type + " named: " + id + node.toString());
    }

    private void BindStructInitializationToDefinition(StructInitializationNode structInitializationNode) {
        boolean isStructDefined = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(structInitializationNode.idNode)) {
                structInitializationNode.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(structInitializationNode.idNode);
                isStructDefined = true;
                if(!getStructInitValidity(structInitializationNode)){
                    System.out.println("Struct initialization does not match struct field declaration");
                }
            }
        }
        if (!isStructDefined) {
            //PrintNotDeclaredError("struct", structInitializationNode.structDefinitionNode.structIdNode.id);
            PrintNotDeclaredError("struct", structInitializationNode.idNode.id, structInitializationNode);
        }
    }

    private boolean getStructInitValidity(StructInitializationNode structInitializationNode) {
        boolean doesInitMatchFields = false;
        for(AssignmentNode assignmentNode : structInitializationNode.assignments){
            boolean doesAssigmentMatchFieldDecl = false;
            for(DeclarationNode dclNode : structInitializationNode.structDefinitionNode.declarationNodes){
                doesAssigmentMatchFieldDecl = false;
                if(assignmentNode.idNode.equals(dclNode.idNode)){
                    doesAssigmentMatchFieldDecl = true;
                    break;
                }
            }
            if(doesAssigmentMatchFieldDecl) doesInitMatchFields = true; else{
                doesInitMatchFields = false;
                System.out.print("There is no field with name : " + assignmentNode.idNode);
            }
        }
        return doesInitMatchFields;
    }

    private void BindStructDeclarationToDefinition(DeclarationNode node) {
        boolean isStructDefined = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(new IdNode(node.typeNode.type))) {
                node.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(new IdNode(node.typeNode.type));
                isStructDefined = true;
            }
        }
        if (!isStructDefined) {
            PrintNotDeclaredError("struct", node.typeNode.type, node);
        }
    }

    @Override
    public void visit(FunctionCallNode node) {
        if(hasFunctionsBeenDeclared) {
            BindFunctionCallToDeclaration(node);
        }
    }
    @Override
    public void visit(ExprFunctionCallNode node){
        if(hasFunctionsBeenDeclared) {
            BindExprFunctionCallToDeclaration(node);
        }
    }
    @Override
    public void visit(IdNode node) {
        if(!node.isDeclaration)
            BindIdToDeclaration(node);
    }
    @Override
    public void visit(StructInitializationNode node) {
        if(!hasFunctionsBeenDeclared) {
            BindStructInitializationToDefinition(node);
        }
    }

    @Override
    public void visit(DeclarationNode node) {
        if(!hasFunctionsBeenDeclared) {
            if (!doesDeclExistLocally(node)) {
                switch (node.typeNode.type) {
                    case "num":
                    case "text":
                    case "bool":
                        symbolTable.peek().put(node.idNode, node);
                        break;
                    default:
                        BindStructDeclarationToDefinition(node);
                        symbolTable.peek().put(node.idNode, node);
                }
            } else hasBindingErrorOccured = true;
        }
    }

    private boolean doesDeclExistLocally(DeclarationNode node){
        for(int i = symbolTable.size()-1; i >= 0; i--){
            if(symbolTable.get(i).containsKey(node.idNode)){
                DeclarationNode declNodeFound = (DeclarationNode)symbolTable.get(i).get(node.idNode);
                if(!declNodeFound.IsGlobal) {
                    System.out.println("Already declared variable with name: " + node.idNode.id + " LINE" + declNodeFound.lineNumber);
                    return true;
                }
                else{
                    if(i == symbolTable.size() -1) {
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
        if(!hasFunctionsBeenDeclared) {
            symbolTable.peek().put(node.idNode, node);
            if(node.formalParamsNode != null) {
                isParamsVisisted = true;
                formalParamsNode = node.formalParamsNode;
            }
            visit(node.blockNode);
        }
    }
     private void includeFormalParamsInScope() {
        for(int i = 0 ; i < formalParamsNode.idNodes.size(); i++){
            DeclarationNode dcNode = new DeclarationNode();
            dcNode.typeNode = formalParamsNode.typeNodes.get(i);
            dcNode.idNode = formalParamsNode.idNodes.get(i);
            visit(dcNode);
        }
        isParamsVisisted = false;
    }
    @Override
    public void visit(StructDefinitionNode node) {
        if(!hasFunctionsBeenDeclared) {
            symbolTable.peek().put(node.structIdNode, node);
        }
    }

    @Override
    public void visit(FieldIdNode node) {
        if(!hasFunctionsBeenDeclared) {
            BindFieldIdToDeclaration(node);
        }
    }

    private boolean isParamsVisisted = false;
    private FormalParamsNode formalParamsNode = null;

    @Override
    public void visit(TypeNode node) {
    }

    @Override
    public void visit(BlockNode node) {
        OpenScope();
        if(isParamsVisisted) includeFormalParamsInScope();
        super.visit(node);
        CloseScope();
    }
}
