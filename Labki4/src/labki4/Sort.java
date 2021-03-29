
package labki4;

import java.util.*;


public class Sort extends Czlowiek implements Comparator<Pracownik> {

    @Override
    public String skadDochod() {
      return "String";  
    }

    @Override
    public int compare(Pracownik a, Pracownik b) {
        return a.wJakimWieku()-b.wJakimWieku();
       
    }
    
}
