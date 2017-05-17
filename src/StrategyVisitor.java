import java.util.ArrayList;

public class StrategyVisitor extends Visitor {

	public ArrayList<String> strategies;
	public ArrayList<NewEventNode> newCustomEvents;

	public StrategyVisitor() {
		strategies = new ArrayList<>();
		newCustomEvents = new ArrayList<>();
	}

	@Override
	public void visit(DefaultStrategyNode node) {
		//super.visit(node);
		strategies.add(node.toString());
	}

	@Override
	public void visit(StrategyNode node) {
		//super.visit(node);
		strategies.add(node.idNode.id);
	}

	public void visit(NewEventNode node) {
		newCustomEvents.add(node);
	}



}