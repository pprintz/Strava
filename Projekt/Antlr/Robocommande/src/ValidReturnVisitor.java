import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pprintz on 5/8/17.
 */
public class ValidReturnVisitor extends Visitor {

    @Override
    public void visit(DefineFunctionNode node) {
        boolean hasReturn = false;
        if (!node.typeNode.type.equals("void")) {
            hasReturn = isBranchReturning(node.blockNode);
        }
        if (!hasReturn) {
            PrintReturnError(node);
        }
    }

    private boolean isBranchReturning(BlockNode node) {
        Queue<IfStatementNode> ifStatementNodeQueue = new LinkedList<>();
        for (StmtNode s : node.functionStmtNodes) {
            if (s instanceof ReturnStatementNode) {
                return true;
            } else if (s instanceof IfStatementNode) {
                IfStatementNode ifStatementNode = (IfStatementNode) s;
                ifStatementNodeQueue.add(ifStatementNode);
            }
        }
        while (ifStatementNodeQueue.peek() != null) {
            boolean hasReturn;
            IfStatementNode ifNode = ifStatementNodeQueue.poll();

            hasReturn = isBranchReturning(ifNode.ifBlockNode);
            if(!hasReturn) continue;
            if (ifNode.elseIfNodes != null) {
                for (ElseIfStatementNode elif : ifNode.elseIfNodes) {
                    hasReturn = isBranchReturning(elif.blockNode);
                    if(!hasReturn) continue;
                }
            }
            if (ifNode.elseBlockNode != null) {
                hasReturn = isBranchReturning(ifNode.elseBlockNode);
                if(!hasReturn) continue;
            }
            else return false;
            return hasReturn;
        }
        return false;
    }

    public void PrintReturnError(DefineFunctionNode node){
        System.out.println(node.lineNumber + ": " + "Missing return in function " + node.idNode.id);
    }
}