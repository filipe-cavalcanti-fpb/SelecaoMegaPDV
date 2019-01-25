/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author assert
 */
public class Matrix3X3Composite extends MatrixComponent{
    private List<List<MatrixComponent>> matrix3X3Components = new ArrayList<>();
    
    @Override
    public List<Integer> getLine(int indexLine) {
        List<Integer> result = new ArrayList<>();
            for(MatrixComponent matrixItem: this.matrix3X3Components.get((int)indexLine/3)){
                result.addAll(matrixItem.getLine(indexLine%3));
            }
        return result;
    }

    @Override
    public List<Integer> getColumn(int indexColumn) {
        List<Integer> result = new ArrayList<>();
        return result;
    }

    @Override
    public Integer getItem(int lineIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(List<Integer> item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void addComponent(List<MatrixComponent> component) {
        this.matrix3X3Components.add(component);
    }

    @Override
    public void removeComponent(MatrixComponent component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix3X3Composite other = (Matrix3X3Composite) obj;
        if (!Objects.equals(this.matrix3X3Components, other.matrix3X3Components)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        String result = "";
        for(List<MatrixComponent> subMatrixs: this.matrix3X3Components){
            for(MatrixComponent matrixItem: subMatrixs){
                result += matrixItem.toString();
            }
            result += "\n";
        }
        return result;
    }
    
    public String getJson(){
        String result = "{\"result\":[";
        for(int i = 0; i < 9;i++){
            List<Integer> tempLine = this.getLine(i);
            for(int j =0;j < 9;j++){
                result += "{\"node\":"+(j+9*i)+", \"value\":"+tempLine.get(j)+"},";
            }
        }
        result = result.substring(0, result.length()-1);
        result +="]}";
        return result;
    }
}
