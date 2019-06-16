package parsingv2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class WindowRunTest {

	private JFrame frame;
	JPanel panel = new JPanel();

	/**
	 * Create the application.
	 */
	public WindowRunTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
	
	public JPanel getPanel() 
	{
		return this.panel;
	}

}
