/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweightFactory;
import java.util.List;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.ArrayList;

/**
 *
 * @author assert
 */
public class VariableConcreteCreator  extends VariableCreator{
    private DomainFlyweightFactory domainFctory;
    private List<Variable> variabablesReference;
    
    public VariableConcreteCreator(){
        this.variabablesReference = new ArrayList<>();
        this.domainFctory = new DomainFlyweightFactory();
    }
    
    @Override
    public void variableFactoryMethod() {
        int node = 0;
        for(int i = 0; i < Graph.SIZE; i++){
            this.variabablesReference.add(new ConcreteVariable());
        }
        for (Variable varItem : this.variabablesReference) {
            varItem.setSubMatrixIndex(Graph.getIndexSubMatrix(node));
            varItem.setPoint(Graph.converter(node));
            varItem.setNode(node);
            varItem.setDomains(this.domainFctory.getAllDomains(node));
            node++;
        }
    }
    
    @Override
    public List<Variable> getProduct(){
        return this.variabablesReference;
    }
}
