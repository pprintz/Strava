import CompilerError.UndefinedBinaryOperationError;
import Enums.BinaryOperator;
import Enums.UnaryOperator;
import CompilerError.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {

    public Boolean programHasTypeErrors = false;

    private void TypeErrorOccured(ASTNode node) {
        programHasTypeErrors = true;
        System.out.format("[%d:%d] Type error of unknown kind.\n", node.lineNumber, node.columnNumber);
    }

    private void TypeErrorOccured(ASTNode node, Type actualType, Type expectedType) {
        programHasTypeErrors = true;
        if (actualType != Type.ERROR) {
            Main.CompileErrors.add(new TypeError(node.columnNumber, node.lineNumber, actualType.toString(), expectedType.toString()));
        }
    }

    private void TypeErrorOccured(ASTNode node, String actualTypeString, String expectedTypeString) {
        programHasTypeErrors = true;
        if(!actualTypeString.equals("ERROR")) {
            Main.CompileErrors.add(new TypeError(node.columnNumber, node.lineNumber, actualTypeString, expectedTypeString));
        }
    }

    private void TypeErrorOccured(ASTNode node, String typeOne, Type expectedType, UnaryOperator unaryOperator) {
        programHasTypeErrors = true;
        Main.CompileErrors.add(new UndefinedUnaryOperationError(node.columnNumber, node.lineNumber, typeOne, unaryOperator, expectedType.toString()));
    }

    private void TypeErrorOccured(ASTNode node, Type typeOne, Type typeTwo, Type expectedType, BinaryOperator binaryOperator) {
        programHasTypeErrors = true;
        Main.CompileErrors.add(new UndefinedBinaryOperationError(node.columnNumber, node.lineNumber,
            typeOne.toString(), typeTwo.toString(),
            binaryOperator, expectedType.toString()));
    }

    private void TypeErrorOccured(ASTNode node, Type typeOne, Type typeTwo, BinaryOperator binaryOperator,
                                  Type... expectedTypes) {
        programHasTypeErrors = true;
        List<String> expectedTypesAsStrings = new ArrayList<>();
        String[] a = new String[expectedTypes.length];
        int i = 0;
        for (Type t : expectedTypes) {
            a[i++] = t.toString();
        }

        Main.CompileErrors.add(new UndefinedBinaryOperationError(node.columnNumber, node.lineNumber,
            typeOne.toString(), typeTwo.toString(),
            binaryOperator, a));
    }

    public void visit(UnaryExprNode unaryExprNode) {
        switch (unaryExprNode.unaryOperator) {
            case PARANTHESIS:
                visit(unaryExprNode.exprNode);
                unaryExprNode.Type = unaryExprNode.exprNode.Type;
                break;
            case NEGATEBOOL:
                if (checkExpectedType(unaryExprNode, Type.BOOL)) {
                    unaryExprNode.Type = Type.BOOL;
                } else {
                    unaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(unaryExprNode, unaryExprNode.exprNode.Type.toString(), Type.BOOL, unaryExprNode.unaryOperator);
                }
                break;
            case NEGATE:
                if (checkExpectedType(unaryExprNode, Type.NUM)) {
                    unaryExprNode.Type = Type.NUM;
                } else {
                    unaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(unaryExprNode, unaryExprNode.exprNode.Type.toString(), Type.NUM, unaryExprNode.unaryOperator);
                }
                break;
            default:
                unaryExprNode.Type = Type.ERROR;
                TypeErrorOccured(unaryExprNode);
        }
    }

    public void visit(BinaryExprNode binaryExprNode) {
        visit((binaryExprNode.leftNode));
        visit((binaryExprNode.rightNode));

        switch (binaryExprNode.binaryOperator) {
            case PLUS:
                if (checkExpectedType(binaryExprNode, Type.TEXT)) {
                    binaryExprNode.Type = Type.TEXT;
                    break;
                }
            case MINUS:
            case MULTIPLY:
            case DIVISION:
            case MODULO:
            case POWER:
                if (checkExpectedType(binaryExprNode, Type.NUM)) {
                    binaryExprNode.Type = Type.NUM;
                } else {
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, binaryExprNode.binaryOperator, Type.NUM, Type.TEXT);
                }
                break;

            case GREATERTHAN:
            case LESSTHANEQUAL:
            case GREATERTHANEQUAL:
            case LESSTHAN:
                if (checkExpectedType(binaryExprNode, Type.TEXT)) {
                    binaryExprNode.Type = Type.BOOL;
                } else if (checkExpectedType(binaryExprNode, Type.NUM)) {
                    binaryExprNode.Type = Type.BOOL;
                } else {
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, binaryExprNode.binaryOperator, Type.NUM, Type.TEXT);
                }
                break;
            case AND:
            case OR:
                if (checkExpectedType(binaryExprNode, Type.BOOL)) {
                    binaryExprNode.Type = Type.BOOL;
                } else {
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, Type.BOOL, binaryExprNode.binaryOperator);
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                if (checkExpectedType(binaryExprNode, Type.BOOL)
                    || checkExpectedType(binaryExprNode, Type.NUM)) {
                    binaryExprNode.Type = Type.BOOL;
                } else if (checkExpectedType(binaryExprNode, Type.TEXT)) {
                    binaryExprNode.Type = Type.BOOL;
                } else {
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, binaryExprNode.binaryOperator, Type.NUM, Type.BOOL, Type.TEXT);
                }
                break;
            default:
                binaryExprNode.Type = Type.ERROR;
                TypeErrorOccured(binaryExprNode);
        }
    }


    public void visit(ExprFunctionCallNode node) {
        if (node.defineFunctionNode == null) {
            CompareActualToFormalParams(node, node.actualParams, null);
        } else {
            node.Type = node.defineFunctionNode.typeNode.Type;
            CompareActualToFormalParams(node, node.actualParams, node.defineFunctionNode.formalParamsNode);
        }
    }

    public void visit(FunctionCallNode node) {
        if (node.defineFunctionNode == null) {
            CompareActualToFormalParams(node, node.actualParams, null);
        } else {
            CompareActualToFormalParams(node, node.actualParams, node.defineFunctionNode.formalParamsNode);
        }
    }


    private void CompareActualToFormalParams(ASTNode node, ActualParamsNode actualParamsNode, FormalParamsNode formalParamsNode) {
        if (actualParamsNode != null && formalParamsNode != null) {
            int actualParamsCount = actualParamsNode.exprs.size();
            if (actualParamsCount == formalParamsNode.typeNodes.size()) {
                if (actualParamsCount != 0) {
                    for (int i = 0; i < actualParamsCount; i++) {
                        TypeNode currentFormalTypeNode = formalParamsNode.typeNodes.get(i);
                        ExprNode currentActualExprNode = actualParamsNode.exprs.get(i);
                        if(currentActualExprNode.Type == Type.STRUCT && currentActualExprNode instanceof IdNode){
                        }
                        TypeAndExprMatches(node, currentFormalTypeNode, currentActualExprNode);
                    }
                }
            } else {
                if (actualParamsCount != 0) {
                    actualParamsNode.exprs.forEach(this::visit);
                }
                String actualSignature = paramsTypesToString(actualParamsNode, actualParamsCount);
                String expectedSignature = paramsTypesToString(formalParamsNode, formalParamsNode.typeNodes.size());
                Main.CompileErrors.add(new ParameterMismatchError(node.columnNumber, node.lineNumber,
                    expectedSignature, actualSignature));
            }
        } else if (actualParamsNode != null || formalParamsNode != null) {
            int actualParamsCount = actualParamsNode == null ? 0 : actualParamsNode.exprs.size();
            int formalParamsCount = formalParamsNode == null ? 0 : formalParamsNode.typeNodes.size();
            if (actualParamsCount != 0) {
                actualParamsNode.exprs.forEach(this::visit);
            }
            String actualSignature = paramsTypesToString(actualParamsNode, actualParamsCount);
            String expectedSignature = paramsTypesToString(formalParamsNode, formalParamsCount);
            Main.CompileErrors.add(new ParameterMismatchError(node.columnNumber, node.lineNumber,
                expectedSignature, actualSignature));
        }
    }

    //TypeSystem GIT TEST
    private String paramsTypesToString(FormalParamsNode formalParamsNode, int count) {
        String stringRep = "(";
        if (formalParamsNode != null) {
            for (int i = 0; i < count; i++) {
                if (i == count - 1) {
                    stringRep += formalParamsNode.typeNodes.get(i).Type.toString();
                } else {
                    stringRep += formalParamsNode.typeNodes.get(i).Type.toString() + ", ";
                }
            }
        }
        stringRep += ")";
        return stringRep;
    }

    private String paramsTypesToString(ActualParamsNode actualParamsNode, int count) {
        String stringRep = "(";
        if (actualParamsNode != null) {
            for (int i = 0; i < count; i++) {
                if (i == count - 1) {
                    stringRep += actualParamsNode.exprs.get(i).Type.toString();
                } else {
                    stringRep += actualParamsNode.exprs.get(i).Type.toString() + ", ";
                }
            }
        }
        stringRep += ")";
        return stringRep;
    }

    private boolean checkExpectedType(BinaryExprNode binaryExprNode, Type expectedType) {
        if (expectedType == Type.STRUCT) {
            System.out.println("Don't call checkExpectedType with expectedType STRUCT");
            return false;
        }
        Boolean typesAreCompatible = false;

        if (binaryExprNode.leftNode.Type == expectedType && binaryExprNode.rightNode.Type == expectedType) {
            typesAreCompatible = true;
        } else if (binaryExprNode.leftNode instanceof IdNode) {
            IdNode idNode = (IdNode) binaryExprNode.leftNode;
            if (binaryExprNode.rightNode.Type == expectedType && idNode.declarationNode.Type == expectedType) {
                typesAreCompatible = true;
            }
        } else if (binaryExprNode.rightNode instanceof IdNode) {
            IdNode idNode = (IdNode) binaryExprNode.rightNode;
            if (binaryExprNode.leftNode.Type == expectedType && idNode.declarationNode.Type == expectedType) {
                typesAreCompatible = true;
            }
        }
        return typesAreCompatible;
    }

    private boolean checkExpectedType(UnaryExprNode unaryExprNode, Type expectedType) {
        if (expectedType == Type.TEXT || expectedType == Type.STRUCT) {
            System.out.println("Don't call checkExpectedType with expectedType TEXT or STRUCT");
            return false;
        }
        Boolean typesAreCompatible = false;
        String typeString = null;

        // TODO this if else needs to be handled smarter
        if (expectedType == Type.BOOL) {
            typeString = "bool";
        } else if (expectedType == Type.NUM) {
            typeString = "num";
        }
        if (unaryExprNode.exprNode.Type.equals(expectedType) && unaryExprNode.exprNode.Type.equals(expectedType)) {
            typesAreCompatible = true;
        } else if (unaryExprNode.exprNode instanceof IdNode) {
            IdNode idNode = (IdNode) unaryExprNode.exprNode;
            if (unaryExprNode.exprNode.Type.equals(expectedType) && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }

        return typesAreCompatible;
    }

    public void visit(LiteralNode node) {
    }

    public void visit(AssignmentNode node) {
        TypeAndExprMatches(node, node.idNode.declarationNode.typeNode, node.exprNode);
    }

    private Boolean TypeAndExprMatches(ASTNode node, TypeNode typeNode, ExprNode exprNode) {
        Boolean isAMatch = true;
        visit(exprNode);
        if (typeNode.Type == Type.STRUCT || exprNode.Type == Type.STRUCT) {
            String rightSideTypeString;
            if (typeNode.Type == Type.STRUCT && exprNode.Type == Type.STRUCT) {
                if (exprNode instanceof IdNode) {
                    rightSideTypeString = ((IdNode) exprNode).declarationNode.typeNode.type;
                } else {
                    rightSideTypeString = GetTypeStringOfStructInitOrFuncCall(exprNode);
                }
                if (!typeNode.type.equals(rightSideTypeString)) {
                    isAMatch = false;
                    TypeErrorOccured(node, rightSideTypeString, typeNode.type);
                }
            } else if (typeNode.Type == Type.STRUCT) {
                isAMatch = false;
                TypeErrorOccured(node, exprNode.Type.toString(), typeNode.type);
            } else {
                isAMatch = false;
                rightSideTypeString = GetTypeStringOfStructInitOrFuncCall(exprNode);
                TypeErrorOccured(node, rightSideTypeString, typeNode.Type.toString());
            }
        } else if (typeNode.Type != exprNode.Type) {
            isAMatch = false;
            TypeErrorOccured(node, exprNode.Type, typeNode.Type);
        }
        return isAMatch;
    }

    public void visit(StructInitializationNode node) {
        node.Type = Type.STRUCT;
        for (AssignmentNode assignment : node.assignments) {
            if (assignment.idNode.declarationNode != null) {
                visit(assignment);
            } // If not, there has been an error in binding, and it has already been logged
        }
    }

    public void visit(FieldValueNode node) {
        DeclarationNode declarationNode = GetLastFieldIdDecl(node.structDefinitionNode, node.idNodes);
        if (declarationNode != null) {
            node.Type = declarationNode.Type;
        } else {
            node.Type = Type.ERROR;
        }
    }

    public void visit(FieldAssignmentNode node) {
        DeclarationNode declarationNode = GetLastFieldIdDecl(node.fieldIdNode.structDefinitionNode, node.fieldIdNode.idNodes);
        if (declarationNode != null) {
            TypeAndExprMatches(node, declarationNode.typeNode, node.exprNode);
        } else {
            Main.CompileErrors.add(new UndefinedError(node.columnNumber, node.lineNumber,
                "field " + node.fieldIdNode.idNodes.
                    get(node.fieldIdNode.idNodes.size()-1).id));
        }
    }

    public void visit(IdNode node) {
        if (!node.isDeclaration) {
            node.Type = node.declarationNode.typeNode.Type;
        } else {
            node.Type = Type.ERROR;
        }
    }

    private DeclarationNode GetLastFieldIdDecl(StructDefinitionNode structDefinitionNode, List<IdNode> idNodes) {
        StructDefinitionNode currentSubStruct = structDefinitionNode;

        int nestingLevel = idNodes.size() - 1;

        for (int index = 1; index < nestingLevel; index++) {
            String currentSubField = idNodes.get(index).id;
            Boolean fieldIsValid = false;
            for (DeclarationNode declNode : currentSubStruct.declarationNodes) {
                if (declNode.idNode.id.equals(currentSubField)) {
                    currentSubStruct = declNode.structDefinitionNode;
                    fieldIsValid = true;
                    break;
                }
            }
            if (!fieldIsValid) {
                System.out.format("Field %s does not exist in the struct %s.\n", currentSubField, currentSubStruct.typeNode.type);
                return null;
            }
        }
        for (DeclarationNode declNode : currentSubStruct.declarationNodes) {
            if (declNode.idNode.id.equals(idNodes.get(nestingLevel).id)) {
                return declNode;
            }
        }
        return null;
    }


    public void visit(DeclarationNode node) {
        if (node.exprNode != null && !TypeAndExprMatches(node, node.typeNode, node.exprNode)) {
            node.Type = Type.ERROR;
            node.idNode.Type = Type.ERROR;
        } else {
            node.Type = node.typeNode.Type;
            node.idNode.Type = node.typeNode.Type;

        }
    }

    private String GetTypeStringOfStructInitOrFuncCall(ExprNode node) {
        if (node instanceof ExprFunctionCallNode) {
            return ((ExprFunctionCallNode) node).defineFunctionNode.typeNode.type;
        } else if (node instanceof StructInitializationNode) {
            return ((StructInitializationNode) node).typeNode.type;
        }
        return "ERROR";
    }

    private TypeNode currentBlockTypeNode;

    public void visit(ReturnStatementNode node) {
        TypeAndExprMatches(node, currentBlockTypeNode, node.exprNode);
    }

    public void visit(NewEventNode node) {
        currentBlockTypeNode = node.typeNode;
        super.visit(node);
    }

    public void visit(DefineFunctionNode node) {
        currentBlockTypeNode = node.typeNode;
        super.visit(node);
    }

    public void visit(IfStatementNode node) {
        visit(node.predicate);
        checkPredicate(node, node.predicate);
        super.visit(node);
    }

    public void visit(LoopNode node) { // TODO: Move to earlier
        if (node.exprNode != null) {
            visit(node.exprNode);
            checkPredicate(node, node.exprNode);
        }
        super.visit(node);
    }

    private void checkPredicate(ASTNode node, ExprNode predicate) {
        if (predicate.Type != Type.BOOL) {
            TypeErrorOccured(node, predicate.Type, Type.BOOL);
        }
    }
}
