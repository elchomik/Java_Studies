
package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.text.NumberFormat.Field.INTEGER;
import static javax.management.openmbean.SimpleType.INTEGER;

public class Lab8 extends JFrame implements ActionListener,ItemListener {
    JTextField f1;
   
   Lab8(){
       super("Aplikacja laboratorium 8");
       JFrame frame=new JFrame();
       setSize(300,300);
       
       
       SpringLayout layout=new SpringLayout();
        f1=new JTextField(20);
       add(f1);
       setLayout(layout);
       
       layout.putConstraint(SpringLayout.WEST,f1,40,SpringLayout.WEST,frame);
       layout.putConstraint(SpringLayout.NORTH, f1,10,SpringLayout.NORTH,frame);
       
       JPanel p1=new JPanel();
       p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
       p1.setSize(280,30);
       
       JButton b1=new JButton("1");
       JButton b2=new JButton("2");
       JButton b3=new JButton("+");
       JButton b4=new JButton("=");
       b1.addActionListener(this);
       b2.addActionListener((ActionEvent e) -> {
           System.out.println("Wcisnięto "+((JButton)e.getSource()).getText());
           f1.setText(((JButton)e.getSource()).getText());
          
           
       });
       b3.addActionListener((ActionEvent e) -> {
           System.out.println("Wcisnieto "+ ((JButton)e.getSource()).getText());
           f1.setText(((JButton)e.getSource()).getText());
          
       });
       b4.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("Wcisnięto "+((JButton)e.getSource()).getText());
               
               int wynik=Integer.parseInt(b1.getText());
               int wynik2=Integer.parseInt(b3.getText());
               int suma=wynik+wynik2;
               f1.setText(""+suma);
           }
       });
       p1.add(b1);
       p1.add(b2);
       p1.add(b3);
       p1.add(b4);
       
       add(p1);
       //layout.putConstraint(SpringLayout.WEST, p1,10,SpringLayout.WEST,f1);
       layout.putConstraint(SpringLayout.SOUTH, p1,40,SpringLayout.SOUTH,f1);
       
       String[] tab={"1","2","3","4","5"};
       JComboBox cmb=new JComboBox(tab);
       add(cmb);
      
       layout.putConstraint(SpringLayout.SOUTH,cmb,40,SpringLayout.SOUTH,p1);
       layout.putConstraint(SpringLayout.WEST,cmb,20,SpringLayout.WEST,p1);
       getContentPane().setBackground(Color.blue);
      
       addWindowListener(new Adapter());
         cmb.addItemListener(this);
       setVisible(true);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Pozycja "+ ((JComboBox)e.getSource()).getSelectedIndex());
    }
   
  
    public class Adapter extends WindowAdapter{
       
       public void windowOpened(WindowEvent e){
           JOptionPane.showMessageDialog(null, e);      
       }
       public void windowClosed(WindowEvent e){
           System.exit(0);
       }
    }
    
    public static void main(String[] args) {
   
       Lab8 labki=new Lab8();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        
          System.out.println("Wciśnięto "+((JButton)e.getSource()).getText());
         f1.setText(((JButton)e.getSource()).getText());
        
        
    }
    
}
