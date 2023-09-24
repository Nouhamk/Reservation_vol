package td4;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.regex.Pattern;

public class Reservation {
    private String numero ;
    private ZonedDateTime date ;
    private boolean status ;
    private Passager passager ;
    private Vol vol ;

    private final Pattern VALIDATION_RE = Pattern.compile("^[A-Z]{3}\\d{2}[A-Z]{1}$");

    // Constructeur Pour Un Passager/Client et le Vol
    public Reservation(String numero ,ZonedDateTime date,String nom,Vol vol){
        if(!numero.matches(VALIDATION_RE.pattern()))
            throw new IllegalArgumentException("Le numero de Vol ne respecte pas la forme exigees");
        else if (date.compareTo(vol.getDateDepart()) > 0)
            throw new IllegalArgumentException("Date de reservation depasse la date de depart !");
        else{
            this.numero = numero;
            this.date = date;
            // Lier la reservation a un vol et un passager
            this.passager = new Passager(nom);
            this.vol = vol ;
        }
    }

    // Changer le status de la reservation
    public void confirmer(){
        this.status = true ;
    }
    public void annuler(){
        this.status = false ;
    }
    //setter pour changer le status
    public Reservation(Boolean status){
        if(status)
            confirmer();
        else
            annuler();
    }
    public String getNumero(){
        return numero;
    }
    public ZonedDateTime getDate(){
        return date;
    }
    public Passager getPassager(){
        return passager;
    }
    public boolean getStatus(){
        return status;
    }

    public void info(){
        System.out.println("");
        System.out.println("---> Reservation : "+numero);
        System.out.println("- Date : "+date);
        System.out.println("- Passager : "+passager.getNom());
        if (status)
            System.out.println("- Status : Confirmer");
        else
            System.out.println("- Status : Annuler");


    }

}
