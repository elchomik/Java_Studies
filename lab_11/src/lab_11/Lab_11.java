
package lab_11;
import java.awt.BorderLayout;

import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.acl.Group;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
public class Lab_11 extends JFrame {

    Lab_11(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
    });
      
    }
    final JFXPanel jfxPanel=new JFXPanel();
    final JFXPanel jfxPanel2=new JFXPanel();
    
    private final JPanel jpanel=new JPanel(new BorderLayout());
    private WebEngine webEngine;
    
    private final JButton jbldz=new JButton("Idź");
    private final JTextField jtxtURL=new JTextField("https://www.facebook.com/");
    
    final JFrame frame=new JFrame("Swing & JavaFx WebBrowser");
    
     
    public static void main(String[] args) {
        Lab_11 lab=new Lab_11();
      
        
    
    }
    private void initGUI(){
        // Uruchomienie w wątku EDT
        
        ActionListener listener=new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadPage(jtxtURL.getText());
            }
        };
        jbldz.addActionListener(listener);
        jtxtURL.addActionListener(listener);
       
        jpanel.add(jtxtURL,BorderLayout.CENTER);
        jpanel.add(jbldz,BorderLayout.EAST);
        frame.add(jpanel,BorderLayout.NORTH);
        frame.add(jfxPanel,BorderLayout.SOUTH);
        frame.add(jfxPanel2,BorderLayout.CENTER);
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //Uruchomienie w wątku JavyFx
        
        Platform.runLater(new Runnable(){
            public void run(){
                initJFX(jfxPanel);
            }
        });
    }
    
    private void initJFX(JFXPanel jfxPanel){
        Scene scene=createScene();
        jfxPanel.setScene(scene);
        createScene2();
  
    }
   
    // Metoda budująca scenę
    
    private Scene createScene(){
        VBox root=new VBox();
          
        Scene scene=new Scene(root,Color.AQUAMARINE);
        Text text=new Text();
      
        text.setX(200);
        text.setY(50);
        text.setFont(Font.font("Verdana",20));
        text.setText("Welcome to WWW");
        root.getChildren().add(text);
        
        return (scene);
    }
    
    public void loadPage(final String url){
        Platform.runLater(new Runnable(){
            
            public void run(){
                try{
                    String tmp=new URL(url).toExternalForm();
                    webEngine.load(tmp);
                }catch(MalformedURLException ex){
                    System.out.println("Błędny adres URL");
                }
            }
        });
    }
    private void createScene2(){
        Platform.runLater(new Runnable(){
            public void run(){
                WebView view= new WebView();
                webEngine=view.getEngine();
                webEngine.titleProperty().addListener(new ChangeListener<String>(){
                    public void changed(ObservableValue<? extends String> observable,
                            String oldValues,final String newValue){
                        SwingUtilities.invokeLater(new Runnable(){
                            
                        
                        public void run(){
                            Lab_11.this.frame.setTitle(newValue);
                        }
                        });
                    }
                });
                jfxPanel2.setScene(new Scene(view));
            }
        });
    }
}
