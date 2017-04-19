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
public class NewIdentifierExprListExpression extends Expression{
    
    private String identifier;
    private List<Expression> expressions;

    public NewIdentifierExprListExpression(String identifier, List<Expression> expressions) {
        this.identifier = identifier;
        this.expressions = expressions;
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
