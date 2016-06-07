package fr.synaptix.toast.examples.test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Calculator extends JDialog
{
	private JPanel container = new JPanel();
	//Liste des Ã©lÃ©ments Ã  afficher dans la calculatrice
	String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	
	//Un bouton par Ã©lÃ©ment
	
	JButton[]tab_button = new JButton [tab_string.length];
	private JLabel ecran = new JLabel();
	private Dimension dim1 = new Dimension (100,80);
	private Dimension dim2 = new Dimension (100,62);
	private double chiffre1;
	private boolean clicOperateur = false, update = false;
	private String operateur = "";
	
	public void Calculator()
	{
		this.setSize(480,520);
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocation(200,200);
		this.setResizable(false);
			initComposant();
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	private void initComposant()
	{
		Font police = new Font("Times New Roman", Font.BOLD, 20);
		ecran = new JLabel("0");
		ecran.setFont(police);
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension(440,40));
		JPanel operateur = new JPanel();
		operateur.setPreferredSize(new Dimension(110,550));
		JPanel chiffre1 = new JPanel();
		chiffre1.setPreferredSize(new Dimension (330,550));
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension (440,60));
		
		for(int i=0; i<tab_string.length; i++)
		{
			tab_button[i]= new JButton(tab_string[i]);
			tab_button[i].setPreferredSize(dim1);
			switch(i)
			{
			case 11:
				tab_button[i].addActionListener(new EgalListener());
				chiffre1.add(tab_button[i]);
				break;
			case 12 :
				tab_button[i].setForeground(Color.red);
				tab_button[i].addActionListener(new ResetListener());
				operateur.add(tab_button[i]);
				break;
			case 13 :
				tab_button[i].addActionListener(new PlusListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			case 14 :
				tab_button[i].addActionListener(new MoinsListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			case 15:
				tab_button[i].addActionListener(new MultListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			case 16 :
				tab_button[i].addActionListener(new DivListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			default:
				chiffre1.add(tab_button[i]);
				tab_button[i].addActionListener(new ChiffreListener());
				break;
			}
			panEcran.add(ecran);
			panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
			container.add(panEcran, BorderLayout.NORTH);
			container.add(chiffre1, BorderLayout.CENTER);
			container.add(operateur, BorderLayout.EAST);
		}
	}
		
		
		private void calcul()
		{
			if(operateur.equals("+"))
			{
				chiffre1 = chiffre1 +
						Double.valueOf(ecran.getText()).doubleValue();
						ecran.setText(String.valueOf(chiffre1));
			}
			if(operateur.equals("-"))
			{
				chiffre1 = chiffre1 -
						Double.valueOf(ecran.getText()).doubleValue();
						ecran.setText(String.valueOf(chiffre1));
			}
			if(operateur.equals("x"))
			{
				chiffre1 = chiffre1 *
						Double.valueOf(ecran.getText()).doubleValue();
						ecran.setText(String.valueOf(chiffre1));
			}
			if(operateur.equals("/"))
			{
				try
				{
					chiffre1 = chiffre1 /
							Double.valueOf(ecran.getText()).doubleValue();
							ecran.setText(String.valueOf(chiffre1));
				}
				catch(ArithmeticException e)
				{
				ecran.setText("0");
				}
			}
		}
		
		
		class ChiffreListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				String str = ((JButton)event.getSource()).getText();
				if(update)
				{
					update = false;
				}
				else {
					if(!ecran.getText().equals("0"));
					str = ecran.getText() + str;				
					}
				ecran.setText(str);
			}
		}
		
		class EgalListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				calcul();
				update = true;
				clicOperateur = false;
			}
		}
		
		class PlusListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				if(clicOperateur)
				{
					calcul();
					ecran.setText(String.valueOf(chiffre1));
				}
				else {
					chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
					clicOperateur = true;
				}
				operateur = "+";
				update = true;
			}
		}
		
		class MoinsListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				if(clicOperateur)
				{
					calcul();
					ecran.setText(String.valueOf(chiffre1));
				}
				else {
					chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
					clicOperateur = true;
				}
				operateur = "-";
				update = true;
			}
		}
		
		class MultListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				if(clicOperateur)
				{
					calcul();
					ecran.setText(String.valueOf(chiffre1));
				}
				else {
					chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
					clicOperateur = true;
				}
				operateur = "x";
				update = true;
			}
		}
		
		class DivListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				if(clicOperateur)
				{
					calcul();
					ecran.setText(String.valueOf(chiffre1));
				}
				else {
					chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
					clicOperateur = true;
				}
				operateur = "/";
				update = true;
			}
		}
		
		class ResetListener implements ActionListener
		{
			public void actionPerformed (ActionEvent arg0)
			{
				clicOperateur = false;
				update = true;
				chiffre1 = 0;
				operateur = "";
				ecran.setText("");
			}
		}
}