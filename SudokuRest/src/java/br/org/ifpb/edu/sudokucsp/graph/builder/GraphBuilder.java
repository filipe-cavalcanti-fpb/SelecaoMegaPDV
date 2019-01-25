/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.graph.builder;

/**
 *
 * @author assert
 */
public interface GraphBuilder {
    public void constructEdgeLine();
    public void constructEdgeColumn();
    public void constructEdgePrimaryDiagonal();
    public void constructEdgeSecondDiagonal();
    public void constructEdgeSubMatrix();
}
