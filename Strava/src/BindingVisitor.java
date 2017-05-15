import java.util.*;
import CompilerError.*;

public class BindingVisitor extends Visitor {
    private Stack<HashMap<String, ASTNode>> symbolTable;
    public static boolean hasBindingErrorOccured = false;
    public static HashMap<String, String> roboFunctions;
    private List<String> paramTypes;
    private List<String> paramIds;

    public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions) {
        symbolTable = symbolTableWithFunctions;
        roboFunctions = new HashMap<>();
        paramTypes = new ArrayList<>();
        paramIds = new ArrayList<>();
        AddFunctionTokens();
    }

    /**
     * Adds a function specific to Strava to the symbol table so that TypeChecker doesn't complain.
     * @param returnTypeString The function return type. Must be either "num", "text", or "bool".
     * @param functionId The name of the function.
     * @param paramTypes A list of parameter types as an array of String. Amount must match with amount of paramIds.
     * @param paramIds A list of parameter IDs as an array of String. Amount must match with amount of paramTypes.
     */
    private void AddRoboFunctionToSymbolTable(String returnTypeString, String functionId, String[] paramTypes, String[]paramIds) {
        ArrayList<TypeNode> typeNodes = new ArrayList<>();
        ArrayList<IdNode> paramNodes = new ArrayList<>();

//	    switch (returnTypeString) {
//            case "void": case "num": case "text": case "bool":
//                break;  // TODO: Add struct allowance
//            default:
//                throw new IllegalArgumentException("Only types of void, num, text, bool are allowed.");
//        }


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

    /**
     * Adds all of Robocode's functions to symbol table.
     * Very nice and reliable and pretty code. I'm lovin' it!
     */
    private void AddFunctionTokens() {
        AddRoboFunctionToSymbolTable("void", "ahead", new String[]{"double"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "back", new String[]{"double"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "doNothing", null, null);
        AddRoboFunctionToSymbolTable("void", "fire", new String[]{"double"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("Bullet", "fireBullet", new String[]{"double"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("IBasicEvents", "getBasicEventListener", null, null);
        AddRoboFunctionToSymbolTable("double", "getBattleFieldHeight", null, null);
        AddRoboFunctionToSymbolTable("double", "getBattleFieldWidth", null, null);
        AddRoboFunctionToSymbolTable("double", "getEnergy", null, null);
        AddRoboFunctionToSymbolTable("Graphics2D", "getGraphics", null, null);
        AddRoboFunctionToSymbolTable("double", "getGunCoolingRate", null, null);
        AddRoboFunctionToSymbolTable("double", "getGunHeading", null, null);
        AddRoboFunctionToSymbolTable("double", "getGunHeat", null, null);
        AddRoboFunctionToSymbolTable("double", "getHeading", null, null);
        AddRoboFunctionToSymbolTable("double", "getHeight", null, null);
        AddRoboFunctionToSymbolTable("IInteractiveEvents", "getInteractiveEventListener", null, null);
        AddRoboFunctionToSymbolTable("String", "getName", null, null);
        AddRoboFunctionToSymbolTable("int", "getNumRounds", null, null);
        AddRoboFunctionToSymbolTable("int", "getNumSentries", null, null);
        AddRoboFunctionToSymbolTable("int", "getOthers", null, null);
        AddRoboFunctionToSymbolTable("IPaintEvents", "getPaintEventListener", null, null);
        AddRoboFunctionToSymbolTable("double", "getRadarHeading", null, null);
        AddRoboFunctionToSymbolTable("Runnable", "getRobotRunnable", null, null);
        AddRoboFunctionToSymbolTable("int", "getRoundNum", null, null);
        AddRoboFunctionToSymbolTable("int", "getSentryBorderSize", null, null);
        AddRoboFunctionToSymbolTable("long", "getTime", null, null);
        AddRoboFunctionToSymbolTable("double", "getVelocity", null, null);
        AddRoboFunctionToSymbolTable("double", "getWidth", null, null);
        AddRoboFunctionToSymbolTable("double", "getX", null, null);
        AddRoboFunctionToSymbolTable("double", "getY", null, null);
        AddRoboFunctionToSymbolTable("void", "onBattleEnded", new String[]{"BattleEndedEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletHit", new String[]{"BulletHitEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletHitBullet", new String[]{"BulletHitBulletEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onBulletMissed", new String[]{"BulletMissedEvent"}, new String[]{"event"});
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
        AddRoboFunctionToSymbolTable("void", "onStatus", new String[]{"StatusEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onWin", new String[]{"WinEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "resume", null, null);
        AddRoboFunctionToSymbolTable("void", "run", null, null);
        AddRoboFunctionToSymbolTable("void", "scan", null, null);
        AddRoboFunctionToSymbolTable("void", "setAdjustGunForRobotTurn", new String[]{"boolean"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAdjustRadarForGunTurn", new String[]{"boolean"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAdjustRadarForRobotTurn", new String[]{"boolean"}, new String[]{"independent"});
        AddRoboFunctionToSymbolTable("void", "setAllColors", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setBodyColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setBulletColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setColors", new String[]{"Color", "Color", "Color"}, new String[]{"bodyColor", "gunColor", "radarColor"});
        AddRoboFunctionToSymbolTable("void", "setColors", new String[]{"Color", "Color", "Color", "Color", "Color"}, new String[]{"bodyColor", "gunColor", "radarColor", "bulletColor", "scanArcColor"});
        AddRoboFunctionToSymbolTable("void", "setDebugProperty", new String[]{"String", "String"}, new String[]{"key", "value"});
        AddRoboFunctionToSymbolTable("void", "setGunColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setRadarColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "setScanColor", new String[]{"Color"}, new String[]{"color"});
        AddRoboFunctionToSymbolTable("void", "stop", null, null);
        AddRoboFunctionToSymbolTable("void", "stop", new String[]{"boolean"}, new String[]{"overwrite"});
        AddRoboFunctionToSymbolTable("void", "turnGunLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnGunRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRadarLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRadarRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "turnRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("double", "getDistanceRemaining", null, null);
        AddRoboFunctionToSymbolTable("double", "getTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("double", "getGunTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("double", "getRadarTurnRemaining", null, null);
        AddRoboFunctionToSymbolTable("void", "setAhead", new String[]{"double"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "setBack", new String[]{"double"}, new String[]{"distance"});
        AddRoboFunctionToSymbolTable("void", "setTurnLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setFire", new String[]{"double"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("Bullet", "setFireBullet", new String[]{"double"}, new String[]{"power"});
        AddRoboFunctionToSymbolTable("void", "addCustomEvent", new String[]{"Condition"}, new String[]{"condition"});
        AddRoboFunctionToSymbolTable("void", "removeCustomEvent", new String[]{"Condition"}, new String[]{"condition"});
        AddRoboFunctionToSymbolTable("void", "clearAllEvents", null, null);
        AddRoboFunctionToSymbolTable("void", "execute", null, null);
        AddRoboFunctionToSymbolTable("Vector<Event>", "getAllEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<BulletHitBulletEvent>", "getBulletHitBulletEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<BulletHitEvent>", "getBulletHitEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<BulletMissedEvent>", "getBulletMissedEvents", null, null);
        AddRoboFunctionToSymbolTable("File", "getDataDirectory", null, null);
        AddRoboFunctionToSymbolTable("File", "getDataFile", new String[]{"String"}, new String[]{"filename"});
        AddRoboFunctionToSymbolTable("long", "getDataQuotaAvailable", null, null);
        AddRoboFunctionToSymbolTable("int", "getEventPriority", new String[]{"String"}, new String[]{"eventClass"});
        AddRoboFunctionToSymbolTable("Vector<HitByBulletEvent>", "getHitByBulletEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<HitRobotEvent>", "getHitRobotEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<HitWallEvent>", "getHitWallEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<RobotDeathEvent>", "getRobotDeathEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<ScannedRobotEvent>", "getScannedRobotEvents", null, null);
        AddRoboFunctionToSymbolTable("Vector<StatusEvent>", "getStatusEvents", null, null);
        AddRoboFunctionToSymbolTable("boolean", "isAdjustGunForRobotTurn", null, null);
        AddRoboFunctionToSymbolTable("boolean", "isAdjustRadarForRobotTurn", null, null);
        AddRoboFunctionToSymbolTable("boolean", "isAdjustRadarForGunTurn", null, null);
        AddRoboFunctionToSymbolTable("void", "onCustomEvent", new String[]{"CustomEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "setEventPriority", new String[]{"String"}, new String[]{"eventClass"});
        AddRoboFunctionToSymbolTable("void", "setInterruptible", new String[]{"boolean"}, new String[]{"interruptible"});
        AddRoboFunctionToSymbolTable("void", "onScannedRobot", new String[]{"ScannedRobotEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "setMaxTurnRate", new String[]{"double"}, new String[]{"newMaxTurnRate"});
        AddRoboFunctionToSymbolTable("void", "setMaxVelocity", new String[]{"double"}, new String[]{"newMaxVelocity"});
        AddRoboFunctionToSymbolTable("void", "setResume", null, null);
        AddRoboFunctionToSymbolTable("void", "setStop", null, null);
        AddRoboFunctionToSymbolTable("void", "setStop", new String[]{"boolean"}, new String[]{"overwrite"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarLeft", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarRight", new String[]{"double"}, new String[]{"degrees"});
        AddRoboFunctionToSymbolTable("void", "waitFor", new String[]{"Condition"}, new String[]{"condition"});
        AddRoboFunctionToSymbolTable("void", "onDeath", new String[]{"DeathEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("void", "onSkippedTurn", new String[]{"SkippedTurnEvent"}, new String[]{"event"});
        AddRoboFunctionToSymbolTable("double", "getHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("void", "setTurnLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("double", "getGunHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("double", "getRadarHeadingRadians", null, null);
        AddRoboFunctionToSymbolTable("void", "setTurnGunLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnGunRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "setTurnRadarRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnGunLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnGunRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRadarLeftRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("void", "turnRadarRightRadians", new String[]{"double"}, new String[]{"radians"});
        AddRoboFunctionToSymbolTable("double", "getGunTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("double", "getRadarTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("double", "getTurnRemainingRadians", null, null);
        AddRoboFunctionToSymbolTable("IAdvancedEvents", "getAdvancedEventListener", null, null);
    }

        private void OpenScope() {
            symbolTable.push(new HashMap<>());
        }

        private void CloseScope() {
            symbolTable.pop();
        }



        private void BindIdToDeclaration (IdNode idNode){
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

        private StructDefinitionNode BindFieldXToDeclaration (List < IdNode > idNodes) {
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

        private DefineFunctionNode BindFunctionCallToDeclaration (ASTNode node, String idName, ActualParamsNode
        actualParams){
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
                if (node instanceof FunctionCallNode) {
                    funcName = ((FunctionCallNode) node).idNode.id;
                } else if (node instanceof ExprFunctionCallNode) {
                    funcName = ((ExprFunctionCallNode) node).idNode.id;
                }
                Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, funcName));
            }
            return defineFunctionNode;
        }

        private void BindStructInitializationToDefinition (StructInitializationNode structInitializationNode){
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

        private void checkStruckInitValidity (StructInitializationNode structInitializationNode){
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
        private String getActualStructLitteralSignature (List < AssignmentNode > assignmentNodes) {
            int lenght = assignmentNodes.size();
            String stringRep = "[";
            for (int i = 0; i < lenght; i++) {
                if (i == lenght - 1) {
                    stringRep += assignmentNodes.get(i).idNode.id + " := expression]";
                } else {
                    stringRep += assignmentNodes.get(i).idNode.id + " := expression, ";
                }
            }
            return stringRep;
        }

        private String getExpectedStructLitteralSignature (List < DeclarationNode > declarationNodes) {
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
        private void BindInstantiatedStructToDef (DeclarationNode node){
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
        public void visit (FunctionCallNode node){
            node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id, node.actualParams);
            if (node.actualParams != null) {
                visit(node.actualParams);
            }
        }

        @Override
        public void visit (ExprFunctionCallNode node){
            node.defineFunctionNode = BindFunctionCallToDeclaration(node, node.idNode.id, node.actualParams);
        }

        @Override
        public void visit (IdNode node){
            if (!node.isDeclaration)
                BindIdToDeclaration(node);
        }

        @Override
        public void visit (StructInitializationNode node){

            BindStructInitializationToDefinition(node);

        }

        @Override
        public void visit (DeclarationNode node){
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
        private boolean doesDeclExistLocally (DeclarationNode node){
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
        public void visit (DefineFunctionNode node){
            if (node.formalParamsNode != null) {
                isParamsVisited = true;
                formalParamsNode = node.formalParamsNode;
            }
            visit(node.blockNode);
        }

        private void includeFormalParamsInScope () {
            for (int i = 0; i < formalParamsNode.idNodes.size(); i++) {
                DeclarationNode dcNode = new DeclarationNode();
                dcNode.typeNode = formalParamsNode.typeNodes.get(i);
                dcNode.idNode = formalParamsNode.idNodes.get(i);
                visit(dcNode);
            }
            isParamsVisited = false;
        }

        @Override
        public void visit (StructDefinitionNode node){
            symbolTable.peek().put(node.typeNode.type, node);
            node.declarationNodes.forEach((d) -> visit(d));
        }

        @Override
        public void visit (FieldIdNode node){
            node.structDefinitionNode = BindFieldXToDeclaration(node.idNodes);
            if (node.structDefinitionNode == null) {
                Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, node.idNodes.get(0).id));
            }
        }

        @Override
        public void visit (FieldValueNode node){
            node.structDefinitionNode = BindFieldXToDeclaration(node.idNodes);
            if (node.structDefinitionNode == null) {
                Main.CompileErrors.add(new CompilerError.UndefinedError(node.columnNumber, node.lineNumber, node.idNodes.get(0).id));
            }
        }


        private boolean isParamsVisited = false;
        private FormalParamsNode formalParamsNode = null;

        @Override
        public void visit (BlockNode node){
            OpenScope();
            if (isParamsVisited) includeFormalParamsInScope();
            super.visit(node);
            CloseScope();
        }
    }