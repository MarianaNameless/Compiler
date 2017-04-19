/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.List;

/**
 *
 * @author mariana
 */
public class DotIdentifierListExpression extends Expression {
     private Expression expression;
     private String identifier;
     private List<Expression> expressions;

    public DotIdentifierListExpression(Expression expression, String identifier, List<Expression> expressions) {
        this.expression = expression;
        this.identifier = identifier;
        this.expressions = expressions;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }
     
    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    } 
     
}
