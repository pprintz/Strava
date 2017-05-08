import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pprintz on 5/8/17.
 */
public class ValidReturnVisitor extends Visitor {

    public boolean hasReturnError = false;
    @Override
    public void visit(DefineFunctionNode node) {
        boolean hasReturn = false;
        if (!node.typeNode.type.equals("void")) {
            hasReturn = isBranchReturning(node.blockNode);
        }
        if (!hasReturn) {
            hasReturnError = true;
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
            boolean isReturning;
            IfStatementNode ifNode = ifStatementNodeQueue.poll();

            isReturning = isBranchReturning(ifNode.ifBlockNode);
            if(!isReturning) continue;
            if (ifNode.elseIfNodes != null) {
                for (ElseIfStatementNode elif : ifNode.elseIfNodes) {
                    isReturning = isBranchReturning(elif.blockNode);
                    if(!isReturning) continue;
                }
            }
            if (ifNode.elseBlockNode != null) {
                isReturning = isBranchReturning(ifNode.elseBlockNode);
                if(!isReturning) continue;
            }
            else return false;
            return isReturning;
        }
        return false;
    }

    public void PrintReturnError(DefineFunctionNode node){
        System.out.println(node.lineNumber + ": " + "Missing return in function " + node.idNode.id);
    }
}