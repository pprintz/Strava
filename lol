diff --git a/.gitignore b/.gitignore
index a7478e2..df56715 100644
--- a/.gitignore
+++ b/.gitignore
@@ -99,3 +99,6 @@ xcuserdata
 # VSCode Java plugin temporary files
 javac-services.0.log
 javac-services.0.log.lck
+Projekt/Antlr/Robocommande/src/CodeGenerationInput.txt
+# *.txt
+Projekt/Antlr/Robocommande/StrategyJava/JavaCodeGeneratorOutput.java
diff --git a/Projekt/Antlr/Robocommande/src/AST.java b/Projekt/Antlr/Robocommande/src/AST.java
index 98fbe64..3b39103 100644
--- a/Projekt/Antlr/Robocommande/src/AST.java
+++ b/Projekt/Antlr/Robocommande/src/AST.java
@@ -499,7 +499,7 @@ class ReturnStatementNode extends StmtNode {
     }
 }
 
-class FieldIdNode extends ASTNode {
+class FieldIdNode extends ExprNode {
     public List<IdNode> idNodes;
     public StructDefinitionNode structDefinitionNode;
 
diff --git a/Projekt/Antlr/Robocommande/src/ASTBuilder.java b/Projekt/Antlr/Robocommande/src/ASTBuilder.java
index 8a48d63..db58039 100644
--- a/Projekt/Antlr/Robocommande/src/ASTBuilder.java
+++ b/Projekt/Antlr/Robocommande/src/ASTBuilder.java
@@ -264,8 +264,12 @@ public class ASTBuilder extends RobocommandeBaseVisitor<ASTNode> {
 
     @Override
     public ASTNode visitLoop(RobocommandeParser.LoopContext ctx) {
+		BlockNode blockNode = (BlockNode)visit(ctx.block());
+    	if(ctx.expr() == null) {
+			return new LoopNode(null, blockNode);
+		}
+
         ExprNode exprNode = (ExprNode)visit(ctx.expr());
-        BlockNode blockNode = (BlockNode)visit(ctx.block());
         return new LoopNode(exprNode, blockNode);
     }
 
diff --git a/Projekt/Antlr/Robocommande/src/BindingVisitor.java b/Projekt/Antlr/Robocommande/src/BindingVisitor.java
index 0446bc8..20f9f53 100644
--- a/Projekt/Antlr/Robocommande/src/BindingVisitor.java
+++ b/Projekt/Antlr/Robocommande/src/BindingVisitor.java
@@ -1,19 +1,19 @@
-import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Stack;
 
-/**
- * Created by pprintz on 4/4/17.
- */
 public class BindingVisitor extends Visitor {
-    ArrayList<String> roboFunctions;
+    public static HashMap<String, String> roboFunctions;
 
     private Stack<HashMap<String, ASTNode>> symbolTable;
 
     public BindingVisitor() {
         symbolTable = new Stack<>();
         symbolTable.push(new HashMap<>());
+<<<<<<< HEAD
+        roboFunctions = new HashMap<>();
+        AddRoboFunctionsToHashMap();
+=======
         roboFunctions = new ArrayList<>();
         roboFunctions.add("ahead");
         roboFunctions.add("turnGunRight");
@@ -23,6 +23,7 @@ public class BindingVisitor extends Visitor {
 
     public BindingVisitor(Stack<HashMap<String, ASTNode>> symbolTableWithFunctions) {
         symbolTable = symbolTableWithFunctions;
+>>>>>>> origin/master
     }
 
     private void OpenScope() {
@@ -33,6 +34,50 @@ public class BindingVisitor extends Visitor {
         symbolTable.pop();
     }
 
+    private void AddRoboFunctionsToHashMap() {
+        roboFunctions.put("ahead", "ahead"); // void -> void
+        roboFunctions.put("back", "back"); // double -> void
+        roboFunctions.put("changeStrategy", "changeStrategy"); // String
+        roboFunctions.put("doNothing", "doNothing"); // void -> void
+        roboFunctions.put("fire", "fireBullet"); // double -> Bullet
+        roboFunctions.put("getBattleFieldHeight", "getBattleFieldHeight"); // void -> double
+        roboFunctions.put("getBattleFieldWidth", "getBattleFieldWidth"); // void -> double
+        roboFunctions.put("getEnergy", "getEnergy"); // void -> double
+        roboFunctions.put("getGunCoolingRate", "getGunCoolingRate"); // void -> double
+        roboFunctions.put("getGunHeading", "getGunHeading"); // void -> double
+        roboFunctions.put("getGunHeat", "getGunHeat"); // void -> double
+        roboFunctions.put("getHeading", "getHeading"); // void -> double
+        roboFunctions.put("getName", "getName"); // void -> String
+        roboFunctions.put("getNumRounds", "getNumRounds"); // void -> int
+        roboFunctions.put("getOthers", "getOthers"); // void -> int
+        roboFunctions.put("getRadarHeading", "getRadarHeading"); // void -> double
+        roboFunctions.put("getRoundNum", "getRoundNum"); // void -> int
+        roboFunctions.put("getTime", "getTime"); // void -> long
+        roboFunctions.put("getVelocity", "getVelocity"); // void -> double
+        roboFunctions.put("getX", "getX"); // void -> double
+        roboFunctions.put("getY", "getY"); // void -> double
+        roboFunctions.put("log", "System.out.println"); // String --
+        roboFunctions.put("resume", "resume"); // void -> void
+        roboFunctions.put("rotate", "turnGunRight"); // double -> void
+        roboFunctions.put("scan", "scan"); // void -> void
+        roboFunctions.put("setAdjustGunForRobotTurn", "setAdjustGunForRobotTurn"); // bool -> void
+        roboFunctions.put("setAdjustRadarForGunTurn", "setAdjustRadarForGunTurn"); // bool -> void
+        roboFunctions.put("setAdjustRadarForRobotTurn", "setAdjustRadarForRobotTurn"); // bool -> void
+        roboFunctions.put("setAllColors", "setAllColors"); // Color -> void
+        roboFunctions.put("setBodyColor", "setBodyColor"); // Color -> void
+        roboFunctions.put("setBulletColor", "setBulletColor"); // Color -> void
+        roboFunctions.put("setColors", "setColors"); // Color, Color, Color, Color, Color -> void
+        roboFunctions.put("setGunColor", "setGunColor"); // Color -> void
+        roboFunctions.put("setRadarColor", "setRadarColor"); // Color -> void
+        roboFunctions.put("setScanColor", "setScanColor"); // Color -> void
+        roboFunctions.put("stop", "stop"); // void -> void
+        roboFunctions.put("turnGunLeft", "turnGunLeft"); // double -> void
+        roboFunctions.put("turnGunRight", "turnGunRight"); // double -> void
+        roboFunctions.put("turnLeft", "turnLeft"); // double -> void
+        roboFunctions.put("turnRadarLeft", "turnRadarLeft"); // double -> void
+        roboFunctions.put("turnRadarRight", "turnRadarRight"); // double -> void
+        roboFunctions.put("turnRight", "turnRight"); // double -> void
+    }
     private void BindIdToDeclaration(IdNode idNode) {
         boolean isDeclared = false;
         for (int i = symbolTable.size() - 1; i >= 0; i--) {
@@ -47,8 +92,14 @@ public class BindingVisitor extends Visitor {
         }
     }
 
+<<<<<<< HEAD
+    private void BindFieldIdToDeclaration(FieldIdNode fieldIdNode) {
+        boolean isDeclared = false;
+        IdNode structId = fieldIdNode.idNodes.get(0);
+=======
     private StructDefinitionNode BindFieldXToDeclaration(List<IdNode> idNodes) {
         IdNode structId = idNodes.get(0);
+>>>>>>> origin/master
         for (int i = symbolTable.size() - 1; i >= 0; i--) {
             if (symbolTable.get(i).containsKey(structId.id)) {
                 ASTNode astNode = symbolTable.get(i).get(structId.id);
@@ -61,11 +112,35 @@ public class BindingVisitor extends Visitor {
         return null;
     }
 
+<<<<<<< HEAD
+    static boolean hasBindingErrorOccured = false;
+    private void BindFunctionCallToDeclaration(FunctionCallNode fCallNode) {
+        boolean isDeclared = false;
+        if (roboFunctions.containsKey(fCallNode.idNode.id)) {
+            isDeclared = true;
+        }
+        if(hasFunctionsBeenDeclared) {
+            for (int i = symbolTable.size() - 1; i >= 0; i--) {
+                if (symbolTable.get(i).containsKey(fCallNode.idNode)) {
+                    fCallNode.defineFunctionNode = (DefineFunctionNode) symbolTable.get(i).get(fCallNode.idNode);
+                    isDeclared = true;
+                }
+            }
+            if (!isDeclared) {
+                hasBindingErrorOccured = true;
+                PrintNotDeclaredError("function", fCallNode.idNode.id, fCallNode);
+            }
+        }
+    }
+
+    private void BindExprFunctionCallToDeclaration(ExprFunctionCallNode fCallNode) {
+=======
 
     public static boolean hasBindingErrorOccured = false;
 
     private DefineFunctionNode BindFunctionCallToDeclaration(ASTNode node, String idName, ActualParamsNode actualParams){
         DefineFunctionNode defineFunctionNode = null;
+>>>>>>> origin/master
         boolean isDeclared = false;
         for (int i = symbolTable.size() - 1; i >= 0; i--) {
             if (symbolTable.get(i).containsKey(idName)) {
@@ -197,6 +272,14 @@ public class BindingVisitor extends Visitor {
 
     }
 
+<<<<<<< HEAD
+    private boolean doesDeclExistLocally(DeclarationNode node){
+        for(int i = symbolTable.size()-1; i >= 0; i--){
+            if(symbolTable.get(i).containsKey(node.idNode)){
+                DeclarationNode declNodeFound = (DeclarationNode)symbolTable.get(i).get(node.idNode);
+                if(!declNodeFound.IsGlobal) {
+                    System.out.println("Already declared variable with name: " + node.idNode.id + " LINE" + declNodeFound.lineNumber);
+=======
     // TODO : fields with same names in different struct definit
 
     private boolean doesDeclExistLocally(DeclarationNode node) {
@@ -205,6 +288,7 @@ public class BindingVisitor extends Visitor {
                 DeclarationNode declNodeFound = (DeclarationNode) symbolTable.get(i).get(node.idNode.id);
                 if (!declNodeFound.IsGlobal) {
                     System.out.println("Already declared variable with name: " + node.idNode.id + " LINE " + declNodeFound.lineNumber);
+>>>>>>> origin/master
                     return true;
                 } else {
                     if (i == symbolTable.size() - 1) {
@@ -218,7 +302,6 @@ public class BindingVisitor extends Visitor {
         return false;
     }
 
-
     @Override
     public void visit(DefineFunctionNode node) {
         if (node.formalParamsNode != null) {
diff --git a/Projekt/Antlr/Robocommande/src/CodeGenerationInput.txt b/Projekt/Antlr/Robocommande/src/CodeGenerationInput.txt
deleted file mode 100644
index 8e5c1d0..0000000
--- a/Projekt/Antlr/Robocommande/src/CodeGenerationInput.txt
+++ /dev/null
@@ -1,128 +0,0 @@
-behavior onSetup () :
-    text b
-;
-
-strategy default:
-    behavior onRun () :
-        ahead(10)
-    ;
-
-    behavior onHitByBullet(hitByBulletEvent e) :
-        changeStrategy("defensive")
-    ;
-
-    behavior onScannedRobot(scannedRobotEvent e) :
-        changeStrategy("aggressive")
-    ;
-
-    behavior onBulletHit(bulletHitEvent e) :
-        num a := 5
-    ;
-
-    behavior onHitWall(HitWallEvent e) :
-        ahead(50)
-    ;
-;
-
-
-strategy aggressive :
-	behavior onRun () :
-	    turnGunRight(360)
-	;
-
-    behavior onHitByBullet(hitByBulletEvent e):
-        changeStrategy("defensive")
-    ;
-;
-
-strategy defensive :
-    behavior onRun() :
-    	back(100)
-    ;
-
-    behavior onScannedRobot(scannedRobotEvent e) :
-        changeStrategy("aggressive")
-    ;
-;
-
-
-
-
-
-
-///////////////////////
-
-// grammar Robocommande ;
-//
-// prog : NEWLINE* setup? defaultStrategy (strategy | defineFunction)* EOF ;
-//
-// setup: 'behavior' 'onSetup' '('')' setupBlock;
-// run: 'behavior' 'onRun' '('')' block;
-//
-// functions : (defineFunction | behaviorFunction)* ;
-// defineFunction : 'define' type ID '(' formalParams? ')' block;
-// behaviorFunction : 'behavior' ID '(' ID ID ')' block;
-// formalParams: type ID (',' type ID)* ;
-// actualParams: expr (',' expr)* ;
-//
-// strategy : 'strategy' ID strategyDefinition;
-// defaultStrategy : 'strategy' 'default' strategyDefinition;
-// strategyDefinition : ':' NEWLINE+ run? functions? ';' NEWLINE*;
-//
-// setupBlock : ':' (setupStmt)* ';' NEWLINE* ;
-// block : ':' (stmt)* ';' NEWLINE* ;
-//
-// setupStmt : NEWLINE+ ( generalStmtPart
-                 // | newEvent )? NEWLINE*
-                 // ;
-//
-// stmt : NEWLINE+ (  generalStmtPart
-                 // | returnStatement )? NEWLINE*
-                 // ;
-//
-// generalStmtPart : declaration
-                // | structDefinition
-                // | assignment
-                // | fieldAssignment
-                // | ifStatement
-                // | functionCall
-                // | loop
-                // ;
-//
-// structDefinition : ID '{' declaration (',' declaration)* '}' ;
-// declaration: type ID (':=' expr)? ;
-// type: 'num'
-    // | 'text'
-    // | 'bool'
-    // | ID
-    // ;
-//
-// newEvent : 'new' 'event' ID block ;
-// fieldAssignment : fieldId ':=' expr ;
-// assignment : ID ':=' expr ;
-// ifStatement: 'if' expr block ('else if' expr block)* ('else' block)? ;
-// functionCall: (fieldId | ID) '(' actualParams? ')' ;
-// structInitialization: ID '(' assignment? (',' assignment)* ')' ;
-// loop: 'loop' ('while' expr)? block ;
-// returnStatement : 'return' expr ;
-//
-// expr :     ('true' | 'false')               # literalBool
-          // | ID                              # idRef
-          // | NUM                             # literalNum
-          // | STRING                          # literalString
-          // | fieldId                         # fieldIdentifier
-          // | functionCall                    # fCall
-          // | structInitialization            # structInit
-          // |'(' expr ')'                     # unaryExpr
-          // | 'not' expr                      # unaryExpr
-          // | '-' expr                        # unaryExpr
-          // | <assoc=right> expr '^' expr     # binaryExpr
-          // | expr ('*'|'/'|'%') expr         # binaryExpr
-          // | expr ('+'|'-') expr             # binaryExpr
-          // | expr ('<='|'>='|'<'|'>') expr   # binaryExpr
-          // | expr ('!='|'=') expr            # binaryExpr
-          // | expr 'and' expr                 # binaryExpr
-          // | expr 'or' expr                  # binaryExpr
-          // ;
-//
-// fieldId : ID ('.' ID)+ ;
diff --git a/Projekt/Antlr/Robocommande/src/HelloWorld.txt b/Projekt/Antlr/Robocommande/src/HelloWorld.txt
new file mode 100644
index 0000000..e69de29
diff --git a/Projekt/Antlr/Robocommande/src/JavaCodeGenerator.java b/Projekt/Antlr/Robocommande/src/JavaCodeGenerator.java
index 034a23b..78964dd 100644
--- a/Projekt/Antlr/Robocommande/src/JavaCodeGenerator.java
+++ b/Projekt/Antlr/Robocommande/src/JavaCodeGenerator.java
@@ -6,22 +6,23 @@ import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 
-@SuppressWarnings("Duplicates")
 public class JavaCodeGenerator extends Visitor {
 	private int indentationLevel = 0;
 
     private String className;
 	private ArrayList<String> strategies;
+	private ArrayList<String> newCustomEvents;
 	private PrintWriter writer;
     private ArrayList<String> events;
 
-	JavaCodeGenerator(ArrayList<String> strategies) {
+	JavaCodeGenerator(ArrayList<String> strategies, ArrayList<String> newCustomEvents) {
 		super();
 		this.strategies = strategies;
+		this.newCustomEvents = newCustomEvents;
 		events = new ArrayList<>(14);
 		AddAllEventsToList();
 		try {
-			writer = new PrintWriter(new FileOutputStream("./out/JavaCodeGeneratorOutput.java", false));
+			writer = new PrintWriter(new FileOutputStream("./StrategyJava/JavaCodeGeneratorOutput.java", false));
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
@@ -30,7 +31,11 @@ public class JavaCodeGenerator extends Visitor {
 
     @Override
     public void visit(FunctionCallNode node) {
-        Emit(node.idNode.id + "(", 0);
+	    if (BindingVisitor.roboFunctions.containsKey(node.idNode.id)) {
+            Emit(BindingVisitor.roboFunctions.get(node.idNode.id) + "(", 0);
+        } else {
+	        Emit(node.idNode.id + "(", 0);
+        }
         visit(node.actualParams);
         EmitNoIndent(");\n");
     }
@@ -55,6 +60,10 @@ public class JavaCodeGenerator extends Visitor {
 		}
 	}
 
+	private void Emit(String emitString){
+		writer.print(indent() + emitString);
+	}
+
 	private void Emit(String emitString, int numberOfNewLines){
 		writer.print(indent() + emitString + new String(new char[numberOfNewLines]).replace("\0", "\n"));
 	}
@@ -169,7 +178,12 @@ public class JavaCodeGenerator extends Visitor {
 			EmitNoIndent(" = ");
 			visit(node.exprNode);
 		}
-		EmitNoIndent("; \n");
+		// This fucks up structInit
+		if(node.exprNode instanceof StructInitializationNode) {
+			Emit("", 1);
+		} else {
+			EmitNoIndent("; \n");
+		}
 	}
 
     /**
@@ -185,13 +199,16 @@ public class JavaCodeGenerator extends Visitor {
         for (String event : events) {
             fullEventName = "on" + event;
             boolean isImplemented = false;
-            for (BehaviorFunctionNode behavior : node.strategyDefinition.functionsNode.behaviorFunctions) {
-                if (fullEventName.equals(behavior.idNode.id)) {
-                    isImplemented = true;
-                    visit(behavior);
-                    break;
+            if (node.strategyDefinition.functionsNode != null) {
+                for (BehaviorFunctionNode behavior : node.strategyDefinition.functionsNode.behaviorFunctions) {
+                    if (fullEventName.equals(behavior.idNode.id)) {
+                        isImplemented = true;
+                        visit(behavior);
+                        break;
+                    }
                 }
             }
+
             if (!isImplemented) {
                 EmitDefaultInterfaceEventImplementation(event);
             }
@@ -258,6 +275,7 @@ public class JavaCodeGenerator extends Visitor {
 	    Emit("public void on" + event + "(" + event + "Event e) { }", 1);
     }
 
+    // TODO: Split this marvelous monster intro sub-functions
 	@Override
 	public void visit(ProgNode node) {
         EmitAutoGenDoc();
@@ -297,7 +315,26 @@ public class JavaCodeGenerator extends Visitor {
 		Emit("public void run() {", 1);
 		indentationLevel++;
         Emit("System.out.println(\"Run: \" + currentStrategy.toString());", 1);
-        Emit("while (true) {", 1);
+
+        // TODO: Custom Events
+//        for	(String customEvent : newCustomEvents) {
+//			Emit("addCustomEvent(new Condition(" + customEvent + ") {", 1);
+//			indentationLevel++;
+//			Emit("public boolean test() {", 1);
+//			indentationLevel++;
+//			visit(node.)
+//
+//			indentationLevel--;
+//			indentationLevel--;
+//;		}
+
+//		addCustomEvent(new Condition("triggerhit") {
+//			public boolean test() {
+//				return (getEnergy() <= trigger);
+//			}
+//		});
+
+		Emit("while (true) {", 1);
 		indentationLevel++;
 		Emit("currentStrategy.run();", 1);
 		indentationLevel--;
@@ -308,27 +345,47 @@ public class JavaCodeGenerator extends Visitor {
 		EmitChangeStrategyDefinition();
 
 		String behaviorName;
-		for (BehaviorFunctionNode behavior : node.defaultStrategyNode.strategyDefinition.functionsNode.behaviorFunctions) {
-		    behaviorName = behavior.idNode.id;
-            Emit("public void " + behaviorName + "(" + behaviorName.replace("on", "") + "Event e) { currentStrategy." + behaviorName + "(e); }", 1);
+		if (node.defaultStrategyNode.strategyDefinition.functionsNode != null) {
+            for (BehaviorFunctionNode behavior : node.defaultStrategyNode.strategyDefinition.functionsNode.behaviorFunctions) {
+                behaviorName = behavior.idNode.id;
+                Emit("public void " + behaviorName + "(" + behaviorName.replace("on", "") + "Event e) { currentStrategy." + behaviorName + "(e); }", 1);
+            }
+            Emit("", 1);
         }
-        Emit("", 1);
 
 		super.visit(node);
 		indentationLevel--;
-		Emit("}", 1);
+		Emit("}", 2);
+
+		EmitStructDefinitions(node);
 
 		writer.close();
 	}
 
-    @Override
+	@Override
+	public void visit(StructDefinitionNode node) {
+		// This method is intentionally empty
+	}
+
+	private void EmitStructDefinitions(ProgNode node) {
+		if(node.setupNode == null) return;
+		node.setupNode.setupBlockNode.setupStmts.forEach(st -> {
+			if(st instanceof StructDefinitionNode){
+				Emit("class " + ((StructDefinitionNode) st).structIdNode.id + " {", 1);
+				indentationLevel++;
+				((StructDefinitionNode) st).declarationNodes.forEach(dn -> visit(dn));
+				indentationLevel--;
+				Emit("}", 2);
+			}
+		});
+	}
+
+	@Override
 	public void visit(RunNode node) {
 		Emit("public void run()", 0);
 		super.visit(node);
 	}
 
-	// TODO: Not really sure if this is a good idea
-	@Deprecated
 	@Override
 	public void visit(IdNode node) {
 		EmitNoIndent(node.id);
@@ -349,9 +406,19 @@ public class JavaCodeGenerator extends Visitor {
 
 	@Override
 	public void visit(SetupNode node) {
+        for (StmtNode decl : node.setupBlockNode.setupStmts) {
+            if (decl instanceof DeclarationNode) {
+                visit(decl);
+            }
+        }
+
 		Emit("public void setup() {", 1);
         indentationLevel++;
-		super.visit(node);
+        for (StmtNode decl : node.setupBlockNode.setupStmts) {
+            if (!(decl instanceof DeclarationNode)) {
+                visit(decl);
+            }
+        }
 		indentationLevel--;
 		Emit("}", 2);
 	}
@@ -371,7 +438,12 @@ public class JavaCodeGenerator extends Visitor {
 
     @Override
     public void visit(ActualParamsNode node) {
-        super.visit(node);
+		for (int i = 0; i < node.exprs.size(); i++) {
+			visit(node.exprs.get(i));
+			if(i != node.exprs.size() - 1) {
+				EmitNoIndent(", ");
+			}
+		}
     }
 
     @Override
@@ -386,30 +458,49 @@ public class JavaCodeGenerator extends Visitor {
 
     @Override
     public void visit(AssignmentNode node) {
-        throw new NotImplementedException();
+		visit(node.idNode, true);
+		EmitNoIndent(" = ");
+		visit(node.exprNode);
+		EmitNoIndent(";\n");
     }
 
     @Override
     public void visit(ElseIfStatementNode node) {
-        Emit("else if ", 0);
-		super.visit(node);
-    }
+		Emit("else if ", 0);
+		EmitNoIndent("(");
+		visit(node.predicate);
+		EmitNoIndent(")");
+		visit(node.blockNode);
+	}
 
     @Override
     public void visit(FieldAssignmentNode node) {
-        throw new NotImplementedException();
+		visit(node.fieldIdNode);
+		EmitNoIndent(" = ");
+		visit(node.exprNode);
+		Emit("", 1);
     }
 
     @Override
     public void visit(FieldIdNode node) {
-        throw new NotImplementedException();
-    }
+		for (int i = 0; i < node.idNodes.size(); i++) {
+			visit(node.idNodes.get(i));
+
+			if(i != node.idNodes.size() - 1) {
+				EmitNoIndent(".");
+			}
+		}
+	}
 
     @Override
     public void visit(FormalParamsNode node) {
 		for (int i = 0; i < node.idNodes.size(); i++) {
 			visit(node.typeNodes.get(i), false);
 			visit(node.idNodes.get(i), false);
+
+			if(i != node.idNodes.size() - 1) {
+				EmitNoIndent(", ");
+			}
 		}
     }
 
@@ -442,7 +533,14 @@ public class JavaCodeGenerator extends Visitor {
 
     @Override
     public void visit(LoopNode node) {
-        throw new NotImplementedException();
+		if(node.exprNode == null) {
+			Emit("while (true)");
+		} else {
+			Emit("while (");
+			visit(node.exprNode);
+			EmitNoIndent(")");
+		}
+		visit(node.block);
     }
 
     @Override
@@ -467,18 +565,28 @@ public class JavaCodeGenerator extends Visitor {
 
     @Override
     public void visit(StrategyDefinitionNode node) {
-		super.visit(node);
-    }
+		if(node.runNode != null) {
+			visit(node.runNode);
+		}
 
-    @Override
-    public void visit(StructDefinitionNode node) {
-        throw new NotImplementedException();
+        for (BehaviorFunctionNode behavior : node.functionsNode.behaviorFunctions) {
+            if (!events.contains(behavior.idNode.id)) {
+                visit(behavior);
+            }
+        }
     }
 
     @Override
+	// TODO: Make sure this can handle a struct init with no assignments
     public void visit(StructInitializationNode node) {
-        throw new NotImplementedException();
-    }
+		EmitNoIndent("new ");
+		visit(node.idNode);
+		EmitNoIndent(" {\n");
+		indentationLevel++;
+		node.assignments.forEach(n -> visit(n));
+		indentationLevel--;
+		Emit("}", 1);
+	}
 
     public String BinaryOperatorToJavaOperator(BinaryOperator binaryOperator) {
 		switch (binaryOperator) {
diff --git a/Projekt/Antlr/Robocommande/src/Main.java b/Projekt/Antlr/Robocommande/src/Main.java
index 03fcbcd..beac993 100644
--- a/Projekt/Antlr/Robocommande/src/Main.java
+++ b/Projekt/Antlr/Robocommande/src/Main.java
@@ -54,6 +54,17 @@ public class Main {
 
         CommonTokenStream tokens = new CommonTokenStream(lexer);
 
+<<<<<<< HEAD
+//        TypeChecker typeChecker = new TypeChecker();
+//        typeChecker.visit(ast);
+
+		System.out.println("Type checking done.");
+
+		JavaCodeGenerator codeGenerator = new JavaCodeGenerator(strategyVisitor.strategies, strategyVisitor.customNewEvents);
+		codeGenerator.visit(ast);
+
+        System.out.println("Code generation done.");
+=======
         RobocommandeParser parser = new RobocommandeParser(tokens);
 
         ParseTree cst = parser.prog();
@@ -61,5 +72,6 @@ public class Main {
         ASTBuilder astBuilder = new ASTBuilder();
 
         return astBuilder.visit(cst);
+>>>>>>> origin/master
     }
 }
diff --git a/Projekt/Antlr/Robocommande/src/StrategyVisitor.java b/Projekt/Antlr/Robocommande/src/StrategyVisitor.java
index dd76f54..3d996a1 100644
--- a/Projekt/Antlr/Robocommande/src/StrategyVisitor.java
+++ b/Projekt/Antlr/Robocommande/src/StrategyVisitor.java
@@ -3,9 +3,11 @@ import java.util.ArrayList;
 public class StrategyVisitor extends Visitor {
 
 	public ArrayList<String> strategies;
+	public ArrayList<String> customNewEvents;
 
 	public StrategyVisitor() {
 		strategies = new ArrayList<>();
+		customNewEvents = new ArrayList<>();
 	}
 
 	@Override
@@ -20,6 +22,10 @@ public class StrategyVisitor extends Visitor {
 		strategies.add(node.idNode.id);
 	}
 
+	public void visit(NewEventNode node) {
+		customNewEvents.add(node.idNode.id);
+	}
+
 
 
 }
diff --git a/Projekt/Antlr/Robocommande/src/Visitor.java b/Projekt/Antlr/Robocommande/src/Visitor.java
index b78671f..a75db65 100644
--- a/Projekt/Antlr/Robocommande/src/Visitor.java
+++ b/Projekt/Antlr/Robocommande/src/Visitor.java
@@ -143,7 +143,13 @@ public abstract class Visitor {
     }
 
     public void visit(LoopNode node){
+<<<<<<< HEAD
+    	if(node.exprNode != null) {
+			node.exprNode.accept(this);
+		}
+=======
         node.predicate.accept(this);
+>>>>>>> origin/master
         node.block.accept(this);
     }
 
