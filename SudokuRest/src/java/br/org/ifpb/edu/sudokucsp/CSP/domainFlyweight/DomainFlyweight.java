/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author assert
 */
public interface DomainFlyweight {
    public void removeFromDomain(Integer value);
    public void addInDomain(Integer value);
    public List<Integer> getDomainFlyweight();
    public void set(Collection<Integer> values);
}
