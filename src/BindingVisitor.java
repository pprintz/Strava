import CompilerError.UndefinedError;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BindingVisitor extends Visitor {
    private Stack<HashMap<String, ASTNode>> symbolTable;
    public static boolean hasBindingErrorOccured = false;
    public static HashMap<String, String> roboFunctions;


    //For properly handling functions private to a strategy
    private HashMap<String, HashMap<String, DefineFunctionNode>> stategyEnvironment;
    private boolean insideStrategy;
    private HashMap<String, DefineFunctionNode> functionEnvironment;


    public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions, HashMap<String, HashMap<String, DefineFunctionNode>> strategyEnvironment) {
        symbolTable = symbolTableWithFunctions;
        this.stategyEnvironment = strategyEnvironment;
        roboFunctions = new HashMap<>();
        AddFunctionTokens();
        TranslateRoboFunctionsToStrava();
    }

    /**
     * Adds a function specific to Strava to the symbol table so that TypeChecker doesn't complain.
     *
     * @param returnTypeString The function return type. Must be either "num", "text", or "bool".
     * @param functionId       The name of the function.
     * @param paramTypes       A list of parameter types as an array of String. Amount must match with amount of paramIds.
     * @param paramIds         A list of parameter IDs as an array of String. Amount must match with amount of paramTypes.
     */
    private void AddRoboFunctionToSymbolTable(String returnTypeString, String functionId, String[] paramTypes, String[] paramIds) {
        ArrayList<TypeNode> typeNodes = new ArrayList<>();
        ArrayList<IdNode> paramNodes = new ArrayList<>();


        if (paramTypes != null) {
            for (String paramType : paramTypes) {
                typeNodes.add(new TypeNode(paramType));
            }
        }
        if (paramIds != null) {
            for (String paramId : paramIds) {
                paramNodes.add(new IdNode(paramId));
            }
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

    private void TranslateRoboFunctionsToStrava() {
        roboFunctions.put("log", "System.out.println");
        roboFunctions.put("move", "ahead");
        roboFunctions.put("rotate", "turnRight");
        roboFunctions.put("rotateGun", "turnGunRight");
        roboFunctions.put("rotateRadar", "turnRadarRight");
    }

    /**
     * Adds all of Robocode's functions to symbol table in Strava's format (e.g. text instead of String)
     * Very nice and reliable and pretty code. I'm lovin' it!
     */
    private void AddFunctionTokens() {
        AddRoboFunctionToSymbolTable("void", "addCustomEvent", new String[]{"Condition"}, new String[]{"condition"});
        AddRoboFunctionToSymbolTable("void", "ahead", new String[]{"num"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "back", new String[]{"num"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "changeStrategy", new String[]{"text"}, new String[]{"newStrategy"});
        AddRoboFunctionToSymbolTable("void", "clearAllEvents", null, null);
        AddRoboFunctionToSymbolTable("void", "doNothing", null, null);
        AddRoboFunctionToSymbolTable("void", "execute", null, null);
        AddRoboFunctionToSymbolTable("void", "fire", new String[]{"num"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("num", "getBattleFieldHeight", null, null);
        AddRoboFunctionToSymbolTable("num", "getBattleFieldWidth", null, null);
        AddRoboFunctionToSymbolTable("num", "getDataQuotaAvailable", null, null);
        AddRoboFunctionToSymbolTable("num", "getDistanceRemaining", null, null);
        AddRoboFunctionToSymbolTable("num", "getEnergy", null, null);
        AddRoboFunctionToSymbolTable("num", "getEventPriority", new String[]{"text"}, new String[]{"eventClass"});
        AddRoboFunctionToSymbolTable("num", "getGunCoolingRate", null, null);
        AddRoboFunctionToSymbolTable("num", "getGunHeading", null, null);
        AddRoboFunctionToSymbolTable("num", "getGunHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getGunHeat", null, null);
        AddRoboFunctionToSymbolTable("num", "getGunTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("num", "getGunTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getHeading", null, null);
        AddRoboFunctionToSymbolTable("num", "getHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getHeight", null, null);
        AddRoboFunctionToSymbolTable("text", "getName", null, null);
        AddRoboFunctionToSymbolTable("num", "getNumRounds", null, null);
        AddRoboFunctionToSymbolTable("num", "getNumSentries", null, null);
        AddRoboFunctionToSymbolTable("num", "getOthers", null, null);
        AddRoboFunctionToSymbolTable("num", "getRadarHeading", null, null);
        AddRoboFunctionToSymbolTable("num", "getRadarHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getRadarTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("num", "getRadarTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getRoundNum", null, null);
        AddRoboFunctionToSymbolTable("num", "getSentryBorderSize", null, null);
        AddRoboFunctionToSymbolTable("num", "getTime", null, null);
        AddRoboFunctionToSymbolTable("num", "getTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("num", "getTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("num", "getVelocity", null, null);
        AddRoboFunctionToSymbolTable("num", "getWidth", null, null);
        AddRoboFunctionToSymbolTable("num", "getX", null, null);
        AddRoboFunctionToSymbolTable("num", "getY", null, null);
        AddRoboFunctionToSymbolTable("bool", "isAdjustGunForRobotTurn", null, null);
        AddRoboFunctionToSymbolTable("bool", "isAdjustRadarForGunTurn", null, null);
        AddRoboFunctionToSymbolTable("bool", "isAdjustRadarForRobotTurn", null, null);
        AddRoboFunctionToSymbolTable("void", "log", new String[]{"text"}, new String[]{"input"});
        AddRoboFunctionToSymbolTable("void", "move", new String[]{"num"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "onBattleEnded", new String[]{"BattleEndedEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletHit", new String[]{"BulletHitEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletHitBullet", new String[]{"BulletHitBulletEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletMissed", new String[]{"BulletMissedEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onCustomEvent", new String[]{"CustomEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onDeath", new String[]{"DeathEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onHitByBullet", new String[]{"HitByBulletEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onHitRobot", new String[]{"HitRobotEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onHitWall", new String[]{"HitWallEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onKeyPressed", new String[]{"KeyEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onKeyReleased", new String[]{"KeyEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onKeyTyped", new String[]{"KeyEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseClicked", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseDragged", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseEntered", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseExited", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseMoved", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMousePressed", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseReleased", new String[]{"MouseEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onMouseWheelMoved", new String[]{"MouseWheelEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onPaint", new String[]{"Graphics2D"}, new String[]{"g"});
        AddRoboFunctionToSymbolTable("void", "onRobotDeath", new String[]{"RobotDeathEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onRoundEnded", new String[]{"RoundEndedEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onScannedRobot", new String[]{"ScannedRobotEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onSkippedTurn", new String[]{"SkippedTurnEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onStatus", new String[]{"StatusEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onWin", new String[]{"WinEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "removeCustomEvent", new String[]{"Condition"}, new String[]{"condition"});
        AddRoboFunctionToSymbolTable("void", "resume", null, null);
        AddRoboFunctionToSymbolTable("void", "rotate", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "run", null, null);
        AddRoboFunctionToSymbolTable("void", "scan", null, null);
        AddRoboFunctionToSymbolTable("void", "setAdjustGunForRobotTurn", new String[]{"bool"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAdjustRadarForGunTurn", new String[]{"bool"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAdjustRadarForRobotTurn", new String[]{"bool"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAhead", new String[]{"num"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "setAllColors", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setBack", new String[]{"num"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "setBodyColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setBulletColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setColors", new String[]{"Color", "Color", "Color", "Color", "Color"}, new String[]{"bodyColor", "gunColor", "radarColor", "bulletColor", "scanArcColor"});
        AddRoboFunctionToSymbolTable("void", "setDebugProperty", new String[]{"text", "text"}, new String[]{"key", "value"});
        AddRoboFunctionToSymbolTable("void", "setEventPriority", new String[]{"text"}, new String[]{"eventClass"});
        AddRoboFunctionToSymbolTable("void", "setFire", new String[]{"num"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("void", "setGunColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setInterruptible", new String[]{"bool"}, new String[]{"interruptible"});
        AddRoboFunctionToSymbolTable("void", "setMaxTurnRate", new String[]{"num"}, new String[]{"newMaxTurnRate"});
        AddRoboFunctionToSymbolTable("void", "setMaxVelocity", new String[]{"num"}, new String[]{"newMaxVelocity"});
        AddRoboFunctionToSymbolTable("void", "setRadarColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setResume", null, null);
        AddRoboFunctionToSymbolTable("void", "setScanColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setStop", null, null);
        AddRoboFunctionToSymbolTable("void", "setStop", new String[]{"bool"}, new String[]{"overwrite"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "stop", null, null);
        AddRoboFunctionToSymbolTable("void", "turnGunLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnGunLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnGunRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnGunRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRadarLeft", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRadarLeftRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRadarRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRadarRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRight", new String[]{"num"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRightRadians", new String[]{"num"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "waitFor", new String[]{"Condition"}, new String[]{"condition"});
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

    private DefineFunctionNode BindFunctionCallToDeclaration(ASTNode node, String idName
    ) {
        DefineFunctionNode defineFunctionNode = null;
        boolean isDeclared = false;
        if (roboFunctions.containsKey(idName)) {
            isDeclared = true;
        }
        if(insideStrategy) {
            if (functionEnvironment.containsKey(idName)) {
                defineFunctionNode = functionEnvironment.get(idName);
                isDeclared = true;
            } else if (stategyEnvironment.get("default").containsKey(idName)) {
                defineFunctionNode = stategyEnvironment.get("default").get(idName);
                isDeclared = true;
            }
        }
        else if(symbolTable.get(0).containsKey(idName)){
            defineFunctionNode = (DefineFunctionNode)symbolTable.get(0).get(idName);
            isDeclared = true;
        }

        if (!isDeclared) {
            hasBindingErrorOccured = true;
            String funcName = "";
            if (node instanceof FunctionCallNode) {
                funcName = ((FunctionCallNode) node).idNode.id;
            } else if (node instanceof ExprFunctionCallNode) {
                funcName = ((ExprFunctionCallNode) node).idNode.id;
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

    private String getActualStructLitteralSignature(List<AssignmentNode> assignmentNodes) {
        int length = assignmentNodes.size();
        String stringRep = "[";
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                stringRep += assignmentNodes.get(i).idNode.id + " := expression]";
            } else {
                stringRep += assignmentNodes.get(i).idNode.id + " := expression, ";
            }
        }
        return stringRep;
    }

    private String getExpectedStructLitteralSignature(List<DeclarationNode> declarationNodes) {
        int lenght = declarationNodes.size();
        String stringRep = "[";
        for (int i = 0; i < lenght; i++) {
            if (i == lenght - 1) {
                stringRep += declarationNodes.get(i).idNode.id + " := expression]";
            } else {
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
    public void visit(StrategyNode node) {
        insideStrategy = true;
        functionEnvironment = stategyEnvironment.get(node.idNode.id);
        super.visit(node);
        insideStrategy = false;
    }

    @Override
    public void visit(DefaultStrategyNode node) {
        insideStrategy = true;
        functionEnvironment = stategyEnvironment.get("default");
        super.visit(node);
        insideStrategy = false;
    }

    @Override
    public void visit(FunctionCallNode node) {
        node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id);
        if (node.actualParams != null) {
            visit(node.actualParams);
        }
    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id);
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
