package td4;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client implements Personne {
    private String nom ;
    private String reference ;
    private String paiement ;
    private String contact ;
    // Liste des reservations du client
    private List<Reservation> reservations = new ArrayList<>();
    // getteur pour acceder a la liste des reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    // Constructeur
    public Client(String nom ,String reference ,String paiement ,String contact){
        this.nom = nom;
        this.reference = reference;
        this.paiement = paiement;
        this.contact = contact;
    }
    // effectuer une reservation
    @Override
    public Reservation effectue(String numero ,ZonedDateTime date ,String nom ,Vol vol){
        Reservation resr = new Reservation(numero,date,nom,vol);
        reservations.add(resr);
        return resr ;
    }
    // Getters des informations du client
    public String getNom(){
        return nom;
    }
    public String getReference(){
        return reference;
    }
    public String getPaiement(){
        return paiement;
    }
    public String getContact(){
        return contact;
    }

}
