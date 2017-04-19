import ast.ASTVisitor;
import ast.ASTVisitorException;
import ast.AssignmentStatement;
import ast.BinaryExpression;
import ast.CompUnit;
import ast.CompoundStatement;
import ast.DoubleLiteralExpression;
import ast.IdentifierExpression;
import ast.IntegerLiteralExpression;
import ast.ParenthesisExpression;
import ast.PrintStatement;
import ast.Statement;
import ast.StringLiteralExpression;
import ast.UnaryExpression;
import ast.WhileStatement;
import ast.DoWhileStatement;
import ast.IfStatement;
import ast.IfElseStatement;
import ast.ThisExpression;
import ast.NullExpression;
import ast.IdentifierExprListExpression;
import ast.Expression;
import ast.NewIdentifierExprListExpression;
import ast.DotIdentifierExpression;
import ast.DotIdentifierListExpression;
import ast.NumberType;
import ast.StringType;
import ast.VoidType;
import ast.IdentifierType;
import ast.TypeSpecifierStatement;
import ast.EqualStatement;
import ast.SemicolonStatement;
import ast.ReturnSemicolonStatement;
import ast.BreakStatement;
import ast.ContinueStatement;
import ast.TypeSpecifierIdentifierStatement;
import ast.ParameterDeclaration;
import ast.TypeFunctionDefinition;
import ast.FunctionDefinition;
import ast.FieldDefinition;

import org.apache.commons.lang3.StringEscapeUtils;

public class PrintASTVisitor implements ASTVisitor {

    @Override
    public void visit(CompUnit node) throws ASTVisitorException {
        for (Statement s : node.getStatements()) {
            s.accept(this);
        }
    }

    @Override
    public void visit(AssignmentStatement node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
        System.out.print(" = ");
        node.getExpression().accept(this);
        System.out.println(";");
    }

    @Override
    public void visit(PrintStatement node) throws ASTVisitorException {
        System.out.print("print( ");
        node.getExpression().accept(this);
        System.out.println(" );");
    }

    @Override
    public void visit(BinaryExpression node) throws ASTVisitorException {
        node.getExpression1().accept(this);
        System.out.print(" ");
        System.out.print(node.getOperator());
        System.out.print(" ");
        node.getExpression2().accept(this);
    }

    @Override
    public void visit(UnaryExpression node) throws ASTVisitorException {
        System.out.print(node.getOperator());
        System.out.print(" ");
        node.getExpression().accept(this);
    }

    @Override
    public void visit(IdentifierExpression node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
    }

    @Override
    public void visit(DoubleLiteralExpression node) throws ASTVisitorException {
        System.out.print(node.getLiteral());
    }

    @Override
    public void visit(IntegerLiteralExpression node) throws ASTVisitorException {
        System.out.print(node.getLiteral());
    }
    
    @Override
    public void visit(StringLiteralExpression node) throws ASTVisitorException {
        System.out.print("\"");
        System.out.print(StringEscapeUtils.escapeJava(node.getLiteral()));
        System.out.print("\"");
    }

    @Override
    public void visit(ParenthesisExpression node) throws ASTVisitorException {
        System.out.print("( ");
        node.getExpression().accept(this);
        System.out.print(" )");
    }

    @Override
    public void visit(CompoundStatement node) throws ASTVisitorException {
        System.out.println(" { ");
        for(Statement st: node.getStatements()) { 
            st.accept(this);
        }
        System.out.println(" } ");
    }
    
    @Override
    public void visit(WhileStatement node) throws ASTVisitorException {
        System.out.println("while ( ");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement().accept(this);
    }
    
    @Override
    public void visit(DoWhileStatement node) throws ASTVisitorException {
        System.out.println("do ");
        node.getStatement().accept(this);
        System.out.println(" while (");
        node.getExpression().accept(this);
        System.out.println(" ); ");
    }
    
    @Override
    public void visit(IfStatement node) throws ASTVisitorException {
        System.out.println("if (");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement().accept(this);
    } 
    
    @Override
    public void visit(IfElseStatement node) throws ASTVisitorException {
        System.out.println("if (");
        node.getExpression().accept(this);
        System.out.println(" ) ");
        node.getStatement1().accept(this);
        System.out.println("else");
        node.getStatement2().accept(this);
    } 
    
    @Override
    public void visit(ThisExpression node) throws ASTVisitorException {
        System.out.println("this");
    }
    
    @Override
    public void visit(NullExpression node) throws ASTVisitorException {
        System.out.println("null");
    }
    
    @Override
    public void visit(IdentifierExprListExpression node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
        System.out.print("(");
        for(Expression el: node.getExpressions()) { 
            el.accept(this);
        }
        System.out.println(")");
        
    }
    
    @Override
    public void visit(NewIdentifierExprListExpression node) throws ASTVisitorException {
        System.out.print("new");
        System.out.print(node.getIdentifier());
        System.out.print("(");
        for(Expression el: node.getExpressions()) { 
            el.accept(this);
        }
        System.out.println(")");
    }
    
    @Override
    public void visit(DotIdentifierExpression node) throws ASTVisitorException {
        node.getExpression().accept(this);
        System.out.println(".");
        System.out.print(node.getIdentifier());
    }
    
    @Override
    public void visit(DotIdentifierListExpression node) throws ASTVisitorException {
        node.getExpression().accept(this);
        System.out.println(".");
        System.out.print(node.getIdentifier());
        System.out.print("(");
        for(Expression el: node.getExpressions()) { 
            el.accept(this);
        }
        System.out.println(")");
    }
    
    @Override
    public void visit(NumberType node) throws ASTVisitorException {
        System.out.println("number");
    }
    
    @Override
    public void visit(StringType node) throws ASTVisitorException {
        System.out.println("String");
    }
    
    @Override
    public void visit(VoidType node) throws ASTVisitorException {
        System.out.println("void");
    }
    
    @Override
    public void visit(IdentifierType node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
    }
    
    @Override
    public void visit(TypeSpecifierStatement node) throws ASTVisitorException {
        System.out.print(node.getType());
        System.out.print(node.getIdentifier());
        System.out.print("=");
        node.getExpression().accept(this);
        System.out.println(";");
    }
    
    @Override
    public void visit(EqualStatement node) throws ASTVisitorException {
        node.getExpression1().accept(this);
        System.out.print("=");
        node.getExpression2().accept(this);
    }
    
    @Override
    public void visit(SemicolonStatement node) throws ASTVisitorException {
        node.getExpression().accept(this);
        System.out.print(";");
    } 
    
    @Override
    public void visit(ReturnSemicolonStatement node) throws ASTVisitorException {
        System.out.print("return");
        node.getExpression().accept(this);
        System.out.print(";");
    } 
    
    @Override
    public void visit(BreakStatement node) throws ASTVisitorException {
        System.out.print("break;");
    } 
    
    @Override
    public void visit(ContinueStatement node) throws ASTVisitorException {
        System.out.print("continue;");
    } 
    
    @Override
    public void visit(TypeSpecifierIdentifierStatement node) throws ASTVisitorException {
        System.out.print(node.getType());
        System.out.print(node.getIdentifier());
        System.out.print(";");
    } 
    
    @Override
    public void visit(ParameterDeclaration node) throws ASTVisitorException {
        System.out.print(node.getTypeSpecifier());
        System.out.print(node.getIdentifier());
    } 
    
    @Override
    public void visit(TypeFunctionDefinition node) throws ASTVisitorException {
        System.out.print(node.getType());
        System.out.print(node.getIdentifier());
        System.out.print("(");
        System.out.print(node.getParameters());
        System.out.print(")");
        node.getStatement().accept(this);
    } 
    
    @Override
    public void visit(FunctionDefinition node) throws ASTVisitorException {
        System.out.print(node.getIdentifier());
        System.out.print("(");
        System.out.print(node.getParameters());
        System.out.print(")");
        node.getStatement().accept(this);
    } 
    
    @Override
    public void visit(FieldDefinition node) throws ASTVisitorException {
        System.out.print(node.getType());
        System.out.print(node.getIdentifier());
        System.out.print(";");
    }   
}