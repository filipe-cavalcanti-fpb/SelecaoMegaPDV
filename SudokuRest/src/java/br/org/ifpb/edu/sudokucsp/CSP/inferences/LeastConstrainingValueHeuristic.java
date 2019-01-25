/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.inferences;

import br.org.ifpb.edu.sudokucsp.CSP.Assignment;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.List;

/**
 *
 * @author filipe
 */
public class LeastConstrainingValueHeuristic extends Heuristic{

    public LeastConstrainingValueHeuristic(Graph CSPReference, List<Assignment> assignmentReference, List<Variable> variableReference) {
        super(CSPReference, assignmentReference, variableReference);
    }

    @Override
    public boolean validate(Assignment assigment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Variable getNextVariable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
