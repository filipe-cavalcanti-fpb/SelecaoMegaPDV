/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import java.util.List;

/**
 *
 * @author assert
 */
public abstract class VariableCreator {
    protected List<Variable> variableProduct;
    
    abstract void variableFactoryMethod();
    
    public List<Variable> getProduct(){
        return this.variableProduct;
    }
}
