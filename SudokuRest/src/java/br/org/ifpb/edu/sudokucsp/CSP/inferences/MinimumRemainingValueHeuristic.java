/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.inferences;

import br.org.ifpb.edu.sudokucsp.CSP.Assignment;
import br.org.ifpb.edu.sudokucsp.CSP.Constants;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.ConcreteVariable;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.List;

/**
 *
 * @author filipe
 */
public class MinimumRemainingValueHeuristic extends Heuristic{

    public MinimumRemainingValueHeuristic(Graph CSPReference, List<Assignment> assignmentReference, List<Variable> variableReference) {
        super(CSPReference, assignmentReference, variableReference);
    }

    @Override
    public boolean validate(Assignment assigment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Variable getNextVariable() {
        int generalNumberOfRestriction = -1;
        Variable nextVariable = null;
        for(int i = this.getUnAssignmentVariable().getNode(); i < 81;i++){
            int tempNumberOfRestriction = this.getNumberOfRestriction(this.variablesReference.get(i).getNode());
            if(tempNumberOfRestriction > generalNumberOfRestriction){
                generalNumberOfRestriction = tempNumberOfRestriction;
                nextVariable = this.variablesReference.get(i);
            }
        }
        return nextVariable;
    }

    @Override
    public List<Integer> getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int getNumberOfRestriction(int node){
        int numberRestriction = 0;
        for(int adjacenceNode: this.graphReference.getAdjacence(node)){
            try {
                if(this.assignmentReference.get(adjacenceNode).getValueAssigment()!= 0){
                    numberRestriction ++;
                }
            } catch (Exception e) {
            }
        }
        return numberRestriction;
    }
    
    private Variable getUnAssignmentVariable(){
        for(int i = 0; i < 81;i++){
            try {
                if(this.assignmentReference.get(i).getValueAssigment() == Constants.UNASSIGNMENT_VARIABLE){
                    return this.assignmentReference.get(i).getVariabeReference();
                }
            } catch (Exception e) {
                return this.variablesReference.get(i);
            }
        }
        throw new RuntimeException("não há variável sem atribuição");
    }
}
