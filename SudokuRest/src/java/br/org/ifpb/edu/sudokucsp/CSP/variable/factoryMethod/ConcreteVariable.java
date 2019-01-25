/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainConcreteFlyweight;
import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweight;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class ConcreteVariable extends Variable{
    
    @Override
    public DomainFlyweight getIntersect() {
        List<Integer> intersect = new ArrayList<>();
        boolean contain = false;
        for(int i = 1; i <=9; i ++){
            for(DomainFlyweight domainItem: super.domains){
                if(!domainItem.getDomainFlyweight().contains(i)){
                    contain = false;
                    break;
                }
                contain = true;
            }
            if(contain){
                intersect.add(i);
            }
        }
        return new DomainConcreteFlyweight(intersect);
    }
}
