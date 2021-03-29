
package labki7_zad2;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.HeadlessException;
import javax.swing.*;

public class Labki7_zad2 extends JFrame{

    public Labki7_zad2(String title) throws HeadlessException {
        super(title);
     
        JPanel p1=new JPanel();
      
        JPanel p3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        p1.setLayout(new BoxLayout(p1,BoxLayout.PAGE_AXIS));
     
        
        JButton b1=new JButton("Przycisk 1");
        JButton b2=new JButton("Przycisk 2");
        JButton b3=new JButton("Przycisk 3");
        JButton b4=new JButton("Przycisk 4");
        JButton b5=new JButton("Przycisk 5");
        
        JButton[] tab=new JButton[6];
        String[] tab2={"Lp","Imie","Nazwisko"};
        
        Object[][] tab3=
        {
            {1,"Jan","Kowalski"}, {2,"Marian","Pies"},
            {3,"Tomasz","Tomczyk"},{4,"Mateusz","Markowski"},
            {5,"Julia","Kieliszek"},{6,"Janusz","Wójcik"},
            {7,"Julian","Dzban"},{8,"Daria","Krok"},
            {9,"Grażyna","Żarko"},{10,"Paris","Platynov"},
            {11,"Joachim","Kiełbasa"},{12,"Wojcieh","Cejrowski"},
            {13,"Paweł","Pawelec"},{14,"Konrad","Namysłowski"},
            {15,"Tomasz","Rutkowski"},{16,"Martyna","Rejzner"}
                
            
        };
        
        
        
        
        for(int i=1;i<=5;i++)
        {
            tab[i]=new JButton("Przycisk "+i);
            p1.add(tab[i]);
        }
        add(p1,BorderLayout.WEST);
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setBorder(BorderFactory.createTitledBorder("Opcje"));
        
        /*JLabel[] labels=new JLabel[10];
        for(int i=0;i<10;i++)
        {
            if(i%2==0){
                labels[i]=new JLabel("Pozycja "+i+":",JLabel.RIGHT);
                p2.add(labels[i]);
            }
            else p2.add(new JTextField(20));
        }*/        
        
         JPanel p=new JPanel(new SpringLayout());
       for(int i=0;i<10;i++)
       {
           if(i%2==0){
           JLabel l=new JLabel("Pozycja"+i,JLabel.TRAILING);
           p.add(l);
           JTextField textField=new JTextField(10);
           l.setLabelFor(textField);
           p.add(textField);
           }
       }
        SpringUtilities.makeCompactGrid(p,5,2,6,6,6,6);
        
        p.setBackground(Color.LIGHT_GRAY);
        p.setBorder(BorderFactory.createTitledBorder("Formularz"));
        add(p,BorderLayout.EAST);
        
        p3.setBackground(Color.LIGHT_GRAY);
        p3.setBorder(BorderFactory.createTitledBorder("OK"));
        add(p3,BorderLayout.SOUTH);
        
        JTable table=new JTable(tab3,tab2);
        JScrollPane scroll=new JScrollPane(table);
        add(scroll,BorderLayout.CENTER);
        
        JMenuBar menu=new JMenuBar();
        JMenu m1=new JMenu("Plik");
        JMenu m2=new JMenu("Edycja");
        menu.add(m1);
        menu.add(m2);
        
        JMenuItem item1=new JMenuItem("Otwórz");
        JMenuItem item2=new JMenuItem("Zapisz");
        JMenuItem item3=new JMenuItem("Zapisz jako");
        JMenuItem item4=new JMenuItem("Drukuj");
        JMenuItem item5=new JMenuItem("Zamknij");
        
        m1.add(item1);
        m1.add(item2);
        m1.add(item3);
        m1.add(item4);
        m1.add(item5);
        setJMenuBar(menu);
        
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    
   
    public static void main(String[] args) {
      
      Labki7_zad2 okno=new Labki7_zad2("Okno");
      
      
    }
    
}
