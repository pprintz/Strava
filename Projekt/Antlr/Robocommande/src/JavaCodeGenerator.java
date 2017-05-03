import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class JavaCodeGenerator extends Visitor {
	private int indentationLevel = 0;

	private ArrayList<String> strategies;
	PrintWriter writer;


	JavaCodeGenerator(ArrayList<String> strategies) {
		super();
		this.strategies = strategies;
		try {
			writer = new PrintWriter(new FileOutputStream("./out/JavaCodeGeneratorOutput.java", false));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		Emit("", 1);
		Emit("{", 1);
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

	public void visit(TypeNode node, boolean indent) {
		String javaType = RoboToJavaType(node.type);
		if(indent) {
			Emit(javaType, 0);
		} else {
			EmitNoIndent(javaType);
		}
	}

    @Override
    public void visit(BehaviorFunctionNode node) {
	    Emit("\n", 0);
        Emit("void " + node.idNode.id + "(", 0);
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
		Emit("class defaultStrategy extends AdvancedRobot implements Strategy {", 2);
		indentationLevel++;
		super.visit(node);
		indentationLevel--;
		Emit("}", 2);
	}

	@Override
	public void visit(DefineFunctionNode node) {
		Emit("public", 0);
		visit(node.typeNode, false);
		visit(node.idNode, false);
		EmitNoIndent("(");
		if (node.formalParamsNode != null) {
			visit(node.formalParamsNode);
		}
		EmitNoIndent(")");
		visit(node.blockNode);

//		super.visit(node);
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

	@Override
	public void visit(ProgNode node) {
		String className = "MyRobot";

		Emit("package Robocommande;", 2);
		Emit("import java.awt.Color; \n" +
				"import robocode.AdvancedRobot; \n" +
				"import robocode.HitByBulletEvent; \n" +
				"import robocode.ScannedRobotEvent; \n" +
				"import java.lang.Math; \n" +
				"import java.util.ArrayList; \n" +
				"import robocode.util.Utils;", 2);

		Emit("interface Strategy {", 1);
		indentationLevel++;
		Emit("public void run();", 1);
		indentationLevel--;
		Emit("}", 2);

		Emit("public class " + className + " extends AdvancedRobot {\n", 1);
		indentationLevel++;

		Emit("public ArrayList<Strategy> strategies;", 1);
		Emit("public Strategy currentStrategy;", 2);

		Emit("public " + className + "() {", 1);
		indentationLevel++;
		Emit("strategies = new ArrayList<>();", 1);

		for (String strategy : strategies) {
			Emit("strategies.add(new " + strategy + "Strategy());", 1);
		}

		indentationLevel--;
		Emit("}", 2);

		Emit("public void run() {", 1);
		indentationLevel++;
		Emit("while (true) {", 1);
		indentationLevel++;
		Emit("currentStrategy.run();", 1);
		indentationLevel--;
		Emit("}", 1);
		indentationLevel--;
		Emit("}", 2);

		super.visit(node);
		indentationLevel--;
		Emit("}", 2);

		writer.close();
	}

	@Override
	public void visit(RunNode node) {
		Emit("public void run()", 0);
//		indentationLevel++;
		visit(node.blockNode);
//		indentationLevel--;
//		Emit("}", 2);
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
		Emit("public void run() {", 1);
		super.visit(node);
		indentationLevel++;
		Emit("while(true) {", 1);
		indentationLevel++;
		Emit("runNode();", 1);
		indentationLevel--;
		Emit("}", 1);
		indentationLevel--;
		Emit("}", 1);
	}

	@Override
	public void visit(StrategyNode node) {

		Emit("class", 0);
		visit(node.idNode, false);
		EmitNoIndent("Strategy extends defaultStrategy implements Strategy { \n\n");
		indentationLevel++;
		visit(node.strategyDefinition);
		indentationLevel--;
		Emit("}", 2);
	}

}
