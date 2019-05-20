/*
 * Copyright (C) 2019 everton
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package navegador.parser;

import java.util.ArrayList;
import java.util.List;
import navegador.nodes.Node;

/**
 *
 * @author everton
 */
public class Document {
    private final Node root;
    private List<Node> nodes = new ArrayList<Node>();
    
    public Document(Node root) {
        this.root = root;
        this.nodes.add(root);
    }
    
    public void addNode(Node node)
    {
        this.nodes.add(node);
    }
    
    public Node findNodeByIndex(int index)
    {
        return nodes.get(index);
    }
    
    public Node getRoot()
    {
        return this.root;
    }
    
}
