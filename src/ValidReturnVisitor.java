import CompilerError.MissingReturnError;
import CompilerWarning.UnreachableCodeWarning;

import java.util.LinkedList;
import java.util.Queue;

public class ValidReturnVisitor extends Visitor {

    public boolean hasReturnError = false;

    @Override
    public void visit(DefineFunctionNode node) {
        boolean isReturning;
        if (!node.typeNode.type.equals("void")) {
            isReturning = isBranchReturning(node.blockNode);
            if (!isReturning) {
                hasReturnError = true;
                Main.CompileErrors.add(new MissingReturnError(node.columnNumber, node.lineNumber, node.idNode.id));
            }
        }
    }

    @Override
    public void visit(NewEventNode node) {
        boolean isReturning;
        isReturning = isBranchReturning(node.blockNode);
        if (!isReturning) {
            hasReturnError = true;
            Main.CompileErrors.add(new MissingReturnError(node.columnNumber, node.lineNumber, "in body of " + node.idNode.id));
        }
    }

    private boolean isBranchReturning(BlockNode node) {
        Queue<IfStatementNode> ifStatementNodeQueue = new LinkedList<>();

        for (int i = 0; i < node.functionStmtNodes.size(); i++) {
            StmtNode s = node.functionStmtNodes.get(i);
            if (s instanceof ReturnStatementNode) {
                if (node.functionStmtNodes.size() - 1 > i) {
                    IssueUnreachableCodeError(node, i + 1);
                }
                return true;
            } else if (s instanceof IfStatementNode) {
                IfStatementNode ifStatementNode = (IfStatementNode) s;
                ifStatementNodeQueue.add(ifStatementNode);
            }
        }
        nodeQueueLoop:
        while (ifStatementNodeQueue.peek() != null) {
            boolean isReturning;
            IfStatementNode ifNode = ifStatementNodeQueue.poll();

            if (ifNode.elseBlockNode != null) {
                isReturning = isBranchReturning(ifNode.elseBlockNode);
                if (!isReturning) {
                    continue;
                }
            } else {
                continue ;
            }
            isReturning = isBranchReturning(ifNode.ifBlockNode);
            if (!isReturning) {
                continue;
            }
            if (ifNode.elseIfNodes != null) {
                for (ElseIfStatementNode elif : ifNode.elseIfNodes) {
                    isReturning = isBranchReturning(elif.blockNode);
                    if (!isReturning) {
                        continue nodeQueueLoop;
                    }
                }
            }
            if (node.functionStmtNodes.size() - 1 > node.functionStmtNodes.indexOf(ifNode)) {
                IssueUnreachableCodeError(node, node.functionStmtNodes.indexOf(ifNode) + 1);
            }

            return isReturning;
        }
        return false;
    }

    private void IssueUnreachableCodeError(BlockNode node, int indexOfNextUnreachableNode) {
        StmtNode unreachableStartNode = node.functionStmtNodes.get(indexOfNextUnreachableNode);
        StmtNode unreachableEndNode = node.functionStmtNodes.get(node.functionStmtNodes.size() - 1);
        Main.CompileErrors.add(new UnreachableCodeWarning(unreachableStartNode.columnNumber,
            unreachableStartNode.lineNumber, unreachableEndNode.lineNumber));
    }
}