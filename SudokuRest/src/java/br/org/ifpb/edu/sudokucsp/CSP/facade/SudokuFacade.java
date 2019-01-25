/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP.facade;

import br.org.ifpb.edu.sudokucsp.CSP.Assignment;
import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.CSP.Constants;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixBuilder;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixConcreteBuilder;
import br.org.ifpb.edu.sudokucsp.matrix.builder.MatrixDirector;
import br.org.ifpb.edu.sudokucsp.matrix.composite.Matrix3X3Composite;
import br.org.ifpb.edu.sudokucsp.matrix.composite.MatrixComponent;
import java.util.List;

/**
 *
 * @author assert
 */
public class SudokuFacade {
    private static SudokuFacade instance;
    private CSPSingleton cspReference;
    private MatrixConcreteBuilder matrixBuilder;
    private MatrixDirector matrixDirector;
    private MatrixComponent matrixComponent;
    
    private SudokuFacade(){
        this.cspReference = CSPSingleton.getInstance();
        this.cspReference.create();
        this.matrixBuilder = new MatrixConcreteBuilder();
        this.matrixDirector = new MatrixDirector(matrixBuilder);
        this.matrixDirector.construct();
        this.matrixComponent = matrixBuilder.getResult();
    }
    
    public static SudokuFacade getInstance(){
        if(SudokuFacade.instance == null){
            SudokuFacade.instance = new SudokuFacade();
        }
        return SudokuFacade.instance;
    }
    
    public void play(int node, int value){
        this.cspReference.getVariable().get(node).setValue(value);
        this.cspReference.getVariable().get(node).updateDomain(value, Constants.REMOVE);
    }
    
    public String availabeValues(int node){
        return "{\"available\":"+this.cspReference.getAvailableValuesGraph(node).toString()+"}";
    }
    
    public String getMatrix(){
        return ((Matrix3X3Composite)this.matrixComponent).getJson();
    }
    
    public void restart(){
        CSPSingleton.restart();
        this.cspReference = CSPSingleton.getInstance();
        this.cspReference.create();
        this.matrixBuilder = new MatrixConcreteBuilder();
        this.matrixDirector = new MatrixDirector(matrixBuilder);
        this.matrixDirector.construct();
        this.matrixComponent = matrixBuilder.getResult();
    }
}
