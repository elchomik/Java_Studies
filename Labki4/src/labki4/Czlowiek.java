
package labki4;


public abstract class Czlowiek {
    public String Imie;
    public String Nazwisko;
    public char plec;
    public int wiek;
    protected boolean zatrudniony=false;

    public Czlowiek(String Imie, String Nazwisko, char plec, int wiek) {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.plec = plec;
        this.wiek = wiek;
    }
    
    public Czlowiek(){
        this("nn","nn",'n',0);
    }
    public Czlowiek(String Imie,String Nazwisko){
        this(Imie,Nazwisko,'n',0);
    }
    
    public String jakSieNazywasz(){
        return Imie +" "+ Nazwisko;
    }
    public void jestesKobieta(){
        switch(plec){
            case 'm':
                     System.out.println("Nie");
                     break;
                     
             case 'k':
                     System.out.println("Tak");
                     break;
             case 'M':
                 System.out.println("Nie");
                 break;
             case 'K':
                 System.out.println("Tak");
                 break;
             default: System.out.println("Nie wiem");
            
        }
          
    }
    public int wJakimWieku(){
        return wiek;
    }
    protected void zatrudniony(){
        zatrudniony=true;
        System.out.println(zatrudniony);
        
    }
    public abstract String skadDochod();
}
