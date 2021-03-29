
package labki4;


public class Pracownik extends Czlowiek {
    public String miejscePracy;
    public String zawod;
    public double dochod;
    private int praca;

    public Pracownik(String miejscePracy, String zawod, double dochod,int praca, String Imie, String Nazwisko, char plec, int wiek) {
        super(Imie, Nazwisko, plec, wiek);
        this.miejscePracy = miejscePracy;
        this.zawod = zawod;
        this.dochod = dochod;
        this.praca=praca;
    }
    public void zatrudnij(String miejscePracy,double dochod){
        super.zatrudniony();
        if(miejscePracy.equals(null)){
        System.out.println("Jestem bezrobotny");
        System.out.println("Nie posiadam dochodu");
        }
        else{
            System.out.println("Moje miejsce pracy to "+miejscePracy);
            System.out.println("Moj dochod to "+dochod);
        }
    }
    @Override
    public String skadDochod() {
        return miejscePracy;
    }
    public int ktoraPraca(){
        return praca;
    }
   
    public static void dajRaport(Pracownik p){
        System.out.println("Imie i nazwisko "+p.jakSieNazywasz());
        System.out.println("W jakim wieku jestes "+p.wJakimWieku());
        System.out.println("Czy jestes kobieta");
        p.jestesKobieta();
        System.out.print("Czy zatrudnony ");
        p.zatrudniony();
        System.out.println("Skad dochod "+p.skadDochod());
        System.out.println("Które miejsce zatrudnienia");
        
    }
    
}
