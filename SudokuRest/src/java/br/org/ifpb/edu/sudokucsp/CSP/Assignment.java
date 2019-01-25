/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;

/**
 *
 * @author assert
 */
public class Assignment {
    private Variable variabeReference;
    private int valueAssigment;
    
    public Assignment(Variable varItem, int value){
        this.variabeReference = varItem;
        this.valueAssigment = value;
    }

    public Variable getVariabeReference() {
        return variabeReference;
    }

    public int getValueAssigment() {
        return valueAssigment;
    }
    
    public String toString(){
        String result = "";
        result = "{"+this.variabeReference.getNode()+", "+this.valueAssigment+"}";
        return result;
    }
    
}
