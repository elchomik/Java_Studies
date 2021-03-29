
package labki4;


public class Pracodawca extends Czlowiek {
    public String nazwaFirmy;
    public String preferencje;
    public double pensjaPracownicza;

    public Pracodawca(String nazwaFirmy, String preferencje, double pensjaPracownicza, String Imie, String Nazwisko, char plec, int wiek) {
        super(Imie, Nazwisko, plec, wiek);
        this.nazwaFirmy = nazwaFirmy;
        this.preferencje = preferencje;
        this.pensjaPracownicza = pensjaPracownicza;
    }
   
    public void zatrudnij(Pracownik p ){
        if(p.zawod.equals(preferencje)){
            System.out.println("Pracownik został zatrudniony");
            System.out.println();
            Pracownik.dajRaport(p);
            p.zatrudniony=true;
            p.dochod=pensjaPracownicza;
            p.miejscePracy=nazwaFirmy;
            System.out.println();
            System.out.println("Zaktualizowane dane pracownika ");
            System.out.println();
            Pracownik.dajRaport(p);
            
        }
        else{
            System.out.println("Pracownik nie został zatrudniony");
            
        }
    }
    
    @Override
    public String skadDochod() {
        return "Mam własną firme "+nazwaFirmy;
    }
    public void wyswietl(){
        System.out.println("Imie i Nazwisko "+jakSieNazywasz());
        System.out.print("Czy jestes Konieta");
        jestesKobieta();
        System.out.println("W jakim wieku jestes "+wJakimWieku());
        System.out.println("Nazwa Firmy "+nazwaFirmy);
        System.out.println("Poszukiwane prefernecje pracownika "+ preferencje);
        System.out.println("Przewidywana pensja dla pracownika "+pensjaPracownicza);
    }
    
}
