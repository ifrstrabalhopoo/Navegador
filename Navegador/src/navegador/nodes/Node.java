/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navegador.nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author everton
 */
public class Node {
    public final String name;
    public final int index;
    public final Node parent;
    public List children = new ArrayList<Node>();
    
    
    public Node(String name, int index, Optional<Node> parent)
    {
        this.name = name;
        this.index = index;
        
        this.parent = parent.isPresent() ? parent.get() : null;
    }
    public Node(String name, int index)
    {
        this.name = name;
        this.index = index;
        
        this.parent = null;
    }
    
    public void addChild(Node child) 
    {
        this.children.add(child);
    }
    
    public List<Node> getChildren()
    {
        return this.children;
    }
    
    
}
