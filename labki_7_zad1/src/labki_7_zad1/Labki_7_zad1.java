
package labki_7_zad1;

import static java.awt.BorderLayout.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
public class Labki_7_zad1 {

   
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        JButton b1=new JButton();
        JButton b2=new JButton();
        JButton b3=new JButton();
        JButton b4=new JButton();
        JButton b5=new JButton();
        JButton b6=new JButton();
        JButton b7=new JButton();
        JButton b8=new JButton();
        JButton b9=new JButton();
        JButton b10=new JButton();
        
        b1.setText("b1");
        b2.setText("b2");
        b3.setText("b3");
        b4.setText("b4");
        b5.setText("b5");
        b6.setText("b6");
        b7.setText("b7");
        b8.setText("b8");
        b9.setText("b9");
        b10.setText("b10");
        frame.getContentPane();
   
        frame.add(b1,CENTER);
        frame.add(b2,NORTH);
        frame.add(b3,WEST);
        frame.add(b4,EAST);
        frame.add(b5,NORTH);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b10);
        
        frame.setSize(300,300);
        frame.setLayout(new GridLayout(2,4));
     
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       
        
    }
    
}
