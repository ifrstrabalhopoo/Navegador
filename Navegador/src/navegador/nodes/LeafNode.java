/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navegador.nodes;

import java.util.Optional;

/**
 *
 * @author everton
 */
public class LeafNode extends Node{
    
    public LeafNode(String name, int index, Optional<Node> parent) {
        super(name, index, parent);
    }
    
}
