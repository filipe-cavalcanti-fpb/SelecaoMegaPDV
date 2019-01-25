/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.CSP;

import br.org.ifpb.edu.sudokucsp.CSP.domainFlyweight.DomainFlyweight;
import br.org.ifpb.edu.sudokucsp.CSP.inferences.Heuristic;
import br.org.ifpb.edu.sudokucsp.CSP.inferences.MinimumRemainingValueHeuristic;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.ConcreteVariable;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableConcreteCreator;
import br.org.ifpb.edu.sudokucsp.CSP.variable.factoryMethod.VariableCreator;
import br.org.ifpb.edu.sudokucsp.graph.Graph;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphBuilder;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphDirector;
import br.org.ifpb.edu.sudokucsp.graph.builder.GraphConcreteBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author assert
 */
public class CSPSingleton {
    private Random generateNode;
    private static CSPSingleton instance;
    private List<Variable> variables;
    private Graph graphReference;
    private GraphBuilder graphBuilderReference;
    private GraphDirector graphDirectorReference;
    private VariableCreator variableCriatorReference;
    private Heuristic heuristicsReference;
    private List<Assignment> assignmentReference;
    
    private CSPSingleton(){
        this.generateNode = new Random();
        this.variables = new ArrayList<>();
        this.graphBuilderReference = new GraphConcreteBuilder();
        this.graphDirectorReference = new GraphDirector(graphBuilderReference);
        this.graphDirectorReference.builder();
        this.variableCriatorReference = new VariableConcreteCreator();
        ((VariableConcreteCreator)this.variableCriatorReference).variableFactoryMethod();
        this.variables = ((VariableConcreteCreator)this.variableCriatorReference).getProduct();
        this.graphReference =((GraphConcreteBuilder)this.graphBuilderReference).getGraphReferenceProduct();
        this.assignmentReference = this.initAssignmentList();
        this.heuristicsReference = new MinimumRemainingValueHeuristic(this.graphReference, this.assignmentReference ,this.variables);
    }
    
    public static CSPSingleton getInstance(){
        if(CSPSingleton.instance == null){
            CSPSingleton.instance = new CSPSingleton();
        }
        return CSPSingleton.instance;
    }
    
    public DomainFlyweight getAvailableValues(int node){
        return ((ConcreteVariable)this.variables.get(node)).getIntersect();
    }
    
    public void setValue(int node, int value){
        this.variables.get(node).updateDomain(value, Constants.REMOVE);
    }
    
    public List<Integer> getAvailableValuesGraph(int node){
        List<Integer> allValues = this.getAllValues();
        for(Byte variable:this.graphReference.getAdjacence(node)){
            if(this.variables.get(variable).getValue() !=0){
                allValues.set(this.variables.get(variable).getValue(),0);
            }
        }
        Integer i = 0;
        while (allValues.contains(i)) {            
            allValues.remove(i);
        }
        return allValues;
    }
    
    public List<Integer> getAllValues(){
        List<Integer> allValues = new ArrayList<>();
        for(int i = 0; i <= Graph.SQRT_81;i++){
            allValues.add(i);
        }
        return allValues;
    }
    public List<Variable> getVariable(){
        return this.variables;
    }
    
    public String getJson(){
        String result = "{\"result\":[";
        for(Variable varItem: this.variables){
            result += varItem+",";
        }
        result = result.substring(0, result.length()-1);
        result +="]}";
        return result;
    }
    
    public static void restart(){
        CSPSingleton.instance = null;
        CSPSingleton.instance = CSPSingleton.getInstance();
    }
    
    public boolean backtrack(List<Assignment> assigment, int indexVariable){
        //Variable variableReference = this.variables.get(indexVariable);
        Variable variableReference = this.heuristicsReference.getNextVariable();
        for(int value=1; value <= 9; value++){
            if (this.verifyConsistency(assigment, new Assignment(variableReference, value))){
                assigment.set(variableReference.getNode(), new Assignment(variableReference, value));
                if(indexVariable == 80) throw new RuntimeException();
                if (this.backtrack(assigment, indexVariable+1)){
                    return true;
                }
                else{
                    assigment.set(variableReference.getNode(), null);
                }
            }
        }
        return false;
    }
    
    public boolean verifyConsistency(List<Assignment> assigment, Assignment assigmentTentative){
        boolean consistency = true;
        for(int variableAdjacence: this.graphReference.getAdjacence(assigmentTentative.getVariabeReference().getNode())){
            try {
                if(assigment.get(variableAdjacence).getValueAssigment() == assigmentTentative.getValueAssigment()){
                    return false;
                }
            } catch (Exception e) {
                return true;
            }
        }
        return consistency;
    }
    
    public void create(){
        this.assignmentReference.set(0,new Assignment(this.variables.get(0), 1+this.generateNode.nextInt(9)));
        try {
            this.backtrack(this.assignmentReference, 1);
        } catch (Exception e) {
            for(Assignment asItem: this.assignmentReference){
                try {
                    this.variables.get(asItem.getVariabeReference().getNode()).setValue(asItem.getValueAssigment());
                } catch (Exception error) {
                }
            }
        }
        this.RemoveValues();
    }
    
    public List<Assignment> initAssignmentList(){
        List<Assignment> result = new ArrayList<>();
        for(int i = 0; i < 81; i++){
            result.add(null);
        }
        return result;
    }
    
    private void RemoveValues(){
        for(List<Integer> subMatrix: GraphConcreteBuilder.getSubMatrixs()){
            for(int indexNode: this.generateListForRemove()){
                Variable tempVariable = this.variables.get(subMatrix.get(indexNode));
                tempVariable.updateDomain(tempVariable.getValue(), Constants.ADD);
                tempVariable.setValue(0);
            }
        }
    }
    
    private List<Integer> generateListForRemove(){
        int quant = 3 + this.generateNode.nextInt(3);
        List<Integer> result = new ArrayList<>();
        while(result.size() < quant){
            int nodeIndex = this.generateNode.nextInt(9);
            if(!result.contains(nodeIndex)){
                result.add(nodeIndex);
            }
        }
        return result;
    }
}