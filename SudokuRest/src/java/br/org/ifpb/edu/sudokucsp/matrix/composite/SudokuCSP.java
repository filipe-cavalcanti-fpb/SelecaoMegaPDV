/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.composite;
import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.*;
import br.org.ifpb.edu.sudokucsp.CSP.facade.SudokuFacade;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.ConcreteVariable;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixBuilder;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixConcreteBuilder;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixDirector;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author assert
 */
public class SudokuCSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CSPSingleton cs = CSPSingleton.getInstance();
        cs.create();
        MatrixComponent result;
        MatrixBuilder builder = new MatrixConcreteBuilder();
        MatrixDirector director = new MatrixDirector(builder);
        director.construct();
        result = ((MatrixConcreteBuilder)builder).getResult();
        System.err.println(((Matrix3X3Composite)result).getJson());
    }
    
}
