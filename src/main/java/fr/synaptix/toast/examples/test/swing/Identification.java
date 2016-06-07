package fr.synaptix.toast.examples.test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Identification extends JDialog {
	private JButton bouton = new JButton("Go To Identification");


public void Identification(){      
  this.setTitle("Identification");
  this.setSize(300, 100);
  this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  this.setLocationRelativeTo(null);      
  this.getContentPane().setLayout(new FlowLayout());
  this.getContentPane().add(bouton);
  bouton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
  	Perso per = new Perso(null, "Informations", true);
      OptionsPerso oper = per.showPerso(); 
      JOptionPane jop = new JOptionPane();
      jop.showMessageDialog(null, oper.toString(), "Informations", JOptionPane.INFORMATION_MESSAGE);
    }         
  });      
  this.setVisible(true);      
}

public class OptionsPerso {
	  private String name, gender, age, hair, size;

	  public OptionsPerso(){}
	  public OptionsPerso(String name, String gender, String age, String hair, String size){
	    this.name = name;
	    this.gender = gender;
	    this.age = age;
	    this.hair = hair;
	    this.size = size;
	  }

	  public String toString(){
	    String str;
	    if(this.name != null && this.gender != null && this.size != null && this.age != null && this.hair != null){
	      str = "Resume : \n";
	      str += "Name : " + this.name + "\n";
	      str += "Gender : " + this.gender + "\n";
	      str += "Age : " + this.age + "\n";
	      str += "Hair : " + this.hair + "\n";
	      str += "Size : " + this.size + "\n";
	      
	    }
	    else{
	      str = "Informations are not completed";
	    }
	    return str;
	  }
	}

public class Perso extends JDialog {
	  private OptionsPerso zInfo = new OptionsPerso();
	  private boolean sendData;
	  private JLabel nameLabel, genderLabel, hairLabel, ageLabel, sizeLabel, size2Label, icon;
	  private JRadioButton age1, age2, age3, age4;
	  private JComboBox gender, hair;
	  private JTextField name, size;

	  public Perso(JFrame parent, String title, boolean modal){
	    super(parent, title, modal);
	    this.setBackground(Color.white);
	    this.setSize(730, 300);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    this.initComponent();
	  }


	public OptionsPerso showPerso(){
	    this.sendData = false;
	    this.setVisible(true);      
	    return this.zInfo;      
	  }

	  private void initComponent(){
	    //Icône
	    JLabel icon = new JLabel(new ImageIcon("agent.jpg"));
	    JPanel panIcon = new JPanel();
	    panIcon.setBackground(Color.white);
	    panIcon.setPreferredSize(new Dimension (180,240));
	    panIcon.setLayout(new BorderLayout());
	    panIcon.add(icon);
	    

	    //Le nom
	    JPanel panName = new JPanel();
	    panName.setBackground(Color.white);
	    panName.setPreferredSize(new Dimension(220, 60));
	    name = new JTextField();
	    name.setPreferredSize(new Dimension(100, 25));
	    panName.setBorder(BorderFactory.createTitledBorder("Name"));
	    nameLabel = new JLabel("Enter your name :");
	    panName.add(nameLabel);
	    panName.add(name);

	    //Le sexe
	    JPanel panGender = new JPanel();
	    panGender.setBackground(Color.white);
	    panGender.setPreferredSize(new Dimension(220, 60));
	    panGender.setBorder(BorderFactory.createTitledBorder("Gender"));
	    gender = new JComboBox();
	    gender.addItem(null);
	    gender.addItem("Male");
	    gender.addItem("Female");
	    genderLabel = new JLabel("Gender : ");
	    panGender.add(genderLabel);
	    panGender.add(gender);

	    //L'Ã¢ge 
	    JPanel panAge = new JPanel();
	    panAge.setBackground(Color.white);
	    panAge.setBorder(BorderFactory.createTitledBorder("Age"));
	    panAge.setPreferredSize(new Dimension(440, 60));
	    age1 = new JRadioButton("15 - 25 years");
	    age2 = new JRadioButton("26 - 35 years");
	    age3 = new JRadioButton("36 - 50 years");
	    age4 = new JRadioButton("+ de 50 years");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(age1);
	    bg.add(age2);
	    bg.add(age3);
	    bg.add(age4);
	    panAge.add(age1);
	    panAge.add(age2);
	    panAge.add(age3);
	    panAge.add(age4);

	    //La taille
	    JPanel panSize = new JPanel();
	    panSize.setBackground(Color.white);
	    panSize.setPreferredSize(new Dimension(220, 60));
	    panSize.setBorder(BorderFactory.createTitledBorder("Size"));
	    sizeLabel = new JLabel("Size : ");
	    size2Label = new JLabel(" cm");
	    size = new JTextField(null);
	    size.setPreferredSize(new Dimension(90, 25));
	    panSize.add(sizeLabel);
	    panSize.add(size);
	    panSize.add(size2Label); 

	    //La couleur des cheveux
	    JPanel panHair = new JPanel();
	    panHair.setBackground(Color.white);
	    panHair.setPreferredSize(new Dimension(220, 60));
	    panHair.setBorder(BorderFactory.createTitledBorder("Hair Color"));
	    hair = new JComboBox();
	    hair.addItem(null);
	    hair.addItem("Blond");
	    hair.addItem("Dark");
	    hair.addItem("Redhead");
	    hair.addItem("White");
	    hair.addItem("Bold");
	    hairLabel = new JLabel("Hair");
	    panHair.add(hairLabel);
	    panHair.add(hair);

	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panName);
	    content.add(panGender);
	    content.add(panAge);
	    content.add(panSize);
	    content.add(panHair);

	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
	        zInfo = new OptionsPerso(name.getText(), (String)gender.getSelectedItem(), getAge(), (String)hair.getSelectedItem() ,getTaille());
	        setVisible(false);
	      }

	      public String getAge(){
	        return (age1.isSelected()) ? age1.getText() : 
	               (age2.isSelected()) ? age2.getText() : 
	               (age3.isSelected()) ? age3.getText() : 
	               (age4.isSelected()) ? age4.getText() : 
	                age1.getText();  
	      }

	      public String getTaille(){
	        return (size.getText().equals("")) ? "180" : size.getText();
	      }      
	    });

	    JButton boutonAnnuler = new JButton("Cancel");
	    boutonAnnuler.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      
	    });

	    control.add(okBouton);
	    control.add(boutonAnnuler);

	    this.getContentPane().add(panIcon, BorderLayout.WEST);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	  }  
	}
}