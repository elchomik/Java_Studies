
package labki4;

import java.util.*;

public class SortbyJob extends Czlowiek implements Comparator<Pracownik>{

    @Override
    public int compare(Pracownik o1, Pracownik o2) {
        return o1.ktoraPraca()-o2.ktoraPraca();
    }

    @Override
    public String skadDochod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
