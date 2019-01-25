/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.graph.builder;

import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphBuilder;
/**
 *
 * @author assert
 */
public class GraphDirector {
    private GraphBuilder graphBuilderReference;
    
    public GraphDirector(GraphBuilder graphBuilderReference){
        this.graphBuilderReference = graphBuilderReference;
    }
    
    public void builder(){
        this.graphBuilderReference.constructEdgeColumn();
        this.graphBuilderReference.constructEdgeLine();
        //this.graphBuilderReference.constructEdgePrimaryDiagonal();
        //this.graphBuilderReference.constructEdgeSecondDiagonal();
        this.graphBuilderReference.constructEdgeSubMatrix();
    }
}
