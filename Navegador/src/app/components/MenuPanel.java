package app.components;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6330356669730020594L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setSize(new Dimension(800, 40));
		setMinimumSize(new Dimension(800, 50));
		setLayout(new MigLayout("", "[44:n:44px][44px:n][44px:n][400:400,grow,center][44px:n][44px:n][44px:n][44px:n][44px:n][44px:n][44px:n]", "[50px]"));
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setMinimumSize(new Dimension(30, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton, "cell 0 0");
		
		JButton button = new JButton("<");
		button.setMinimumSize(new Dimension(30, 30));
		add(button, "cell 1 0");
		
		JButton button_1 = new JButton("<");
		button_1.setMinimumSize(new Dimension(30, 30));
		add(button_1, "cell 2 0");
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(380, 30));
		add(textField, "cell 3 0 2 1,growx");
		textField.setColumns(10);

	}

}
