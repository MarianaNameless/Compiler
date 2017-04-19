package ast;

public interface ASTVisitor {

    void visit(CompUnit node) throws ASTVisitorException;

    void visit(AssignmentStatement node) throws ASTVisitorException;

    void visit(PrintStatement node) throws ASTVisitorException;

    void visit(CompoundStatement node) throws ASTVisitorException;

    void visit(BinaryExpression node) throws ASTVisitorException;

    void visit(UnaryExpression node) throws ASTVisitorException;

    void visit(IdentifierExpression node) throws ASTVisitorException;

    void visit(DoubleLiteralExpression node) throws ASTVisitorException;

    void visit(IntegerLiteralExpression node) throws ASTVisitorException;

    void visit(StringLiteralExpression node) throws ASTVisitorException;

    void visit(ParenthesisExpression node) throws ASTVisitorException;

    void visit(WhileStatement node) throws ASTVisitorException;
    
    void visit(DoWhileStatement node) throws ASTVisitorException;
    
    void visit(IfStatement node) throws ASTVisitorException;
    
    void visit(IfElseStatement node) throws ASTVisitorException;
    
    void visit(ThisExpression node) throws ASTVisitorException;
    
    void visit(NullExpression node) throws ASTVisitorException;
    
    void visit(IdentifierExprListExpression node) throws ASTVisitorException;
    
    void visit(NewIdentifierExprListExpression node) throws ASTVisitorException;
    
    void visit(DotIdentifierExpression node) throws ASTVisitorException;
    
    void visit(DotIdentifierListExpression node) throws ASTVisitorException;
    
    void visit(NumberType node) throws ASTVisitorException;
    
    void visit(StringType node) throws ASTVisitorException;
    
    void visit(VoidType node) throws ASTVisitorException;
    
    void visit(IdentifierType node) throws ASTVisitorException;
    
    void visit(TypeSpecifierStatement node) throws ASTVisitorException;
    
    void visit(EqualStatement node) throws ASTVisitorException;
    
    void visit(SemicolonStatement node) throws ASTVisitorException;
    
    void visit(ReturnSemicolonStatement node) throws ASTVisitorException;
    
    void visit(BreakStatement node) throws ASTVisitorException;
    
    void visit(ContinueStatement node) throws ASTVisitorException;
    
    void visit(TypeSpecifierIdentifierStatement node) throws ASTVisitorException;
    
    void visit(ParameterDeclaration node) throws ASTVisitorException;
    
    void visit(TypeFunctionDefinition node) throws ASTVisitorException;
    
    void visit(FunctionDefinition node) throws ASTVisitorException;
    
    void visit(FieldDefinition node) throws ASTVisitorException;
}