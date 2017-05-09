import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BindingVisitor extends Visitor {
    private Stack<HashMap<String, ASTNode>> symbolTable;
	public static boolean hasBindingErrorOccured = false;
    public static HashMap<String, String> roboFunctions;

	public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions) {
        symbolTable = symbolTableWithFunctions;
        roboFunctions = new HashMap<>();
        AddRoboFunctionsToHashMap();
    }

    private void OpenScope() {
        symbolTable.push(new HashMap<>());
    }

    private void CloseScope() {
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


    private DefineFunctionNode BindFunctionCallToDeclaration(ASTNode node, String idName, ActualParamsNode actualParams){
        DefineFunctionNode defineFunctionNode = null;
        boolean isDeclared = false;
        if (roboFunctions.containsKey(idName)) {
            isDeclared = true;
        }
		for (int i = symbolTable.size() - 1; i >= 0; i--) {
			if (symbolTable.get(i).containsKey(idName)) {
				defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(idName);
				isDeclared = true;
			}
		}
		if (!isDeclared) {
			hasBindingErrorOccured = true;
			PrintNotDeclaredError(" function", idName, node);
		}
		return defineFunctionNode;
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
