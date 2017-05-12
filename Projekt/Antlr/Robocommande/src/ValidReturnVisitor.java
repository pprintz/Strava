import java.util.LinkedList;
import java.util.Queue;
import CompilerError.*;

/**
 * Created by pprintz on 5/8/17.
 */
public class ValidReturnVisitor extends Visitor {

    public boolean hasReturnError = false;
    @Override
    public void visit(DefineFunctionNode node) {
        boolean isReturning = false;
        if (node.typeNode.type != "void") {
            isReturning = isBranchReturning(node.blockNode);
        }
        if (!isReturning) {
            hasReturnError = true;
            Main.CompileErrors.add(new MissingReturnError(node.columnNumber, node.lineNumber, node.idNode.id));
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

        nodeQueueLoop: while (ifStatementNodeQueue.peek() != null) {
            boolean isReturning;
            IfStatementNode ifNode = ifStatementNodeQueue.poll();

            isReturning = isBranchReturning(ifNode.ifBlockNode);
            if(!isReturning) continue;
            if (ifNode.elseIfNodes != null) {
                for (ElseIfStatementNode elif : ifNode.elseIfNodes) {
                    isReturning = isBranchReturning(elif.blockNode);
                    if(!isReturning) continue nodeQueueLoop;
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
}