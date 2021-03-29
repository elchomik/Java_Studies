
package labki4;
import java.util.*;

public class Labki4 {

    
    public static void main(String[] args) {
        Czlowiek c=new Czlowiek("Jan","Kowalski",'M',23) {
            @Override
            public String skadDochod() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        c.zatrudniony();
        
        Pracownik p1=new Pracownik("McDonald","Kucharz",4000,2,"Michał","Kot",'m',45);
        Pracownik p2=new Pracownik("Biedronka","Kasjer",3800,5,"Joanna","Sztacheta",'k',23);
        Pracownik p3=new Pracownik("Google","Programista",50000,1,"Mateusz","Marko",'m',21);
        Pracownik p4=new Pracownik(null,"Informatyk",0,3,"Bartosz","Butek",'M',25);
        Pracownik p5=new Pracownik(null,"Fizjoterapeuta",0,4,"Piotr","Szkit",'M',24);
        Pracownik p6=new Pracownik("Politechnika","Sekretarka",3000,2,"Barbara","Kowalik",'K',35);
        Pracownik p7=new Pracownik(null,"Księgowa",3450,4,"Grażyna","Żarko",'K',47);
     /*   Pracownik.dajRaport(p1);
        System.out.println();
        Pracownik.dajRaport(p2);
        System.out.println();
        Pracownik.dajRaport(p3);
        System.out.println();*/
        Pracodawca pr=new Pracodawca("Bigle","Informatyk",5000,"Zbigniew","Kręcina",'M',56);
        Pracodawca pr1=new Pracodawca("Britit","Programista Java",10000,"Tomasz","Jarzyna",'M',47);
        Pracodawca pr2= new Pracodawca("As Bytom","Kostniczy",3500,"Juliusz","Horkis",'M',65);
        Pracodawca pr3= new Pracodawca("Bank PKO","Księgowa",4500,"Renata","Kotowska",'K',34);
        Pracodawca pr4=new Pracodawca("LekMed","Fizjoterapeuta",2300,"Grzegorz","Kropka",'M',44);
        Pracodawca pr5=new Pracodawca("Bruk-Bet","Murasz",4560,"Bartosz","Wlazły",'M',59);
        Pracodawca pr6=new Pracodawca("KTS Weszło","Piłkarz",2000,"Michał","Stanowski",'M',38);
        
        List<Pracownik> co=new ArrayList<>(7);
        co.add(p1);
        co.add(p2);
        co.add(p3);
        co.add(p4);
        co.add(p5);
        co.add(p6);
        co.add(p7);
        
        
        
        System.out.println("Lista potencjanych pracowników");
        
        for(Pracownik p: co){
            System.out.println("Pracownik ");
            Pracownik.dajRaport(p);
            System.out.println("\n");
            
        }
        
        System.out.println("\n"); 
        System.out.println("Lista pracodawców\n");
        
        List<Pracodawca> pracodawcy=new ArrayList<>(7);
        pracodawcy.add(0,pr);
        pracodawcy.add(1,pr1);
        pracodawcy.add(2,pr2);
        pracodawcy.add(3,pr3);
        pracodawcy.add(4,pr4);
        pracodawcy.add(5,pr5);
        pracodawcy.add(6,pr6);
        
        Map<String,Integer> pair=new HashMap<>();
        pair.put(p1.jakSieNazywasz(),p1.ktoraPraca());
        pair.put(p2.jakSieNazywasz(),p2.ktoraPraca());
        pair.put(p3.jakSieNazywasz(),p3.ktoraPraca());
        pair.put(p4.jakSieNazywasz(),p4.ktoraPraca());
        pair.put(p5.jakSieNazywasz(),p5.ktoraPraca());
        pair.put(p6.jakSieNazywasz(),p6.ktoraPraca());
        pair.put(p7.jakSieNazywasz(),p7.ktoraPraca());
        
        System.out.println("Wyswietl pracodawców");
        for(Pracodawca praca: pracodawcy){
            System.out.println("Pracodawca");
            praca.wyswietl();
            System.out.println("\n");
        }
        System.out.println();
        System.out.println("Czy udalo się zatrudnić pracownika\n");
        
        for(Pracownik e: co){
            for(Pracodawca pra: pracodawcy){
            pra.zatrudnij(e);
            }
        }
            System.out.println("\nW ilu miejscach pracy pracował dany pracownik\n");
            
            for(Map.Entry<String,Integer> maps : pair.entrySet()){
                String key=maps.getKey();
                Integer value=maps.getValue();
                System.out.println(key+ " "+ value);
            }
            
            System.out.println("\n\nSortowanie pracowników według wieku");
            Collections.sort(co,new Sort());
           
            for(int index=0;index<co.size();index++){
                System.out.print(co.get(index).jakSieNazywasz());
                System.out.println(" "+co.get(index).wJakimWieku());
                
            }
            
            System.out.println("\n\n Sortowanie pracowników według ilości w ilu miejscach pracował\n");
            Collections.sort(co,new SortbyJob());
            
            for(int x=0;x<co.size();x++){
                System.out.print(co.get(x).jakSieNazywasz()+" ");
                System.out.println(co.get(x).ktoraPraca()+" "+co.get(x).wJakimWieku());
                
            }
            
    
    
}
}
