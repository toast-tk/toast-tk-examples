package fr.synaptix.toast.examples.test.swing;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MenuSwing extends JFrame
{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Applications");
	private JMenu test2 = new JMenu("Tools");
		
	private JMenuItem item1 = new JMenuItem("Calculator");
	private JMenuItem item2 = new JMenuItem("Identification");	
	private JMenuItem item3 = new JMenuItem("Close");
	
	private Identification id = new Identification();
	private Calculator c = new Calculator();
	
	public MenuSwing()
	{
		JLabel icon = new JLabel(new ImageIcon("toast.jpg"));
		this.setTitle("Animation");
		this.setSize(250,250);
		this.setBackground(Color.white);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(icon);
		
		this.test1.add(item1);
		item3.addActionListener(new ActionListener()
				{
					public void actionPerformed (ActionEvent arg0)
					{
						System.exit(0);
					}
				});
		
		this.test1.addSeparator();
		this.test1.add(item2);
		this.test2.add(item3);
		
		this.menuBar.add(test1);
		this.menuBar.add(test2);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		item1.addActionListener(new ActionListener()
				{
					public void actionPerformed (ActionEvent arg0)
					{
						c.Calculator();
					}
				});
		
		item2.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent arg0)
			{
				id.Identification();
			}
		});
						
	}
			
	public static void main (String[] args)
	{
		MenuSwing ms = new MenuSwing();
	}


}
