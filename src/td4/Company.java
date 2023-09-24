package td4;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String nom ;
    // Liste des vols de la company
    private List<Vol> vols = new ArrayList<>();
        
    // Un constructeur du nom
    public Company(String nom){
        this.nom = nom ;
    }
    // Un getter pour acceder au listes
    public List<Vol> getVolListe() {
        return vols ;
    }

    // Creer des vols
    public void propose(NumVol num,ZonedDateTime dep, ZonedDateTime ar,Aeroport aeroA , Aeroport aeroD){
        // Envoyer un Exception sur la date de depart est superieure a la date d'arrivee
        if (aeroA.get_code().equals(aeroD.get_code()))
            throw new IllegalArgumentException("Les aeroports de depart et arrivee doivent etres differents !");
        else if(ar.compareTo(dep) <= 0){
            throw new IllegalArgumentException("Date de depart est superieure a la date d'arrivee !!! ");
        }
        else{
            Vol vol = new Vol(num,dep,ar,aeroA,aeroD);
            vols.add(vol);
        }
    }

    // Methode pour afficher les details de la compagnie
    public void info(){
        System.out.println("********** Company: "+nom+" ***********");
        System.out.println("Liste des vols : ");
        for(Vol x:vols){
            x.info();
        }
    }

}
