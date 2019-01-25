/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.builder;

/**
 *
 * @author assert
 */
public class MatrixDirector {
    private MatrixBuilder matrixCreator;
    
    public MatrixDirector(MatrixBuilder matrixCreator){
        this.matrixCreator = matrixCreator;
    }
    
    public void construct(){
        this.matrixCreator.buildPart();
    }
    
}
