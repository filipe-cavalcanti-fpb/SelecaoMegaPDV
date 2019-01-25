/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ifpb.edu.sudokucsp.matrix.builder;

import br.org.ifpb.edu.sudokucsp.CSP.Assignment;
import br.org.ifpb.edu.sudokucsp.CSP.variable.Variable;
import br.org.ifpb.edu.sudokucsp.matrix.composite.Matrix3X3Composite;
import br.org.ifpb.edu.sudokucsp.matrix.composite.MatrixComponent;
import br.org.ifpb.edu.sudokucsp.matrix.composite.Matrix3X3Leaf;
import java.util.List;


/**
 *
 * @author assert
 */
public interface MatrixBuilder {
    void buildPart();
    List<MatrixComponent> builderSubMatrix();
}
