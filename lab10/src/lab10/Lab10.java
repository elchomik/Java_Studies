
package lab10;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.*;
import javax.swing.*;

public class Lab10 extends JFrame {
    JButton b1,b2;
    JEditorPane a1;
    
    Lab10()
    {
        setSize(300,300);
        SpringLayout layout=new SpringLayout();
        setLayout(layout);
        JFrame frame=new JFrame();
        
        b1=new JButton("Open");
        b2=new JButton("Save");
        a1=new JEditorPane();
        layout.putConstraint(SpringLayout.WEST,a1,40,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,a1,220,SpringLayout.SOUTH,frame);
        layout.putConstraint(SpringLayout.WEST, b1,40,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b1,30,SpringLayout.SOUTH,a1);
        layout.putConstraint(SpringLayout.WEST,b2,180,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH, b2,30,SpringLayout.SOUTH,a1);
        
        add(a1);
        add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JFileChooser fc=new JFileChooser();
             if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                 File file=fc.getSelectedFile();
                 String path=file.getAbsolutePath();
                 
                 try{
                     String line;
                     String tekst="";
                     BufferedReader br=new BufferedReader(new FileReader(path));
                     while((line=br.readLine())!=null){
                         tekst+=line;
                     }
                     a1.setText(tekst);
                 }catch(IOException ex){
                     JOptionPane.showMessageDialog(null,"Błąd przy odczycie pliku");
                 }
             }
            }
        });
        add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    File file=fc.getSelectedFile();
                    String path=file.getAbsolutePath();
                
                try{
                BufferedWriter wr=new BufferedWriter(new FileWriter(path));
                wr.write(a1.getText());
                wr.close();
               
            }catch(IOException ex){
                ex.getMessage();
            }
            }
            }
        });
        a1.setPreferredSize(new Dimension(200,200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    public static void main(String[] args) {
      Lab10 lab=new Lab10();
    }
    
}
