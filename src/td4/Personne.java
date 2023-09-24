package td4;

import java.time.ZonedDateTime;

public interface Personne {
    public String nom = null;
    Reservation effectue(String numero ,ZonedDateTime date,String nom,Vol vol);
    String getNom();
}
