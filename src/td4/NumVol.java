package td4;

import javax.xml.validation.Validator;
import java.util.regex.Pattern;

public class NumVol {
    private String numero ;
    // Le pattern pour valider le snumeor de vol
    private static final Pattern VALIDATION_RE = Pattern.compile("^\\d{2}[A-Z]{2}\\d{2}$");

    public NumVol() {
    }

    // Creer cette methode pour pouvoir acceder a unmero de vol pour le tester avec gradle , car je peut pas inserer
    // le constructeure dans le assertThat
    public static String set_numvol(String numero){
        if(!numero.matches(VALIDATION_RE.pattern())){
            throw new IllegalArgumentException("Le numero de Vol ne respecte pas la forme exigees");
        }
        else {
            return numero;
        }
    }
    //
    public NumVol(String numero){
        this.numero = set_numvol(numero);
    }
    public String getNumVol(){
        return numero;
    }
}
