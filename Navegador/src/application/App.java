package application;

import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;

import com.alee.laf.WebLookAndFeel;

import application.components.AbaContainer;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class App {

	private JFrame frmNavV;
	private AbaContainer aba;
	JTabbedPane tabs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();
					App window = new App();
					window.frmNavV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initCustom();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNavV = new JFrame();
		frmNavV.setTitle("Nav v0.000000000001");
		frmNavV.setBounds(100, 100, 450, 300);
		frmNavV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNavV.setExtendedState(frmNavV.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frmNavV.getContentPane().setLayout(new BorderLayout(0, 0));
		frmNavV.getContentPane().add(tabs, BorderLayout.CENTER);
		
		
		tabs.addTab(aba.getTitle(), aba);
		int tabIndex = tabs.getSelectedIndex();
		aba.setIndex(tabIndex);
		
		//frame.getContentPane().add(aba, "cell 0 0,grow");
		
	}

	private void initCustom()
	{
		tabs = new JTabbedPane(JTabbedPane.TOP);
		aba = new AbaContainer(this);
	}
	public void setTabTitle(int index, String title)
	{
		tabs.setTitleAt(index, title);
	}
	public void newTab() 
	{
		AbaContainer abaz = new AbaContainer(this);
		tabs.add("Nova aba", abaz);
		abaz.setIndex(tabs.getSelectedIndex());
		tabs.setSelectedComponent(abaz);
	}
}