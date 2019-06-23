package guitest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import webcrawler.render.BasicRender;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class TesteFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane pane;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteFrame frame = new TesteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		init();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void init() {
		try {
			BasicRender render  = new BasicRender("http://www.java2s.com/Questions_And_Answers/Swing/JTextPane/HyperLink.htm");
			pane = render.getPane();
			scrollPane = new JScrollPane(pane);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
