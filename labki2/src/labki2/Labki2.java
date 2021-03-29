
package labki2;

import java.util.Scanner;

public class Labki2 {

    int ilArgumentow;

    public Labki2(int ilArgumentow) {
        this.ilArgumentow = ilArgumentow;
    }
    
    public void wyswietlString(String s){
        System.out.println("zmienna którą wyświetłam to "+ s+"\n");
        
    }
   public void wyswietlArgumenty(String tab[]){
        
       for(int i=0;i<tab.length;i++){
            wyswietlString(tab[i]);
       }
   }
   
   public double policzSrednia(String tab[]){
       double suma=0;
       for(int i=0;i<ilArgumentow;i++){
           suma+=Double.parseDouble(tab[i]);
       }
       return suma/ilArgumentow;
   }
    
   public int slownie(double srednia){
       if(srednia>4.51 && srednia<=5.0)
       {
           System.out.println("Ocena bardzo dobra");
           return 5;
       }
       else if(srednia>=4.0)
       {
           System.out.println("Ocena dobra");
           return 4;
       }
       else if(srednia>=3.0) 
       {
           System.out.println("Ocena dostateczna ");
           return 3;
       }
       else {
           System.out.println("Ocena niedostateczna");
           return 2;
       }        
          
   }
    public static void main(String[] args) {
       int zmienna=3;
        Labki2 labki=new Labki2(zmienna);
        String[] tab=new String[zmienna];
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Podaj oceny ");
        
        for(int i=0;i<zmienna;i++){
            System.out.println("Ocena "+(i+1));
            tab[i]=sc.nextLine();
        }
        
        System.out.println("Oblicz średnią ocen\n");
        double srednia=labki.policzSrednia(tab);
        System.out.println(labki.slownie(srednia));
   
        int zm=labki.slownie(srednia);
        System.out.println("Skrócony zapis\n");
        switch(zm){
            
            case 2: System.out.println("ndst");break;
            case 3: System.out.println("dst");break;
            case 4: System.out.println("db");break;
            case 5: System.out.println("bdb");break;
        }
    }
    
}
