import CompilerError.BehaviorRedefinedError;
import CompilerError.EventNotDefined;
import CompilerWarning.UnhandledCustomEventWarning;

import java.util.HashMap;

/**
 * Created by pprintz on 5/24/17.
 */
public class CheckBehaviorsAndEventsVisitor extends Visitor {
    private HashMap<String, NewEventNode> events = new HashMap<>();
    private HashMap<String, BehaviorFunctionNode> handlers = new HashMap<>();

    public CheckBehaviorsAndEventsVisitor(){
        events.put("onBattleEnded", null);
        events.put("onBulletHit", null);
        events.put("onBulletHitBullet", null);
        events.put("onBulletMissed", null);
        events.put("onDeath", null);
        events.put("onHitByBullet", null);
        events.put("onHitRobot", null);
        events.put("onHitWall", null);
        events.put("onRobotDeath", null);
        events.put("onRoundEnded", null);
        events.put("onScannedRobot", null);
        events.put("onStatus", null);
        events.put("onWin", null);
    }

    @Override
    public void visit(ProgNode node) {
        super.visit(node);
        if(events != null) {
            for (NewEventNode eventNode : events.values()) {
                if (eventNode != null && !eventNode.isHandled) {
                    Main.CompileWarnings.add(new UnhandledCustomEventWarning(eventNode.columnNumber, eventNode.lineNumber, eventNode.idNode.id));
                }
            }
        }
    }

    @Override
    public void visit(NewEventNode node) {
        events.put("on" + node.idNode.id, node);
    }

    @Override
    public void visit(BehaviorFunctionNode node) {
        String eventName = node.eventName.id;
        if(!events.containsKey(eventName)){
            Main.CompileErrors.add(new EventNotDefined(node.columnNumber, node.lineNumber,
                eventName.replaceFirst("on", "")));
        }
        else{
            if(handlers.containsKey(eventName)){
                Main.CompileErrors.add(new BehaviorRedefinedError(node.columnNumber,
                    node.lineNumber, node.eventName.id, handlers.get(eventName).lineNumber));
            }
            handlers.put(eventName, node);
        }
    }
}
