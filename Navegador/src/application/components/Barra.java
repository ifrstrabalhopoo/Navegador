package application.components;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import javax.swing.JPopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Barra extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6784811063869160099L;
	private JTextField text_URL;
	private JPopupMenu popupMenu;
	private AbaContainer parentContainer;

	
	public Barra(AbaContainer aba) {
		parentContainer = aba;
		setMaximumSize(new Dimension(32767, 50));
		setMinimumSize(new Dimension(10, 50));
		setLayout(new MigLayout("", "[55px:55px:55px,center][55px:55px:55px][55px:55px:55px][200px:n,grow,left][55px:55px:55px][55px:55px:55px]", "[45px:45px:45px]"));
		
		JButton button_Anterior = new JButton("");
		button_Anterior.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/anterior.png")));
		add(button_Anterior, "cell 0 0");
		
		JButton button_Proximo = new JButton("");
		button_Proximo.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/proximo.png")));
		add(button_Proximo, "cell 1 0");
		
		JButton button_Reload = new JButton("");
		button_Reload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadPage(text_URL.getText());
			}
		});
		button_Reload.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/reload.png")));
		add(button_Reload, "cell 2 0");
		
		text_URL = new JTextField();
		text_URL.setText("https://");
		text_URL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPage(text_URL.getText());
			}
		});
		add(text_URL, "flowx,cell 3 0,grow");
		text_URL.setColumns(10);
		
		//Botão IR
		JButton button_Ir = new JButton("");
		button_Ir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPage(text_URL.getText());
			}
		});
		button_Ir.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/proximo.png")));
		add(button_Ir, "cell 3 0");
		
		JButton button_Login = new JButton("");
		button_Login.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/finger.png")));
		add(button_Login, "cell 4 0");
		
		JButton button_Menu = new JButton("");
		button_Menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showMenu(e);
			}
		});
		
		button_Menu.setIcon(new ImageIcon(Barra.class.getResource("/application/icons/menu.png")));
		add(button_Menu, "cell 5 0");
		
		
		setupPopupMenu();
	}

	private void setupPopupMenu() {
		popupMenu = new JPopupMenu();
		JMenuItem mntmNovaAba = new JMenuItem("Nova Aba");
		popupMenu.add(mntmNovaAba);
		
		JMenuItem mntmNovaAbaAnnima = new JMenuItem("Nova Aba Anônima");
		popupMenu.add(mntmNovaAbaAnnima);
		
		JMenuItem mntmHistrico_1 = new JMenuItem("HIstórico");
		popupMenu.add(mntmHistrico_1);
		
		JMenuItem mntmFavoritos_1 = new JMenuItem("Favoritos");
		popupMenu.add(mntmFavoritos_1);
		
		
		mntmNovaAba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				parentContainer.triggerNewTab();
			}
			
		});
	}
	
	private void showMenu(MouseEvent e) {
		popupMenu.show(e.getComponent(), e.getX(), e.getY());
	}
	
	private void loadPage(String url)
	{
			parentContainer.loadPage(url);
	}
	
}
