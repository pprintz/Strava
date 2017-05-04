import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("Duplicates")
public class JavaCodeGenerator extends Visitor {
	private int indentationLevel = 0;

    private String className;
	private ArrayList<String> strategies;
	private PrintWriter writer;


	JavaCodeGenerator(ArrayList<String> strategies) {
		super();
		this.strategies = strategies;
		try {
			writer = new PrintWriter(new FileOutputStream("./out/JavaCodeGeneratorOutput.java", false));
		} catch (Exception e) {
			e.printStackTrace();
		}
        className = "MyRobot";
    }

    @Override
    public void visit(FunctionCallNode node) {
        Emit(node.idNode.id + "(", 0);
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
                "import java.util.HashMap;\n", 2);
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
//        Emit("if (strategies.containsKey(newStrategy.toString())) {", 1);
	    indentationLevel++;
	    Emit("System.out.println(\"Changing to: \" + strategyName);", 1);
	    Emit("currentStrategy = newStrategy;", 1);
	    indentationLevel--;
	    Emit("} else {", 1);
	    indentationLevel++;
	    Emit("System.out.println(\"NOT HAPPENING!\");", 1);
	    indentationLevel--;
        Emit("}", 1);
        indentationLevel--;
	    Emit("}", 2);
    }

	// TODO: Not really sure if this is a good idea
	@Deprecated
	@Override
	public void visit(TypeNode node) {}

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
		super.visit(node);
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
        visit(node.eventType, false);
        EmitNoIndent(" e");
        EmitNoIndent(")");
        visit(node.blockNode);
    }

    @Override
	public void visit(DeclarationNode node) {
		visit(node.typeNode, true);
		visit(node.idNode, false);
		if (node.exprNode != null) {
			EmitNoIndent(" = ");
			visit(node.exprNode);
		}
		EmitNoIndent("; \n");
	}

	@Override
	public void visit(DefaultStrategyNode node) {
		Emit("class defaultStrategy implements Strategy {", 1);
		indentationLevel++;
		super.visit(node);
		indentationLevel--;
		Emit("}", 2);
	}

	@Override
	public void visit(DefineFunctionNode node) {
		Emit("public ", 0);
		visit(node.typeNode, false);
		visit(node.idNode, false);
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

	private void EmitEvent(String event) {
        Emit("public void on" + event + "(" + event + "Event e) {", 1);
        indentationLevel++;
        Emit("currentStrategy.on" + event + "(e);", 1);
        indentationLevel--;
        Emit("}", 2);
    }

	@Override
	public void visit(ProgNode node) {
        EmitAutoGenDoc();
		Emit("package Robocommande;", 2);
		EmitImports();

        Emit("interface Strategy {", 1);
		indentationLevel++;
		Emit("public void run();", 1);
        Emit("public void onHitByBullet(HitByBulletEvent e);", 1);
        Emit("public void onScannedRobot(ScannedRobotEvent e);", 1);
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

        EmitEvent("ScannedRobot");
        EmitEvent("HitByBullet");

		Emit("public void run() {", 1);
		indentationLevel++;

		Emit("while (true) {", 1);
		indentationLevel++;
		Emit("System.out.println(\"Run: \" + currentStrategy.toString());", 1);
		Emit("currentStrategy.run();", 1);
		indentationLevel--;
		Emit("}", 1);
		indentationLevel--;
		Emit("}", 2);

		EmitChangeStrategyDefinition();
		super.visit(node);
		indentationLevel--;
		Emit("}", 1);

		writer.close();
	}

    @Override
	public void visit(RunNode node) {
		Emit("public void run()", 0);
		super.visit(node);
	}

	// TODO: Not really sure if this is a good idea
	@Deprecated
	@Override
	public void visit(IdNode node) {}

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
		Emit("public void setup() {", 1);
        indentationLevel++;
		super.visit(node);
		indentationLevel--;
		Emit("}", 2);
	}

	@Override
	public void visit(StrategyNode node) {
		Emit("class", 0);
		visit(node.idNode, false);
		EmitNoIndent("Strategy extends defaultStrategy { \n");
		indentationLevel++;
		super.visit(node);
		indentationLevel--;
		Emit("}", 2);
	}

	/////////////

    @Override
    public void visit(ActualParamsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(FunctionStmtNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(GeneralStmtNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(AssignmentNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(ElseIfStatementNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(FieldAssignmentNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(FieldIdNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(FormalParamsNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(FunctionsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(IfStatementNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(LoopNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(NewEventNode node) {
//        Emit("new event ", 0);
//        EmitNoIndent(node.idNode.id);
//        Emit(" ", 0);
//        visit(node.blockNode);
		throw new NotImplementedException();
    }

    @Override
    public void visit(SetupBlockNode node) {
		super.visit(node);
    }

    @Override
    public void visit(SetupStmtNode node) {

        throw new NotImplementedException();
    }

    @Override
    public void visit(StrategyDefinitionNode node) {
		super.visit(node);
    }

    @Override
    public void visit(StructDefinitionNode node) {
        throw new NotImplementedException();
    }

    @Override
    public void visit(StructInitializationNode node) {
        throw new NotImplementedException();
    }
}
