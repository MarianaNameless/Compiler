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
public class FunctionDefinition extends Definition {
    private String identifier;
    private List<Parameter> parameters;
    private Statement statement;

    public FunctionDefinition(String identifier, List<Parameter> parameters, Statement statement) {
        this.identifier = identifier;
        this.parameters = parameters;
        this.statement = statement;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }
}
