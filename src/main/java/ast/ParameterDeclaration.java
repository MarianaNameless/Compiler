/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author mariana
 */
public class ParameterDeclaration extends Parameter{
    private Type typeSpecifier;
    private String identifier;

    public ParameterDeclaration(Type typeSpecifier, String identifier) {
        this.typeSpecifier = typeSpecifier;
        this.identifier = identifier;
    }

    public Type getTypeSpecifier() {
        return typeSpecifier;
    }

    public void setTypeSpecifier(Type typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    @Override
    public void accept(ASTVisitor visitor) throws ASTVisitorException {
        visitor.visit(this);
    }
}
