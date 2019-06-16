package parsingv2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import parsingv2.html.EnumHTMLElement;

public class ImageNode extends LeafNode {
	
	public ImageNode(String rawData, Node parent) {
		super(rawData);
		this.parent = parent;
		this.tagName = "img";
		this.tag = EnumHTMLElement.IMG;
		
	}
	
	public URL getUrl()
	{
		try {
			URL source = new URL("https://cdn.iconscout.com/icon/premium/png-256-thumb/placeholder-46-817565.png");
			return source;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public BufferedImage getImage() 
	{
		try {
			BufferedImage image = ImageIO.read(this.getUrl());
			return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
	}

	@Override
	public JComponent getRenderedComponent() 
	{
		JComponent imageLabel = new JLabel(new ImageIcon(this.getImage()));
		return imageLabel;
	}
}
