
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener,ItemListener, ChangeListener {

    JPanel p1;
    JTextField f1,f2;
    JLabel l1,l2,l3,l4,l5;
    JList list;
    JSpinner s;
    JRadioButton r1,r2;
    static JButton b1,b2;
    Main(){
        
        // nadanie tytułu aplikacji
        // ustawieni rozmiaru okna
        setTitle("Laboratorium 10");
        setSize(300,300);
        JFrame frame=new JFrame();
        
         p1=new JPanel();
        add(p1);
        // utworzenie zarządcy układu
        // i przypisanie go do ramki
        SpringLayout layout=new SpringLayout();
        setLayout(layout);
        
        // utworzeni dwóch zmiennychy obiektowych typu JTextField
         f1=new JTextField(12);
         f2=new JTextField(12);
        
         // Utworzenie etykiet 
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        l5=new JLabel();
        r1=new JRadioButton("Mężczyzna");
        r2=new JRadioButton("Kobieta");
        
        SpinnerModel model=new SpinnerNumberModel(0,0,100,1);
         s=new JSpinner(model);
        
        // stowrzenie modelu danych które znajdą się w liście
        DefaultListModel listModel = new DefaultListModel();
        // dodanie danych do modelu listy
        listModel.addElement("Pies");
        listModel.addElement("Pająk");
        listModel.addElement("Kot");
        listModel.addElement("Rybki");
        listModel.addElement("Chomik");
        listModel.addElement("Owady");
        listModel.addElement("Królik");
        
        // utworzenie obiektu typu JList oraz przekazanie do konstruktora naszego modelu
        list=new JList(listModel);
        // dodanie możliwości wyboru tylko pojedynczej opcji
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(5);
        JScrollPane scroll=new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(120,80));
        scroll.setVisible(true);
        scroll.setViewportView(list);
        
        b1=new JButton("Zatwierdź");
        b2=new JButton("Anuluj");
       
        l1.setText("Imie");
        l2.setText("Nazwisko");
        l3.setText("Płeć:");
        l4.setText("Wiek:");
        l5.setText("Wybierz zwierzęta, które posiadasz w domu :");
        
        // ustawienie zarządcy układu dla każdego elementu 
        layout.putConstraint(SpringLayout.WEST,l1,10,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.WEST,f1,60,SpringLayout.WEST,l1);
        
        layout.putConstraint(SpringLayout.WEST,l2,10,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l2,30,SpringLayout.SOUTH,l1);
        
        layout.putConstraint(SpringLayout.WEST,f2,60,SpringLayout.WEST,l2);
        layout.putConstraint(SpringLayout.SOUTH,f2,30,SpringLayout.SOUTH,f1);
        
        layout.putConstraint(SpringLayout.WEST,l3,10,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l3,30,SpringLayout.SOUTH,l2);
        
        layout.putConstraint(SpringLayout.WEST, r1,40,SpringLayout.WEST,l3);
        layout.putConstraint(SpringLayout.SOUTH,r1,30,SpringLayout.SOUTH,f2);
        
        layout.putConstraint(SpringLayout.WEST,r2,95,SpringLayout.WEST,r1);
        layout.putConstraint(SpringLayout.SOUTH,r2,30,SpringLayout.SOUTH,f2);
        
        layout.putConstraint(SpringLayout.WEST,l4,10,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l4,20,SpringLayout.SOUTH,r1);
        
        layout.putConstraint(SpringLayout.WEST,s,45,SpringLayout.WEST,l4);
        layout.putConstraint(SpringLayout.SOUTH,s,22,SpringLayout.SOUTH,r1);
        
        layout.putConstraint(SpringLayout.WEST,l5,10,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,l5,30,SpringLayout.SOUTH,s);
        
        layout.putConstraint(SpringLayout.WEST,list,40,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,list,120,SpringLayout.SOUTH,s);
        
        layout.putConstraint(SpringLayout.WEST,b1,30,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,b1,35,SpringLayout.SOUTH,list);
        
        layout.putConstraint(SpringLayout.WEST,b2,100,SpringLayout.WEST,b1);
        layout.putConstraint(SpringLayout.SOUTH,b2,35,SpringLayout.SOUTH,list);
        
        // ustawienie niektórych elementów na niedostępne w pierwszej fazie aplikacji
        r1.setEnabled(false);
        r2.setEnabled(false);
        s.setEnabled(false);
        list.setEnabled(false);
        list.setVisible(false);
        // Dodanie i obsługa zdarzeń
        f1.addActionListener(this);
        f2.addActionListener(this);
        
        r1.addItemListener(this);
        r2.addItemListener(this);
        
        s.addChangeListener(this);
        
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String wybory=new String();
               
               wybory+=f1.getText();
               wybory+=" "+f2.getText();
               if(r1.isSelected())
               {
                   wybory+=" "+r1.getText();
               }
               else wybory+=" "+r2.getText();
               wybory+=" "+s.getValue();
               wybory+=" "+list.getSelectedValue();
                System.out.println(" "+ wybory);
                
                JOptionPane.showMessageDialog(null,wybory,"Wyniki ankiety",JOptionPane.INFORMATION_MESSAGE);
            }
        });
         b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null,"Zamykam aplikacje");
                System.exit(0);
            }
        });
         
         // Dodanie adaptera
         Mouse myszka=new Mouse();
         b1.addMouseListener(myszka);
         b2.addMouseListener(myszka);
         
        //Dodanie elementów do okna
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(s);
        add(r1);
        add(r2);
        add(f1);
        add(f2);
        add(l5);
        add(list);
        add(b1);
        add(b2);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
 
    public static void main(String[] args) {
        
        Main okno;
        if(JOptionPane.showConfirmDialog(null,"Czy chcesz wziąć udział w ankiecie","Ankieta",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
         okno=new Main();
        
        
        else System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
       if((((JTextField)e.getSource())==f2  || ((JTextField)e.getSource())==f1) && (!f2.getText().isEmpty()))
       {
           r1.setEnabled(true);
           r2.setEnabled(true);
       }

      else 
       {
           JOptionPane.showMessageDialog(null,"Pole tekstowe nie jest wypełnione nie można przejsć dalej","INFORMACJA",JOptionPane.INFORMATION_MESSAGE);
       }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
     
    if(r1.isSelected() && r2.isSelected())
    {
        JOptionPane.showMessageDialog(null,"Nie możesz mieć dwóch płci jednocześnie");
        
    }
    else {
        list.setVisible(true);
        s.setEnabled(true);
    }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        list.setEnabled(true);
        s.getValue();
    }

    private static class Mouse extends MouseAdapter {

        public void mouseEntered(MouseEvent e)
            {
         
            if(e.getSource().equals(b1)) b1.setBackground(Color.red);
            if(e.getSource().equals(b2)) b2.setBackground(Color.red);
           
            }
            
            public void mouseExited(MouseEvent e){
                b1.setBackground(Color.LIGHT_GRAY);
                b2.setBackground(Color.LIGHT_GRAY);
            }
    }
    
}
