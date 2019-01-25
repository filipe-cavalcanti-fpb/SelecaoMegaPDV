/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight;

import br.org.ifpb.edu.sudokucsp.graph.Graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author assert
 */
public class DomainConcreteFlyweight implements DomainFlyweight{
    private List<Integer> poolValues;
    
    public DomainConcreteFlyweight(){
        this.poolValues = new ArrayList<>();
        for(int value = 1; value <= Graph.SQRT_81; value++){
            this.poolValues.add(value);
        }
    }
    
    public DomainConcreteFlyweight(Collection<Integer> intersect){
        this.poolValues = new ArrayList<>(intersect);
    }

    @Override
    public void removeFromDomain(Integer value) {
        this.poolValues.remove(value);
    }

    @Override
    public List<Integer> getDomainFlyweight() {
        return this.poolValues;
    }
    
    @Override
    public String toString(){
        return this.poolValues.toString();
    }

    @Override
    public void set(Collection<Integer> values) {
        this.poolValues = new ArrayList<>(values);
    }

    @Override
    public void addInDomain(Integer value) {
        this.poolValues.add(value);
    }
    
}
