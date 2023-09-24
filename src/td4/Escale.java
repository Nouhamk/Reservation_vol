package td4;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Escale implements Etape{
    private ZonedDateTime arriveeA ;
    private ZonedDateTime departDe ;
    private Aeroport aero_esc ;
    private Duration duree ;

    // Constructeur d'escale
    public Escale(Aeroport aero_esc, ZonedDateTime arriveeA ,ZonedDateTime departDe){
        this.departDe = departDe ;
        this.arriveeA = arriveeA ;
        this.duree = calc_duree(departDe,arriveeA);
        this.aero_esc = aero_esc ;
    }
    // Methode+Getter pour calculer la duree de l'escale
    private Duration calc_duree(ZonedDateTime d1, ZonedDateTime d2){
        return Duration.between(d1, d2);
    }
    @Override
    public Duration getDuree(){
        return this.duree ;
    }

    public ZonedDateTime getArriveeA(){
        return arriveeA;
    }
    public ZonedDateTime getDepartDe(){
        return departDe;
    }
    // Afficher les informations de l'escale
    @Override
    public void info(){
        System.out.println("  - Escale a: "+aero_esc.get_code()+" Duree : "+duree+" -----");
        System.out.println("  - Aeroport d'escale : "+aero_esc.get_nom());
        System.out.println("  - Debut d'escale : "+arriveeA+" Fin d'escale : "+departDe);
    }

}