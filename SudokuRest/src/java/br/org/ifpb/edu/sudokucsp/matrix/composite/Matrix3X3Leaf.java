/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 * @param <Integer>
 */
public class Matrix3X3Leaf extends MatrixComponent{
    private List<List<Integer>> matrix3X3Reference;
    
    public Matrix3X3Leaf(){
        this.matrix3X3Reference = new ArrayList<>();
    }
    
    /**
     * 
     * @param indexLine
     * @return 
     */
    @Override
    public List<Integer> getLine(int indexLine){
        return this.matrix3X3Reference.get(indexLine);
    }
    /**
     * 
     * @param indexColumn
     * @return 
     */
    @Override
    public List<Integer> getColumn(int indexColumn){
        List<Integer> result = new ArrayList<>();
        return result;
    }
    
    /**
     * 
     * @param lineIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Integer getItem(int lineIndex, int columnIndex){
        return this.matrix3X3Reference.get(lineIndex).get(columnIndex);
    }
    /**
     * 
     * @param item 
     */
    @Override
    public void add(List<Integer> item) {
        this.matrix3X3Reference.add(item);
    }

    @Override
    public void addComponent(List<MatrixComponent> component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeComponent(MatrixComponent component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String result = "";
        for(List<Integer> lineItem:this.matrix3X3Reference){
            result += lineItem.toString()+"\n";
        }
        return result;
    }
}
