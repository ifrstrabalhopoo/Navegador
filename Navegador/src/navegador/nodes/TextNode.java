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
public class TextNode extends LeafNode {
    public final String value;

    public TextNode(String value, int index, Optional<Node> parent) {
        super("text/content", index, parent);
        this.value = value;
    }
    
    
    @Override
    public String toString()
    {
        return this.value;
    }
}
