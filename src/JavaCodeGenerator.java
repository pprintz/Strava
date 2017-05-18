import Enums.BinaryOperator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JavaCodeGenerator extends Visitor {
	private int indentationLevel = 0;

    private String className;
	private ArrayList<String> strategies;
	private ArrayList<NewEventNode> newCustomEvents;
	private PrintWriter writer;
    private ArrayList<String> events;
    private HashMap<String, String> translationMap;

    JavaCodeGenerator(ArrayList<String> strategies, ArrayList<NewEventNode> newCustomEvents) {
		super();
		this.strategies = strategies;
		this.newCustomEvents = newCustomEvents;
		events = new ArrayList<>();
		addAllEventsToList();
		fillTranslationMap();
		try {
            writer = new PrintWriter(new FileWriter(Main.inputFileName + ".java",false));
		} catch (Exception e) {
			e.printStackTrace();
		}
        className = "Robot_MyRobot";
    }

    @Override
    public void visit(FunctionCallNode node) {
        if (node.fieldIdNode != null) {
            emit("");   // It's terrible, but it works!
            visit(node.fieldIdNode);
            emitNoIndent("(");
        } else {
            if (translationMap.containsKey(node.idNode.id)) {
                emit(translationMap.get(node.idNode.id));
            } else {
                emit(node.idNode.id);
            }
            emitNoIndent("(");
        }
        visit(node.actualParams);
        emitNoIndent(");\n");
    }

    @Override
    public void visit(ReturnStatementNode node) {
        emit("return ", 0);
        visit(node.exprNode);
        emitNoIndent(";\n");
    }

    private String roboToJavaType(String roboType) {
		switch(roboType) {
			case "num":
				return "double";
			case "text":
				return "String";
			case "bool":
				return "boolean";
			default:
				return roboType;
		}
	}

	private void emit(String emitString){
		writer.print(indent() + emitString);
	}

	private void emit(String emitString, int numberOfNewLines){
		writer.print(indent() + emitString + new String(new char[numberOfNewLines]).replace("\0", "\n"));
	}

	private void emitNoIndent(String emitString) {
		writer.print(emitString);
	}

	private String indent(){
		return new String(new char[indentationLevel]).replace("\0", "    ");
	}

    private void emitImports() {
        emit("import robocode.*; \n" +
                "import java.awt.Color; \n" +
                "import java.lang.Math; \n" +
                "import java.util.HashMap;", 2);
    }

    private void emitAutoGenDoc() {
        emit("/**\n * Automatically generated by Strava for " +
                System.getProperty("user.name") +  " on " +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +
                ".\n */", 2);
    }

	private void emitChangeStrategyDefinition() {
	    emit("private void changeStrategy(String strategyName) {", 1);
	    indentationLevel++;
	    emit("Strategy newStrategy = strategies.get(strategyName);", 1);
	    emit("if (newStrategy != null) {", 1);
	    indentationLevel++;
	    emit("System.out.println(\"Changing to: \" + strategyName);", 1);
	    emit("currentStrategy = newStrategy;", 1);
	    indentationLevel--;
	    emit("} else {", 1);
	    indentationLevel++;
	    emit("throw new RuntimeException(\"Cannot find strategy!\");", 1);
	    indentationLevel--;
        emit("}", 1);
        indentationLevel--;
	    emit("}", 2);
    }

	@Override
	public void visit(TypeNode node) {
		emitNoIndent(roboToJavaType(node.type));
	}

	@Override
	public void visit(StmtNode node) {
		if (node != null) {
			super.visit(node);
		}
	}

	@Override
	public void visit(BlockNode node) {
		if (node == null) return;

		emitNoIndent(" {\n");
		indentationLevel++;
		for (StmtNode stmtNode : node.functionStmtNodes) {
			visit(stmtNode);
		}
		indentationLevel--;
		emit("}", 1);
	}

	@Override
	public void visit(BinaryExprNode node) {
		if (node.binaryOperator == BinaryOperator.POWER) {
			emitNoIndent("Math.pow(");
			visit(node.leftNode);
			emitNoIndent(", ");
			visit(node.rightNode);
			emitNoIndent(")");
		} else if (node.binaryOperator == BinaryOperator.MODULO) {
            emitNoIndent("(");
            visit(node.leftNode);
            emitNoIndent(" - (Math.floor(");
            visit(node.leftNode);
            emitNoIndent(" / ");
            visit(node.rightNode);
            emitNoIndent(") * ");
            visit(node.rightNode);
            emitNoIndent(")");
            emitNoIndent(")");
        } else {
            visit(node.leftNode);
            emitNoIndent(node.binaryOperator.toString());
            visit(node.rightNode);
        }

	}

	// Capitalizes first letter
	public void visit(TypeNode node, boolean indent) {
		String javaType = roboToJavaType(node.type);
		if (javaType.endsWith("Event")) {
            if(indent) {
                emit(javaType.substring(0,1).toUpperCase() + javaType.substring(1), 0);
            } else {
                emitNoIndent(javaType.substring(0,1).toUpperCase() + javaType.substring(1));
            }
        } else {
		    if (indent) {
		        emit(javaType, 0);
		    } else {
		        emitNoIndent(javaType);
            }
        }
	}

    @Override
    public void visit(BehaviorFunctionNode node) {
	    emit("\n", 0);
        emit("public void " + node.eventName.id + "(", 0);
        if(node.eventType != null) {
            emitNoIndent(node.eventName.id.replace("on", "") + "Event e");
		}
        emitNoIndent(")");
        visit(node.blockNode);
    }

    @Override
	public void visit(DeclarationNode node) {
		visit(node.typeNode, true);
		emitNoIndent(" " + node.idNode.id);
		if (node.exprNode != null) {
			emitNoIndent(" = ");
			visit(node.exprNode);
		}
		// This fucks up structInit
		if(node.exprNode instanceof StructInitializationNode) {
			emitNewLine();
		} else {
			emitNoIndent("; \n");
		}
	}

    /**
     * Check if user wants to specifically implement an event in default strategy.
     * If not, implement an empty event.
     */
	@Override
	public void visit(DefaultStrategyNode node) {
		emit("class strategy_defaultStrategy implements Strategy {", 1);
		indentationLevel++;
        visit(node.strategyDefinition.runNode);
        if(node.strategyDefinition.runNode == null) {
            emit("public void run () { }", 1);
        }
		visit(node.strategyDefinition.functionsNode);

        for (String event : events) {
            boolean isImplemented = false;
            if (node.strategyDefinition.functionsNode != null) {
                for (BehaviorFunctionNode behavior : node.strategyDefinition.functionsNode.behaviorFunctions) {
                    String eventName = behavior.eventName.id;
                    if (event.equals(eventName)) {
                        isImplemented = true;
//                        visit(behavior);
                    }
                }
                if (!isImplemented) {
                    boolean isCustomEvent = false;
                    for (NewEventNode newCustomEvent : newCustomEvents) {
                        if (event.equals(newCustomEvent.idNode.id)) {
                            isCustomEvent = true;
                        }
                    }
                    if (isCustomEvent) {
                        emit("public void " + event + "() { }", 1);
                    } else {
                        emit("public void " + event + "(" + event.replace("on", "") + "Event e) { }", 1);
                    }
                }
            }
        }
        indentationLevel--;
		emit("}", 2);
	}

    @Override
	public void visit(DefineFunctionNode node) {
		emit("public ", 0);
		visit(node.typeNode);
		emitNoIndent(" " + node.idNode.id);
		emitNoIndent("(");
		if (node.formalParamsNode != null) {
			visit(node.formalParamsNode);
		}
		emitNoIndent(")");
		visit(node.blockNode);
	}

	@Override
	public void visit(UnaryExprNode node) {
		switch(node.unaryOperator){
			case NEGATEBOOL:
				emitNoIndent("!");
				visit(node.exprNode);
				break;
			case NEGATE:
				emitNoIndent("-");
				visit(node.exprNode);
				break;
			case PARANTHESIS:
				emitNoIndent("(");
				visit(node.exprNode);
				emitNoIndent(")");
				break;
		}
	}

    private void addAllEventsToList() {
        events.add("onBattleEnded");
        events.add("onBulletHit");
        events.add("onBulletHitBullet");
        events.add("onBulletMissed");
        events.add("onDeath");
        events.add("onHitByBullet");
        events.add("onHitRobot");
        events.add("onHitWall");
        events.add("onRobotDeath");
        events.add("onRoundEnded");
        events.add("onScannedRobot");
        events.add("onStatus");
        events.add("onWin");
        newCustomEvents.forEach(x -> events.add(x.idNode.id));
    }

    private void emitAllInterfaceEventDefinitions() {
	    for (String eventString : events) {
            emitInterfaceMethod(eventString);
        }
	}

    private void emitInterfaceMethod(String event) {
        boolean isCustomEvent = false;
	    for (NewEventNode newCustomEvent : newCustomEvents) {
            if (event.equals(newCustomEvent.idNode.id))
                isCustomEvent = true;
        }
        if (isCustomEvent) {
            emit("void " + event + "();", 1);
        } else {
            emit("void " + event + "(" + event.replace("on", "") + "Event e);", 1);
        }
    }

    // TODO: Split this marvelous monster into sub-functions
	@Override
	public void visit(ProgNode node) {
        emitAutoGenDoc();
		emit("package Strava;", 2);
		emitImports();

        emit("interface Strategy {", 1);
		indentationLevel++;
		emit("void run();", 1);
        emitAllInterfaceEventDefinitions();
		indentationLevel--;
		emit("}", 2);

		emit("public class " + className + " extends AdvancedRobot implements Strategy {", 1);
		indentationLevel++;

		emit("public HashMap<String, Strategy> strategies;", 1);
		emit("public Strategy currentStrategy;", 2);

		emit("public " + className + "() {", 1);
		indentationLevel++;
		if(node.setupNode != null) {
            emit("setup();", 1);
        }
        emit("currentStrategy = new strategy_defaultStrategy();", 1);
        emit("strategies = new HashMap<String, Strategy>();", 1);
        for (String strategy : strategies) {
            if (!strategy.startsWith("default")) {
                emit("strategies.put(\"" + strategy + "\", " + "new strategy_" + strategy + "Strategy());", 1);
            } else {
                emit("strategies.put(\"" + strategy + "\", currentStrategy);", 1);
            }
        }
        indentationLevel--;
        emit("}", 2);

		emit("public void run() {", 1);
		indentationLevel++;
        emit("System.out.println(\"Run: \" + currentStrategy.toString());", 1);

        for	(NewEventNode newCustomEvent : newCustomEvents) {
			emit("addCustomEvent(new Condition(\"" + newCustomEvent.idNode.id + "\") {", 1);
			indentationLevel++;
			emit("public boolean test()");
			visit(newCustomEvent.blockNode);
			indentationLevel--;
			emit("});", 1); // end addCustomEvent

		}
		emitNewLine();

		emit("while (true) {", 1);
		indentationLevel++;
		emit("currentStrategy.run();", 1);
		indentationLevel--;
		emit("}", 1); // end while true
		indentationLevel--;
		emit("}", 2); // end run

		emitChangeStrategyDefinition();
		emitOnCustomEvent();

        for (String event : events) {
            boolean isCustomEvent = false;
            for (NewEventNode newCustomEvent : newCustomEvents) {
                if (event.equals(newCustomEvent.idNode.id))
                    isCustomEvent = true;
            }
            if (isCustomEvent) {
                emit("public void " + event + "() { currentStrategy." + event + "(); }", 1);

            } else {
                emit("public void " + event + "(" + event.replace("on", "") + "Event e) { currentStrategy." + event + "(e); }", 1);

            }
        }
        emitNewLine();

		super.visit(node);
		indentationLevel--;
		emit("}", 2);

		emitStructDefinitions(node);

		writer.close();
	}

	private void emitNewLine() {
	    emit("", 1);
    }

	private void emitOnCustomEvent() {
	    if(newCustomEvents == null || newCustomEvents.size() == 0) return;
		emit("public void onCustomEvent(CustomEvent e) {", 1);
		indentationLevel++;
		for (NewEventNode newCustomEvent : newCustomEvents) {
			emit("if (e.getCondition().getName().equals(\"" + newCustomEvent.idNode.id + "\")) {", 1);
			indentationLevel++;
			emit("currentStrategy." + newCustomEvent.idNode.id + "();", 1);
			// trigger -= 20;
			indentationLevel--;
			emit("}", 1);
		}
		indentationLevel--;
		emit("}", 2); // end onCustomEvent
	}

	@Override
	public void visit(StructDefinitionNode node) {
		// This method is intentionally empty
        // It is handled in emitStructDefinitions
	}

	private void emitStructDefinitions(ProgNode node) {
		if(node.setupNode == null) return;
        for (StmtNode stmtNode : node.setupNode.setupBlockNode.setupStmts) {
            if (stmtNode instanceof StructDefinitionNode) {
                emit("class " + ((StructDefinitionNode) stmtNode).typeNode.type + " {", 1);
                indentationLevel++;
                ((StructDefinitionNode) stmtNode).declarationNodes.forEach(dn -> visit(dn));

                emitNewLine();
                emit("public " + ((StructDefinitionNode) stmtNode).typeNode.type + "(");
                List<DeclarationNode> declarationNodes = ((StructDefinitionNode) stmtNode).declarationNodes;
                for (int i = 0; i < declarationNodes.size(); i++) {
                    DeclarationNode declarationNode = declarationNodes.get(i);
                    visit(declarationNode.typeNode);
                    emitNoIndent(" ");
                    visit(declarationNode.idNode);
                    if(i + 1 != declarationNodes.size()) {
                        emitNoIndent(", ");
                    }
                }
                emitNoIndent(") {\n");
                indentationLevel++;
                for (DeclarationNode declarationNode : ((StructDefinitionNode) stmtNode).declarationNodes) {
                    emit("this." + declarationNode.idNode.id + " = " + declarationNode.idNode.id + ";", 1);
                }
                indentationLevel--;
                emit("}", 1);
                indentationLevel--;
                emit("}", 2);
            }
        }
    }

	@Override
	public void visit(RunNode node) {
	    if(node == null) return;

		emit("public void run()", 0);
		super.visit(node);
	}

	@Override
	public void visit(IdNode node) {
		emitNoIndent(node.id);
	}

	@Override
	public void visit(LiteralNode node) {
		emitNoIndent(node.literalText);
	}

	public void visit(IdNode node, boolean indent) {
		if (indent) {
			emit(node.id, 0);
		} else {
			emitNoIndent(" " + node.id);
		}
	}

	@Override
	public void visit(SetupNode node) {
        for (StmtNode decl : node.setupBlockNode.setupStmts) {
            if (decl instanceof DeclarationNode) {
                visit(decl);
            }
        }

		emit("public void setup() {", 1);
        indentationLevel++;
        for (StmtNode decl : node.setupBlockNode.setupStmts) {
            if (!(decl instanceof DeclarationNode)) {
                visit(decl);
            }
        }
		indentationLevel--;
		emit("}", 2);
	}

	@Override
	public void visit(StrategyNode node) {
		emit("class ", 0);
		emitNoIndent("strategy_" + node.idNode.id);
		emitNoIndent("Strategy extends strategy_defaultStrategy { \n");
		indentationLevel++;
		visit(node.strategyDefinition);
		indentationLevel--;
		emit("}", 2);
	}

    @Override
    public void visit(ActualParamsNode node) {
	    if(node != null) {
            for (int i = 0; i < node.exprs.size(); i++) {
                visit(node.exprs.get(i));
                if (i != node.exprs.size() - 1) {
                    emitNoIndent(", ");
                }
            }
        }
    }

    @Override
    public void visit(AssignmentNode node) {
		emit(node.idNode.id);
		emitNoIndent(" = ");
		visit(node.exprNode);
		emitNoIndent(";\n");
    }

    public void visit(AssignmentNode node, boolean indent) {
		if (indent) {
		    emit(node.idNode.id);
        } else {
		    emitNoIndent(node.idNode.id);
        }
		emitNoIndent(" = ");
		visit(node.exprNode);
    }

    @Override
    public void visit(ElseIfStatementNode node) {
		emit("else if ", 0);
		emitNoIndent("(");
		visit(node.predicate);
		emitNoIndent(")");
		visit(node.blockNode);
	}

    @Override
    public void visit(FieldAssignmentNode node) {
		// Purely for indent
	    emit("");
	    visit(node.fieldIdNode);
		emitNoIndent(" = ");
		visit(node.exprNode);
		emitNoIndent(";");
		emitNewLine();
    }

    @Override
    public void visit(FieldIdNode node) {
		for (int i = 0; i < node.idNodes.size(); i++) {
			visit(node.idNodes.get(i));

			if(i != node.idNodes.size() - 1) {
				emitNoIndent(".");
			}
		}
	}

    @Override
    public void visit(FieldValueNode node) {
        for (int i = 0; i < node.idNodes.size(); i++) {
            IdNode idNode = node.idNodes.get(i);
            emitNoIndent(idNode.id);
            if(i + 1 != node.idNodes.size()) {
                emitNoIndent(".");
            }

        }
    }

    @Override
    public void visit(FormalParamsNode node) {
		for (int i = 0; i < node.idNodes.size(); i++) {
			visit(node.typeNodes.get(i), false);
			visit(node.idNodes.get(i), false);

			if(i != node.idNodes.size() - 1) {
				emitNoIndent(", ");
			}
		}
    }

    @Override
    public void visit(FunctionsNode node) {
	    if (node == null) return;
        super.visit(node);
    }

    @Override
    public void visit(IfStatementNode node) {
        emit("if ", 0);
        emitNoIndent("(");
        visit(node.predicate);
		emitNoIndent(")");
        visit(node.ifBlockNode);
        for (ElseIfStatementNode elif : node.elseIfNodes) {
			visit(elif);
		}
		if(node.elseBlockNode != null) {
			emit("else ", 0);
		}
        visit(node.elseBlockNode);

    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        if(node.fieldIdNode != null)
            visit(node.fieldIdNode);
        else {
            visit(node.idNode);
        }

        emitNoIndent("(");

        if(node.actualParams != null)
            node.actualParams.accept(this);

        emitNoIndent(")");

    }

    @Override
    public void visit(LoopNode node) {
		if(node.exprNode == null) {
			emit("while (true)");
		} else {
			emit("while (");
			visit(node.exprNode);
			emitNoIndent(")");
		}
		visit(node.block);
    }

    @Override
    public void visit(NewEventNode node) {
		// This method is intentionally empty
    }

    @Override
    public void visit(SetupBlockNode node) {
		super.visit(node);
    }

    @Override
    public void visit(StrategyDefinitionNode node) {
        visit(node.runNode);
        visit(node.functionsNode);
    }

    @Override
    public void visit(StructInitializationNode node) {
		emitNoIndent("new ");
		visit(node.typeNode);
		emitNoIndent("(");
        for (int i = 0; i < node.assignments.size(); i++) {
            AssignmentNode n = node.assignments.get(i);
            visit(n.exprNode);
            if (i + 1 != node.assignments.size()) {
                emitNoIndent(", ");
            }
        }
        emitNoIndent(");\n");
	}

	private void fillTranslationMap() {
	    translationMap = new HashMap<>();
	    translationMap.put("getAngle", "getBearing");
        translationMap.put("log", "System.out.println");
        translationMap.put("move", "ahead");
        translationMap.put("rotate", "turnRight");
        translationMap.put("rotateGun", "turnGunRight");
        translationMap.put("rotateRadar", "turnRadarRight");
    }
    
    public String BinaryOperatorToJavaOperator(BinaryOperator binaryOperator) {
		switch (binaryOperator) {
			case PLUS:
				return " + ";
			case MINUS:
				return " - ";
			case MULTIPLY:
				return " * ";
			case DIVISION:
				return " / ";
			case MODULO:
				return " % ";
			case LESSTHANEQUAL:
				return " <= ";
			case GREATERTHANEQUAL:
				return " >= ";
			case AND:
				return " && ";
			case OR:
				return " || ";
			case LESSTHAN:
				return " < ";
			case GREATERTHAN:
				return " > ";
			case EQUAL:
				return " == ";
			case NOTEQUAL:
				return " != ";
			default:
				throw new RuntimeException("Unknown binary operator. This should NEVER happen!");
		}
	}
}
