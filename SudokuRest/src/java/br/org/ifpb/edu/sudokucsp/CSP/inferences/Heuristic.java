/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.inferences;

import br.org.ifpb.edu.sudokucsp.CSP.Assignment;
import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.List;

/**
 *
 * @author assert
 */
public abstract class Heuristic {
    protected Graph graphReference;
    protected List<Assignment> assignmentReference;
    protected List<Variable> variablesReference;
    
    public Heuristic(Graph CSPReference, List<Assignment> assignmentReference, List<Variable> variableReference){
        this.graphReference = CSPReference;
        this.assignmentReference = assignmentReference;
        this.variablesReference = variableReference;
    }
    abstract public boolean validate(Assignment assigment);
    abstract public Variable getNextVariable();
    abstract public List<Integer> getValue();
}
