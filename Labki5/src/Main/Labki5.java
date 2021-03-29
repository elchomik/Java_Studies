
package Main;

import java.io.File;
import java.util.*;

public class Labki5 {

    /*podpunkt a*/
    
    void printList(Object[] list,String title)
    {
        for(Object item: list)
        {
            System.out.println(title+ " "+item);
        }
        
    }
    
    /*podpunkt b*/
    
    void printShortName(Object[] list)
    {
        for(Object item: list)
        {
            if(item.toString().lastIndexOf(".")>=0)
            {
                System.out.println(item.toString().substring(0,item.toString().indexOf(".")));
            }
            else
            {
                System.out.println(item);
            }
        }
    }
    /* podpunkt c */
    
    ArrayList findExt(Object[] list,String ext)
    {
        
        ArrayList<String> array=new ArrayList<>();
        
        for(Object item: list)
        {
            if(item.toString().endsWith(ext))
            {
                array.add(item.toString());
            }
        }
        return array;
        
    }
    /* podpunkt d */
    
    ArrayList findCont(String[] list,String subs)
    {
        ArrayList<String> arr=new ArrayList<>();
        
        for(String item: list)
        {
            if(item.contains(subs))
            {
                arr.add(item);
            }
        }
        return arr;
    }
    /* podpunkt e */
    
    
    
   
    public static void main(String[] args) {
      
      Labki5 main= new Labki5();
      File f=new File(".");  // przegladanie plików w bieżącym katalogu
      String[] tab=f.list();
      
     /* podpunkt a*/
      
     System.out.println("\n---- podpunkt a ----\n");
     main.printList(tab," Tytuł ");
        
      System.out.println("\nPosortowane pliki w naszym katalogu\n");
      Arrays.sort(tab);
      main.printList(tab," Tytuł 2 ");
      
      /* podpunkt b*/
      
      System.out.println("\n---- podpunkt b ----\n");
      main.printShortName(tab);
      
      /*podpunkt c */
      
        System.out.println("\n---- podpunkt c ----\n");
        
        Object[] collection=main.findExt(tab,"mf").toArray();
        main.printList(collection," Tytuł znalezionego pliku ");
      /* podpunkt d */
      
        System.out.println("\n---- podpunkt d ----\n");
        
        Object[] c=main.findCont(tab,"i").toArray();
        c.toString().split(",");
        main.printList(c,"Tytuł");
        
        /* podpunkt e */
        System.out.println("\n---- podpunkt e ----\n");
        
        main.printShortName(c);
        
        /* podpunkt f */
        System.out.println("\n---- podpunkt f ----\n");
        
        System.out.println(" Pozycja numer " + Arrays.binarySearch(tab," src "));
       
    }
    
}
