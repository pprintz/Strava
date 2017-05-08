import java.util.ArrayList;

public class StrategyVisitor extends Visitor {

	public ArrayList<String> strategies;
	public ArrayList<String> customNewEvents;

	public StrategyVisitor() {
		strategies = new ArrayList<>();
		customNewEvents = new ArrayList<>();
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
		customNewEvents.add(node.idNode.id);
	}



}
