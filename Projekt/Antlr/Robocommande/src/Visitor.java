public abstract class Visitor {


    public void visit(ActualParamsNode node){
        for(ExprNode expr : node.exprs){
            visit(expr);
        }
    }

    public void visit(TypeNode node) {}
    public void visit(ASTNode node){
        node.accept(this);
    }

    public void visit(FunctionStmtNode node){
        node.accept(this);
    }

    public void visit(GeneralStmtNode node){
        node.accept(this);
    }

    public void visit(AssignmentNode node){
        node.idNode.accept(this);
        node.exprNode.accept(this);
    }

    public void visit(BehaviorFunctionNode node){
        node.idNode.accept(this);
        node.eventType.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(BlockNode node) {
        for (StmtNode stmtNode : node.functionStmtNodes) {
            if (stmtNode != null)
                stmtNode.accept(this);
        }
    }



    public void visit(BinaryExprNode node){
        node.leftNode.accept(this);
        node.rightNode.accept(this);
    }

    public void visit(DeclarationNode node){
        node.idNode.accept(this);
        if(node.exprNode != null)
            node.exprNode.accept(this);
    }

    public void visit(DefaultStrategyNode node){
        node.strategyDefinition.accept(this);
    }

    public void visit(DefineFunctionNode node){
        node.idNode.accept(this);
        if(node.formalParamsNode != null) {
			node.formalParamsNode.accept(this);
		}
        node.blockNode.accept(this);
    }

    public void visit(ElseIfStatementNode node){
        node.predicate.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(FieldAssignmentNode node){
        node.fieldIdNode.accept(this);
        node.exprNode.accept(this);
    }

    public void visit(FieldIdNode node){
        for(IdNode idnode : node.idNodes){
            idnode.accept(this);
        }
    }

    public void visit(FieldValueNode node){
        for(IdNode idnode : node.idNodes){
            idnode.accept(this);
        }
    }

    public void visit(FormalParamsNode node){
        if(!node.idNodes.isEmpty()) {
            for (IdNode pnode : node.idNodes) {
                pnode.accept(this);
            }
            for (IdNode pnode : node.idNodes) {
                pnode.accept(this);
            }
        }
    }

    public void visit(FunctionCallNode node){
        if(node.fieldIdNode != null)
        node.fieldIdNode.accept(this);
        node.idNode.accept(this);
        if(node.actualParams != null)
        node.actualParams.accept(this);
    }

    public void visit(FunctionsNode node){
        for(DefineFunctionNode defnode : node.defineFunctions){
            defnode.accept(this);
        }

        for(BehaviorFunctionNode behnode : node.behaviorFunctions){
            behnode.accept(this);
        }
    }

    public void visit(UnaryExprNode node){
        node.exprNode.accept(this);
    }

    public void visit(IdNode node){ }

    public void visit(IfStatementNode node){
        node.predicate.accept(this);
        node.ifBlockNode.accept(this);
        for(ElseIfStatementNode elifNode : node.elseIfNodes){
            elifNode.accept(this);
        }
        if(node.elseBlockNode != null) {
			node.elseBlockNode.accept(this);
		}
	}
    public void visit(ExprFunctionCallNode node){
        if(node.fieldIdNode != null)
            node.fieldIdNode.accept(this);
        node.idNode.accept(this);
        if(node.actualParams != null)
            node.actualParams.accept(this);
    }

    public void visit(LiteralNode node){

    }

    public void visit(LoopNode node){
	if(node.exprNode != null) {
			node.exprNode.accept(this);
		}
        node.block.accept(this);
    }

    public void visit(NewEventNode node){
        node.idNode.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(ProgNode node) {
        if(node.setupNode != null) {
            node.setupNode.accept(this);
        }
        node.defaultStrategyNode.accept(this);
        for(StrategyNode strategyNode : node.strategyNodes) {
            strategyNode.accept(this);
        }

        for(DefineFunctionNode defineFunctionsNode : node.defineFunctionNodes) {
            defineFunctionsNode.accept(this);
        }
    }

    public void visit(ReturnStatementNode node) {
        node.exprNode.accept(this);
    }

    public void visit(RunNode node) {
        node.blockNode.accept(this);
    }

    public void visit(SetupBlockNode node) {
        for (StmtNode setupStmt : node.setupStmts) {
            if(setupStmt != null) {
                setupStmt.accept(this);
            }
        }
    }

    public void visit(SetupNode node) {
        node.setupBlockNode.accept(this);
    }

    public void visit(SetupStmtNode node) {
        // SetupStmtNode is abstract
    }
    public void visit(StmtNode node){
        node.accept(this);
    }

    public void visit(StrategyDefinitionNode node) {
        if(node.runNode != null)
            node.runNode.accept(this);
        if(node.functionsNode != null)
            node.functionsNode.accept(this);
    }

    public void visit(StrategyNode node) {
        node.idNode.accept(this);
        node.strategyDefinition.accept(this);
    }

    public void visit(StructDefinitionNode node) {
        node.typeNode.accept(this);
        for(DeclarationNode declNode : node.declarationNodes) {
            declNode.accept(this);
        }
    }

    public void visit(StructInitializationNode node) {
        node.typeNode.accept(this);
        for(AssignmentNode assignmentNode : node.assignments) {
            assignmentNode.accept(this);
        }
    }
}
















