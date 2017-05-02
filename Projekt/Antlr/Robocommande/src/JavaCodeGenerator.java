import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class JavaCodeGenerator extends Visitor {
	private int indentationLevel = 0;

	private ArrayList<String> strategies;

	public JavaCodeGenerator(ArrayList<String> strategies) {
		super();
		this.strategies = strategies;
	}

	public void Emit(String emitString, int numberOfNewLines){
		System.out.print(indent() + emitString + new String(new char[numberOfNewLines]).replace("\0", "\n"));
	}

	public void EmitNoIndent(String emitString) {
		System.out.print(emitString);
	}

	private String indent(){
		return new String(new char[indentationLevel]).replace("\0", "    ");
	}

	// TODO: Not really sure if this is a good idea
	@Deprecated
	@Override
	public void visit(TypeNode node) {}

	public void visit(TypeNode node, boolean indent) {
		if(indent) {
			Emit(node.type, 0);
		} else {
			EmitNoIndent(" " + node.type);
		}
	}

	@Override
	public void visit(DeclarationNode node) {
		visit(node.typeNode, true);
		visit(node.idNode, false);
		if (node.exprNode != null) {
			visit(node.exprNode);
		}
		Emit("", 1);
	}

	@Override
	public void visit(DefaultStrategyNode node) {
		Emit("class DefaultStrategy extends AdvancedRobot implements Strategy {", 2);
		indentationLevel++;
		super.visit(node);
		indentationLevel--;
		Emit("}", 2);
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

	private void binaryStatements(BinaryExprNode node, String symbol) {
		if (node.leftNode != null) visit(node.leftNode);
		Emit(" " + symbol + " ", 0);
		if (node.rightNode != null) visit(node.rightNode);

	}

	@Override
	public void visit(ProgNode node) {
		String className = "MyRobot";

		Emit("\nimport java.awt.Color; \n" +
				"import robocode.AdvancedRobot; \n" +
				"import robocode.HitByBulletEvent; \n" +
				"import robocode.ScannedRobotEvent; \n" +
				"import java.lang.Math; \n" +
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


	}

	@Override
	public void visit(RunNode node) {
		Emit("public void run() {", 1);
		indentationLevel++;
		visit(node.blockNode);
		indentationLevel--;
		Emit("}", 2);
	}

	// TODO: Not really sure if this is a good idea
	@Deprecated
	@Override
	public void visit(IdNode node) {}

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

		Emit("class ", 0);
		visit(node.idNode, false);
		EmitNoIndent("Strategy extends DefaultStrategy implements Strategy { \n\n");
		indentationLevel++;
		visit(node.strategyDefinition);
		indentationLevel--;
		Emit("}", 2);
	}

}
