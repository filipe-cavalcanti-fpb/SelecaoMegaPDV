/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author assert
 */
public class Graph {
    public static final int SIZE = 81;
    public static final int SQRT_81 = 9;
    public static final int SQRT_9 = 3;
    public static final int MULT_PRIMARY_DIAGONAL = 10;
    public static final int MULT_SECOND_DIAGONAL = 8;
    private static final int LINK = 10;
    public static final int SUB_DIAGONAL_LIMIT = 20;
    public static final int[] SUP_DIAGONAL = {0,3,6,27,30,33,54,57,60};
    private List<List<Byte>> adjacenceMatrix;
    
    public Graph(){
        this.adjacenceMatrix = new ArrayList<>();
        this.constructLine();
        this.constructColunm();
    }
    
    private void constructLine(){
        for(int i =0;i < Graph.SIZE; i++){
            this.adjacenceMatrix.add(new ArrayList<>());
        }
    }
    
    private void constructColunm(){
        for(int i = 0;i < Graph.SIZE; i++){
            for(int j = 0; j < Graph.SIZE; j++){
                this.adjacenceMatrix.get(i).add((byte)0);
            }
        }
    }
    
    public void setEdge(int lineIndex, int columnIndex){
        this.adjacenceMatrix.get(lineIndex).set(columnIndex, (byte)Graph.LINK);
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i =0; i < Graph.SIZE; i ++ ){
            for(int j =0; j < Graph.SIZE; j ++ ){
                str+=this.adjacenceMatrix.get(i).get(j)+",";
            }
            str+="\n";
        }
        return str;
    }
    
    public List<Byte> getAdjacence(int nodeIndex){
        List<Byte> result = new ArrayList<>();
            for(int j = 0; j < Graph.SIZE;j ++ ){
                if(this.adjacenceMatrix.get(nodeIndex).get(j) == Graph.LINK){
                    result.add((byte)j);
                }
                if(this.adjacenceMatrix.get(j).get(nodeIndex) == Graph.LINK){
                    if(!result.contains((byte)j)){
                        result.add((byte)(j));
                    }
                }
            }
        return result;
    }
    
    public void setCompletEdge(List<Integer> nodes){
        for(int i = 0; i < nodes.size();i++){
            for(int j = i+1; j < nodes.size();j++){
                this.adjacenceMatrix.get(nodes.get(i)).set(nodes.get(j),(byte)Graph.LINK);
            }
        }
    }
    
    public static List<Integer> converter(int node){
        List<Integer> coordenate = new ArrayList<>();
        coordenate.add(node/9);
        coordenate.add(node%9);
        return coordenate;
    }
    
    public static int getIndexSubMatrix(int node){
        int subMatrixIndex = 0;
        List<Integer> nodeIndex = Graph.converter(node);
        List<Integer> pointReference;
        for(int nodeSubDiagonal:Graph.SUP_DIAGONAL){
            pointReference = Graph.converter(nodeSubDiagonal);
            if((nodeIndex.get(0)>= pointReference.get(0) && nodeIndex.get(0) <= pointReference.get(0)+2) && 
                    (nodeIndex.get(1) >= pointReference.get(1) && nodeIndex.get(1) <= pointReference.get(1)+2)){
                return subMatrixIndex;
            }
            subMatrixIndex++;
        }
        return subMatrixIndex;
    }
    
    public List<Integer> getAdjacenceLine(int node){
        List<Integer> result = new ArrayList<>();
        int lineIndex = (int)node/Graph.SQRT_81;
        for(int i = lineIndex*Graph.SQRT_81; i < Graph.SQRT_81+lineIndex*Graph.SQRT_81; i++){
            if(i != node){
                result.add(i);
            }
        }
        return result;
    }
    
    public List<Integer> getAdjacenceColumn(int node){
        return new ArrayList<>();
    }
}