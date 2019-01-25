/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight;

import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import java.util.ArrayList;
import java.util.List;
import br.org.ifpb.edu.sudokucsp.graph.Graph;

/**
 *
 * @author assert
 */
public class DomainFlyweightFactory {
    private List<DomainFlyweight> poolFlyweightsLine;
    private List<DomainFlyweight> poolFlyweightsColumn;
    private List<DomainFlyweight> poolFlyweightsSubMatrix;
    private DomainFlyweight poolFlyweightsPrimaryDiagonal;
    private DomainFlyweight poolFlyweightsSecondDiagonal;
    
    public DomainFlyweightFactory(){
        this.poolFlyweightsLine = new ArrayList<>();
        this.poolFlyweightsColumn = new ArrayList<>();
        this.poolFlyweightsSubMatrix = new ArrayList<>();
        this.poolFlyweightsPrimaryDiagonal = new DomainConcreteFlyweight();
        this.poolFlyweightsSecondDiagonal = new DomainConcreteFlyweight();
        for(int index = 0; index < Graph.SQRT_81;index++){
            this.poolFlyweightsLine.add(new DomainConcreteFlyweight());
            this.poolFlyweightsColumn.add(new DomainConcreteFlyweight());
            this.poolFlyweightsSubMatrix.add(new DomainConcreteFlyweight());
        }
    }
    
    /**
     * getAllDomains retorna uma lista com todos os dominios da variavel passada
     * por parametro (node), linha, coluna, diagonal primaria, diagonal secundaria
     * @param node variavel que deseja seus dominios
     * @return uma lista com os dominios da variavel node
     */
    public List<DomainFlyweight> getAllDomains(int node){
        List<DomainFlyweight> domains = new ArrayList<>();
        domains.add(this.getDomainLineFlyweight(node));
        domains.add(this.getDomainColumnFlyweight(node));
        domains.add(this.getDomainSubMatrix(node));
        try { 
            //domains.add(this.getDomainPrimaryDiagonalFlyweight(node));
        } catch (NullPointerException e) {
        }
        try {
            //domains.add(this.getDomainSecondDiagonalFlyweight(node));
        } catch (NullPointerException e) {
        }
        return domains;
    }
    
    /**
     * retorna o dominio compartilhado dos elementos na mesma linha da matriz
     * @param node nó referência
     * @return retorna uma referẽncia de um dominio 
     */
    private DomainFlyweight getDomainLineFlyweight(int node){
        int result = (int)node/Graph.SQRT_81;
        return this.poolFlyweightsLine.get((int)node/Graph.SQRT_81);
    }
    
    private DomainFlyweight getDomainColumnFlyweight(int node){
        int result = node%Graph.SQRT_81;
        return this.poolFlyweightsColumn.get(node%Graph.SQRT_81);
    }
    
    /**
     * 
     * @param node
     * @return
     * @throws NullPointerException 
     */
    private DomainFlyweight getDomainPrimaryDiagonalFlyweight(int node) throws NullPointerException{
        if(node%Graph.MULT_PRIMARY_DIAGONAL==0){
            return this.poolFlyweightsPrimaryDiagonal;
        }
        else{
            throw new NullPointerException();
        }
    }
    
    /**
     * 
     * @param node
     * @return
     * @throws NullPointerException 
     */
    private DomainFlyweight getDomainSecondDiagonalFlyweight(int node)throws NullPointerException{
        if(node%(Graph.MULT_SECOND_DIAGONAL) == 0){
            return this.poolFlyweightsSecondDiagonal;
        }
        else{
            throw new NullPointerException();
        }
    }
    
    private DomainFlyweight getDomainSubMatrix(int node){
        return this.poolFlyweightsSubMatrix.get(Graph.getIndexSubMatrix(node));
    }
}
