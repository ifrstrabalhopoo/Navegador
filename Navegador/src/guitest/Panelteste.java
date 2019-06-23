package guitest;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.net.MalformedURLException;

import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;
import webcrawler.render.BasicRender;

import javax.swing.BoxLayout;

public class Panelteste extends JPanel {
	JScrollPane scrollPane;
	JTextPane pane;
	/**
	 * Create the panel.
	 */
	public Panelteste() {
		setLayout(new BorderLayout(0, 0));
		
		init();                        
		scrollPane = new JScrollPane(pane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	private void init() {
		try {
			BasicRender render  = new BasicRender("http://edition.cnn.com/US/OJ/");
			pane = render.getPane();
			scrollPane.add(pane);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
private void createTextPane() {
	JTextPane tPane = new JTextPane();
	StyledDocument stDoc = tPane.getStyledDocument();
	
}

}
