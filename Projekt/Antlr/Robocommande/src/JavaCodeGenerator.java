import Enums.BinaryOperator;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JavaCodeGenerator extends Visitor {
	private int indentationLevel = 0;

    private String className;
	private ArrayList<String> strategies;
	private ArrayList<NewEventNode> newCustomEvents;
	private PrintWriter writer;
    private ArrayList<String> events;

	JavaCodeGenerator(ArrayList<String> strategies, ArrayList<NewEventNode> newCustomEvents) {
		super();
		this.strategies = strategies;
		this.newCustomEvents = newCustomEvents;
		events = new ArrayList<>();
		AddAllEventsToList();
		try {
			writer = new PrintWriter(new FileOutputStream("./StrategyJava/JavaCodeGeneratorOutput.java", false));
		} catch (Exception e) {
			e.printStackTrace();
		}
        className = "MyRobot";
    }

    @Override
    public void visit(FunctionCallNode node) {
	    if (BindingVisitor.roboFunctions.containsKey(node.idNode.id)) {
            Emit(BindingVisitor.roboFunctions.get(node.idNode.id) + "(", 0);
        } else {
	        Emit(node.idNode.id + "(", 0);
        }
        visit(node.actualParams);
        EmitNoIndent(");\n");
    }

    @Override
    public void visit(ReturnStatementNode node) {
        Emit("return ", 0);
        visit(node.exprNode);
        EmitNoIndent(";\n");
    }

    private String RoboToJavaType(String roboType) {
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

	private void Emit(String emitString){
		writer.print(indent() + emitString);
	}

	private void Emit(String emitString, int numberOfNewLines){
		writer.print(indent() + emitString + new String(new char[numberOfNewLines]).replace("\0", "\n"));
	}

	private void EmitNoIndent(String emitString) {
		writer.print(emitString);
	}

	private String indent(){
		return new String(new char[indentationLevel]).replace("\0", "    ");
	}

    private void EmitImports() {
        Emit("import robocode.*; \n" +
                "import java.awt.Color; \n" +
                "import java.lang.Math; \n" +
                "import java.util.HashMap;", 2);
    }

    private void EmitAutoGenDoc() {
        Emit("/**\n * Automatically generated by Robocommande for " +
                System.getProperty("user.name") +  " on " +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +
                ".\n */", 2);
    }

	private void EmitChangeStrategyDefinition() {
	    Emit("private void changeStrategy(String strategyName) {", 1);
	    indentationLevel++;
	    Emit("Strategy newStrategy = strategies.get(strategyName);", 1);
	    Emit("if (newStrategy != null) {", 1);
	    indentationLevel++;
	    Emit("System.out.println(\"Changing to: \" + strategyName);", 1);
	    Emit("currentStrategy = newStrategy;", 1);
	    indentationLevel--;
	    Emit("} else {", 1);
	    indentationLevel++;
	    Emit("throw new RuntimeException(\"Cannot find strategy!\");", 1);
	    indentationLevel--;
        Emit("}", 1);
        indentationLevel--;
	    Emit("}", 2);
    }

	@Override
	public void visit(TypeNode node) {
		EmitNoIndent(RoboToJavaType(node.type));
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

		EmitNoIndent(" {\n");
		indentationLevel++;
		for (StmtNode stmtNode : node.functionStmtNodes) {
			visit(stmtNode);
		}
		indentationLevel--;
		Emit("}", 1);
	}

	@Override
	public void visit(BinaryExprNode node) {
		if (node.binaryOperator == BinaryOperator.POWER) {
			EmitNoIndent("Math.pow(");
			visit(node.leftNode);
			EmitNoIndent(", ");
			visit(node.rightNode);
			EmitNoIndent(")");
		} else {
			visit(node.leftNode);
			EmitNoIndent(BinaryOperatorToJavaOperator(node.binaryOperator));
			visit(node.rightNode);
		}

	}

	// Capitalizes first letter
	public void visit(TypeNode node, boolean indent) {
		String javaType = RoboToJavaType(node.type);
		if (javaType.endsWith("Event")) {
            if(indent) {
                Emit(javaType.substring(0,1).toUpperCase() + javaType.substring(1), 0);
            } else {
                EmitNoIndent(javaType.substring(0,1).toUpperCase() + javaType.substring(1));
            }
        } else {
		    if (indent) {
		        Emit(javaType, 0);
		    } else {
		        EmitNoIndent(javaType);
            }
        }
	}

    @Override
    public void visit(BehaviorFunctionNode node) {
	    Emit("\n", 0);
        Emit("public void " + node.idNode.id + "(", 0);
        if(node.eventType != null) {
			visit(node.eventType, false);
			EmitNoIndent(" e");
		}
        EmitNoIndent(")");
        visit(node.blockNode);
    }

    @Override
	public void visit(DeclarationNode node) {
		visit(node.typeNode, true);
		if (node.exprNode != null) {
			EmitNoIndent(" = ");
			visit(node.exprNode);
		}
		// This fucks up structInit
		if(node.exprNode instanceof StructInitializationNode) {
			Emit("", 1);
		} else {
			EmitNoIndent("; \n");
		}
	}

    /**
     * Check if user wants to specifically implement an event in default strategy.
     * If not, implement an empty event.
     */
	@Override
	public void visit(DefaultStrategyNode node) {
		Emit("class defaultStrategy implements Strategy {", 1);
		indentationLevel++;
		if (node.strategyDefinition.runNode != null) {
			visit(node.strategyDefinition.runNode);
		}
        String fullEventName;
        for (String event : events) {
            fullEventName = "on" + event;
            boolean isImplemented = false;
            if (node.strategyDefinition.functionsNode != null) {
                for (BehaviorFunctionNode behavior : node.strategyDefinition.functionsNode.behaviorFunctions) {
                    if (fullEventName.equals(behavior.idNode.id)) {
                        isImplemented = true;
                        visit(behavior);
                        break;
                    }
                }
            }

            if (!isImplemented) {
                EmitDefaultInterfaceEventImplementation(event);
            }
        }
		indentationLevel--;
		Emit("}", 2);
	}

	@Override
	public void visit(DefineFunctionNode node) {
		Emit("public ", 0);
		visit(node.typeNode);
		EmitNoIndent("(");
		if (node.formalParamsNode != null) {
			visit(node.formalParamsNode);
		}
		EmitNoIndent(")");
		visit(node.blockNode);
	}

	@Override
	public void visit(UnaryExprNode node) {
		switch(node.unaryOperator){
			case NEGATEBOOL:
				Emit("!", 0);
				visit(node.exprNode);
				break;
			case NEGATE:
				Emit("-", 0);
				visit(node.exprNode);
				break;
			case PARANTHESIS:
				Emit("(", 0);
				visit(node.exprNode);
				Emit(")", 0);
				break;
		}
	}

    private void AddAllEventsToList() {
        events.add("BattleEnded");
        events.add("BulletHit");
        events.add("BulletHitBullet");
        events.add("BulletMissed");
        events.add("Death");
        events.add("HitByBullet");
        events.add("HitRobot");
        events.add("HitWall");
        events.add("RobotDeath");
        events.add("RoundEnded");
        events.add("ScannedRobot");
        events.add("Status");
        events.add("Win");
    }

    private void EmitAllInterfaceEventDefinitions() {
	    for (String eventString : events) {
	        Emit("void on" + eventString + "(" + eventString + "Event e);", 1);
        }
		for (NewEventNode newCustomEvent : newCustomEvents) {
			Emit("void " + newCustomEvent.idNode.id + "(); // new custom event", 1);
		}
	}

    private void EmitDefaultInterfaceEventImplementation(String event) {
	    Emit("public void on" + event + "(" + event + "Event e) { }", 1);
    }

    // TODO: Split this marvelous monster into sub-functions
	@Override
	public void visit(ProgNode node) {
        EmitAutoGenDoc();
		Emit("package Robocommande;", 2);
		EmitImports();

        Emit("interface Strategy {", 1);
		indentationLevel++;
		Emit("void run();", 1);
        EmitAllInterfaceEventDefinitions();
		indentationLevel--;
		Emit("}", 2);

		Emit("public class " + className + " extends AdvancedRobot implements Strategy {", 1);
		indentationLevel++;

		Emit("public HashMap<String, Strategy> strategies;", 1);
		Emit("public Strategy currentStrategy;", 2);

		Emit("public " + className + "() {", 1);
		indentationLevel++;
		if(node.setupNode != null) {
            Emit("setup();", 1);
        }
        Emit("currentStrategy = new defaultStrategy();", 1);
        Emit("strategies = new HashMap<String, Strategy>();", 1);
        for (String strategy : strategies) {
            if (!strategy.startsWith("default")) {
                Emit("strategies.put(\"" + strategy + "\", " + "new " + strategy + "Strategy());", 1);
            } else {
                Emit("strategies.put(\"" + strategy + "\", currentStrategy);", 1);
            }
        }
        indentationLevel--;
        Emit("}", 2);

		Emit("public void run() {", 1);
		indentationLevel++;
        Emit("System.out.println(\"Run: \" + currentStrategy.toString());", 1);

        // TODO: Custom Events
        for	(NewEventNode newCustomEvent : newCustomEvents) {
			Emit("addCustomEvent(new Condition(\"" + newCustomEvent.idNode.id + "\") {", 1);
			indentationLevel++;
			Emit("public boolean test()");
			visit(newCustomEvent.blockNode);
			indentationLevel--;
			Emit("});", 1); // end addCustomEvent

		}

		Emit("while (true) {", 1);
		indentationLevel++;
		Emit("currentStrategy.run();", 1);
		indentationLevel--;
		Emit("}", 1); // end while true
		indentationLevel--;
		Emit("}", 2); // end run

		EmitChangeStrategyDefinition();
		// TODO: onCustomEvent()
		EmitOnCustomEvent();

		String behaviorName;
		if (node.defaultStrategyNode.strategyDefinition.functionsNode != null) {
            for (BehaviorFunctionNode behavior : node.defaultStrategyNode.strategyDefinition.functionsNode.behaviorFunctions) {
                behaviorName = behavior.idNode.id;
                if(behavior.eventType != null) {
					Emit("public void " + behaviorName + "(" + behaviorName.replace("on", "") + "Event e) { currentStrategy." + behaviorName + "(e); }", 1);
				}
            }
            Emit("", 1);
        }

		super.visit(node);
		indentationLevel--;
		Emit("}", 2);

		EmitStructDefinitions(node);

		writer.close();
	}

	private void EmitOnCustomEvent() {
		Emit("public void onCustomEvent(CustomEvent e) {", 1);
		indentationLevel++;
		for (NewEventNode newCustomEvent : newCustomEvents) {
			Emit("if (e.getCondition().getName().equals(\"" + newCustomEvent.idNode.id + "\")) {", 1);
			indentationLevel++;
			Emit("currentStrategy." + newCustomEvent.idNode.id + "();", 1);
			// trigger -= 20;
			indentationLevel--;
			Emit("}", 1);
		}
		indentationLevel--;
		Emit("}", 2); // end onCustomEvent
	}

	@Override
	public void visit(StructDefinitionNode node) {
		// This method is intentionally empty
	}

	private void EmitStructDefinitions(ProgNode node) {
		if(node.setupNode == null) return;
		node.setupNode.setupBlockNode.setupStmts.forEach(st -> {
			if(st instanceof StructDefinitionNode){
				Emit("class " + ((StructDefinitionNode) st).typeNode.type + " {", 1);
				indentationLevel++;
				((StructDefinitionNode) st).declarationNodes.forEach(dn -> visit(dn));
				indentationLevel--;
				Emit("}", 2);
			}
		});
	}

	@Override
	public void visit(RunNode node) {
		Emit("public void run()", 0);
		super.visit(node);
	}

	@Override
	public void visit(IdNode node) {
		EmitNoIndent(node.id);
	}

	@Override
	public void visit(LiteralNode node) {
		EmitNoIndent(node.literalText);
	}

	public void visit(IdNode node, boolean indent) {
		if (indent) {
			Emit(node.id, 0);
		} else {
			EmitNoIndent(" " + node.id);
		}
	}

	@Override
	public void visit(SetupNode node) {
        for (StmtNode decl : node.setupBlockNode.setupStmts) {
            if (decl instanceof DeclarationNode) {
                visit(decl);
            }
        }

		Emit("public void setup() {", 1);
        indentationLevel++;
        for (StmtNode decl : node.setupBlockNode.setupStmts) {
            if (!(decl instanceof DeclarationNode)) {
                visit(decl);
            }
        }
		indentationLevel--;
		Emit("}", 2);
	}

	@Override
	public void visit(StrategyNode node) {
		Emit("class", 0);
		visit(node.idNode, false);
		EmitNoIndent("Strategy extends defaultStrategy { \n");
		indentationLevel++;
		visit(node.strategyDefinition);
		indentationLevel--;
		Emit("}", 2);
	}

    @Override
    public void visit(ActualParamsNode node) {
		for (int i = 0; i < node.exprs.size(); i++) {
			visit(node.exprs.get(i));
			if(i != node.exprs.size() - 1) {
				EmitNoIndent(", ");
			}
		}
    }

    @Override
	// TODO: Don't think this function is needed
    public void visit(FunctionStmtNode node) {
		throw new RuntimeException("Point fingers at Lau");
    }

    @Override
	// TODO: Don't think this function is needed
	public void visit(GeneralStmtNode node) {
		throw new RuntimeException("Point fingers at Lau");
    }

    @Override
    public void visit(AssignmentNode node) {
		visit(node.idNode, true);
		EmitNoIndent(" = ");
		visit(node.exprNode);
		EmitNoIndent(";\n");
    }

    @Override
    public void visit(ElseIfStatementNode node) {
		Emit("else if ", 0);
		EmitNoIndent("(");
		visit(node.predicate);
		EmitNoIndent(")");
		visit(node.blockNode);
	}

    @Override
    public void visit(FieldAssignmentNode node) {
		visit(node.fieldIdNode);
		EmitNoIndent(" = ");
		visit(node.exprNode);
		Emit("", 1);
    }

    @Override
    public void visit(FieldIdNode node) {
		for (int i = 0; i < node.idNodes.size(); i++) {
			visit(node.idNodes.get(i));

			if(i != node.idNodes.size() - 1) {
				EmitNoIndent(".");
			}
		}
	}

    @Override
    public void visit(FormalParamsNode node) {
		for (int i = 0; i < node.idNodes.size(); i++) {
			visit(node.typeNodes.get(i), false);
			visit(node.idNodes.get(i), false);

			if(i != node.idNodes.size() - 1) {
				EmitNoIndent(", ");
			}
		}
    }

    @Override
    public void visit(FunctionsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(IfStatementNode node) {
        Emit("if ", 0);
        EmitNoIndent("(");
        visit(node.predicate);
		EmitNoIndent(")");
        visit(node.ifBlockNode);
        for (ElseIfStatementNode elif : node.elseIfNodes) {
			visit(elif);
		}
		if(node.elseBlockNode != null) {
			Emit("else ", 0);
		}
        visit(node.elseBlockNode);

    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        super.visit(node);
    }

    @Override
    public void visit(LoopNode node) {
		if(node.exprNode == null) {
			Emit("while (true)");
		} else {
			Emit("while (");
			visit(node.exprNode);
			EmitNoIndent(")");
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
	// TODO: Don't think this function is needed
    public void visit(SetupStmtNode node) {
        throw new RuntimeException("Point fingers at Lau");
    }

    @Override
    public void visit(StrategyDefinitionNode node) {
		if(node.runNode != null) {
			visit(node.runNode);
		}

        for (BehaviorFunctionNode behavior : node.functionsNode.behaviorFunctions) {
            if (!events.contains(behavior.idNode.id)) {
                visit(behavior);
            }
        }
    }

    @Override
	// TODO: Make sure this can handle a struct init with no assignments
    public void visit(StructInitializationNode node) {
		EmitNoIndent("new ");
		visit(node.typeNode);
		EmitNoIndent(" {\n");
		indentationLevel++;
		node.assignments.forEach(n -> visit(n));
		indentationLevel--;
		Emit("}", 1);
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
				throw new RuntimeException("This should NEVER happen!");
		}
	}
}
