/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.builder;

import br.org.ifpb.edu.sudokucsp.CSP.CSPSingleton;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.matrix.composite.Matrix3X3Composite;
import br.org.ifpb.edu.sudokucsp.matrix.composite.MatrixComponent;
import br.org.ifpb.edu.sudokucsp.matrix.composite.Matrix3X3Leaf;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author assert
 */
public class MatrixConcreteBuilder implements MatrixBuilder{
    private MatrixComponent matrixComponentProduct;
    private CSPSingleton cspInstance;
    
    public MatrixConcreteBuilder(){
        this.matrixComponentProduct = new Matrix3X3Composite();
        this.cspInstance = CSPSingleton.getInstance();
    }
    
    @Override
    public void buildPart() {
        this.cspInstance = CSPSingleton.getInstance();
        int index = 0;
        List<MatrixComponent> tempLine = new ArrayList<>();
        for(MatrixComponent matrixItem: this.builderSubMatrix()){
            tempLine.add(matrixItem);
            if(tempLine.size() == 3){
                this.matrixComponentProduct.addComponent(tempLine);
                tempLine = new ArrayList<>();
            }
        }
    }

    @Override
    public List<MatrixComponent> builderSubMatrix() {
        this.cspInstance = CSPSingleton.getInstance();
        List<MatrixComponent> subMatrixsList = new ArrayList<>();
        for(List<Integer> subMatrixItem: GraphConcreteBuilder.getSubMatrixs()){
            MatrixComponent tempMatrix = new Matrix3X3Leaf();
            List<Integer> tempValuesVariable = new ArrayList<>();
            int valuesIndex = 0;
            while(valuesIndex < 9){
                tempValuesVariable.add(this.cspInstance.getVariable().get(subMatrixItem.get(valuesIndex)).getValue());
                valuesIndex ++;
                if(tempValuesVariable.size() == 3){
                    tempMatrix.add(tempValuesVariable);
                    tempValuesVariable = new ArrayList<>();
                }
            }
            subMatrixsList.add(tempMatrix);
        }
        return subMatrixsList;
    }
    
    public MatrixComponent getResult(){
        return this.matrixComponentProduct;
    }
}
