
package labki_5_zad3;


public class Labki_5_zad3 {

    
    public static void main(String[] args) {
        Thread thread1=new Thread(new RunnableImpl());
        thread1.start();
        
        Thread thread2=new Thread(()->{
            for(int i=0;i<10;i++)
            System.out.println("Watek"+(i*10));});
        
        thread2.start();
        
    }
    
   
    
}
