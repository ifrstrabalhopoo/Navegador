package parsingv2;

import javax.swing.JComponent;

public abstract class LeafNode extends Node {
	public LeafNode(String rawData) {
		super(rawData);
	}
	
	
	/**
	 * Deve retornar o elemento que será mostrado na tela
	 *  ex:
	 * 	public JComponent getRenderElement()
	 *	{
	 *		//TODO: retornar um elemento de render
	 *		JLabel exampleLabel = new JLabel("asd");
	 *		return exampleLabel;
	 *	}
	 * @return Componente 
	 */
	public abstract JComponent getRenderedComponent();
}
