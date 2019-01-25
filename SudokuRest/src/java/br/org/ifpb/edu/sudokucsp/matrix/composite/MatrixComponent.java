/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.composite;

import java.util.List;

/**
 *
 * @author assert
 */
public abstract class MatrixComponent {
    
    public abstract List<Integer> getLine(int indexLine);
    
    public abstract List<Integer> getColumn(int indexColumn);
    
    public abstract Integer getItem(int lineIndex, int columnIndex);
    
    public abstract void add(List<Integer> item);
        
    public abstract void addComponent(List<MatrixComponent> component);
    
    public abstract void removeComponent(MatrixComponent component);
}
