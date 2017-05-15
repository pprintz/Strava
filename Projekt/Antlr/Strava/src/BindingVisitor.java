import java.util.*;
import CompilerError.*;

public class BindingVisitor extends Visitor {
    private Stack<HashMap<String, ASTNode>> symbolTable;
	public static boolean hasBindingErrorOccured = false;
    public static HashMap<String, String> roboFunctions;

	public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions) {
		symbolTable = symbolTableWithFunctions;
		roboFunctions = new HashMap<>();
		AddRoboFunctionToSymbolTable("void", "log", new String[]{"text"}, new String[]{"message"});
        AddRoboFunctionsToHashMap();
    }

    private void OpenScope() {

        symbolTable.push(new HashMap<>());
    }

    private void CloseScope() {
        symbolTable.pop();
    }

    /**
     * Adds a function specific to Strava to the symbol table so that TypeChecker doesn't complain.
     * @param returnTypeString The function return type. Must be either "num", "text", or "bool".
     * @param functionId The name of the function.
     * @param paramTypes A list of parameter types as an array of String. Amount must match with amount of paramIds.
     * @param paramIds A list of parameter IDs as an array of String. Amount must match with amount of paramTypes.
     */
    private void AddRoboFunctionToSymbolTable(String returnTypeString, String functionId, String[] paramTypes, String[] paramIds) {
	    ArrayList<TypeNode> typeNodes = new ArrayList<>();
	    ArrayList<IdNode> paramNodes = new ArrayList<>();

	    switch (returnTypeString) {
            case "void": case "num": case "text": case "bool":
                break;  // TODO: Add struct allowance
            default:
                throw new IllegalArgumentException("Only types of void, num, text, bool are allowed.");
        }

	    for (String paramType : paramTypes) {
            typeNodes.add(new TypeNode(paramType));
        }
        for (String paramId : paramIds) {
	        paramNodes.add(new IdNode(paramId));
        }
        if (typeNodes.size() != paramNodes.size()) {
	        throw new IllegalArgumentException("Mismatch between number of parameter types and parameter IDs in function definition.");
        }

        DefineFunctionNode defFuncNode = new DefineFunctionNode(
            new TypeNode(returnTypeString),
            new IdNode(functionId),
            new FormalParamsNode(typeNodes, paramNodes)
        );

        symbolTable.peek().put(functionId, defFuncNode);
    }

	private void AddRoboFunctionsToHashMap() {
		roboFunctions.put("ahead", "ahead"); // double -> void
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
            if (symbolTable.get(i).containsKey(idNode.id)) {
                idNode.declarationNode = (DeclarationNode) symbolTable.get(i).get(idNode.id);
                isDeclared = true;
            }
        }
        if (!isDeclared) {
            hasBindingErrorOccured = true;
            Main.CompileErrors.add(new UndefinedError(idNode.columnNumber, idNode.lineNumber, idNode.id));
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
			String funcName = "";
			if(node instanceof FunctionCallNode) {
                funcName = ((FunctionCallNode) node).idNode.id;
            }else if(node instanceof ExprFunctionCallNode){
			    funcName = ((ExprFunctionCallNode)node).idNode.id;
            }
            Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, funcName));
		}
		return defineFunctionNode;
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
            Main.CompileErrors.add(new CompilerError.UndefinedError(structInitializationNode.columnNumber,
                structInitializationNode.lineNumber,
                structInitializationNode.typeNode.type));
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
        boolean structLiteralErrorOccured = false;
        for (AssignmentNode assignmentNode : structInitializationNode.assignments) {
            DeclBoolTuple tuple = oneToOneDeclAssMap.get(assignmentNode.idNode.id);
            if (tuple != null && !tuple.isBound) {
                assignmentNode.idNode.declarationNode = tuple.declarationNode;
                tuple.isBound = true;
                visit(assignmentNode.exprNode);
            } else if (tuple != null) {
                Main.CompileErrors.add(new CompilerError.DuplicateFieldAssignmentInStructLitteralError(assignmentNode.columnNumber, assignmentNode.lineNumber, assignmentNode.idNode.id));
                break;
            } else {
                structLiteralErrorOccured = true;
                Main.CompileErrors.add(new CompilerError.InvalidStructLitteralError(structInitializationNode.columnNumber,
                    structInitializationNode.lineNumber, getExpectedStructLitteralSignature(structInitializationNode.structDefinitionNode.declarationNodes),
                    getActualStructLitteralSignature(structInitializationNode.assignments)));
                break;
            }
        }

        for (DeclBoolTuple tuple : oneToOneDeclAssMap.values()) {
            if (!tuple.isBound && !structLiteralErrorOccured) {
                Main.CompileErrors.add(new CompilerError.InvalidStructLitteralError(structInitializationNode.columnNumber,
                    structInitializationNode.lineNumber, getExpectedStructLitteralSignature(structInitializationNode.structDefinitionNode.declarationNodes),
                    getActualStructLitteralSignature(structInitializationNode.assignments)));
            }
        }
    }
    private String getActualStructLitteralSignature(List<AssignmentNode> assignmentNodes){
        int lenght = assignmentNodes.size();
        String stringRep = "[";
        for(int i = 0; i < lenght; i++){
            if(i == lenght-1) {
                stringRep += assignmentNodes.get(i).idNode.id + " := expression]";
            }
            else {
                stringRep += assignmentNodes.get(i).idNode.id + " := expression, ";
            }
        }
        return stringRep;
    }

    private String getExpectedStructLitteralSignature(List<DeclarationNode> declarationNodes){
        int lenght = declarationNodes.size();
        String stringRep = "[";
        for(int i = 0; i < lenght; i++){
            if(i == lenght-1) {
                stringRep += declarationNodes.get(i).idNode.id + " := expression]";
            }
            else {
                stringRep += declarationNodes.get(i).idNode.id + " := expression, ";
            }
        }
        return stringRep;
    }
    private void BindInstantiatedStructToDef(DeclarationNode node) {
        boolean isStructDefined = false;
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            if (symbolTable.get(i).containsKey(node.typeNode.type)) {
                node.structDefinitionNode = (StructDefinitionNode) symbolTable.get(i).get(node.typeNode.type);
                isStructDefined = true;
            }
        }
        if (!isStructDefined) {
            Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, node.typeNode.type));
        }
    }

    @Override
    public void visit(FunctionCallNode node) {
        node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id, node.actualParams);
        if(node.actualParams != null) {
            visit(node.actualParams);
        }
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
                    BindInstantiatedStructToDef(node);
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
                    Main.CompileErrors.add(new CompilerError.RedeclarationError(node.columnNumber, node.lineNumber, node.idNode.id));
					return true;
				} else {
					if (i == symbolTable.size() - 1) {
					    Main.CompileErrors.add(new CompilerError.RedeclarationError(node.columnNumber, node.lineNumber, node.idNode.id));
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
            Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, node.idNodes.get(0).id));
        }
    }

    @Override
    public void visit(FieldValueNode node) {
        node.structDefinitionNode = BindFieldXToDeclaration(node.idNodes);
        if (node.structDefinitionNode == null) {
            Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, node.idNodes.get(0).id));
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
