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
		strategies.add(node.toString());
	}

	@Override
	public void visit(StrategyNode node) {
		strategies.add(node.idNode.id);
	}

	public void visit(NewEventNode node) {
	    if (!node.idNode.id.startsWith("on")) {
            node.idNode.id = "on" + node.idNode.id;
        }
		newCustomEvents.add(node);
	}



}
