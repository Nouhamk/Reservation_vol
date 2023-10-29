package td4;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Start {
    public static void main(String[] args) {

//_____________________________________________ Partie : Gestion Vols __________________________________________________
        // On commence par creer des compagnies
        Company comp1 = new Company("Easyjet");
        Company comp2 = new Company("Royal Air Maroc");
        Company comp3 = new Company("Fly-Emirates");

        // On creer quelques Numeros de vols
        NumVol num1 = new NumVol("24XC12");
        NumVol num2 = new NumVol("32XC13");
        NumVol num3 = new NumVol("10BJ12");
        NumVol num4 = new NumVol("03DZ11");
        NumVol num5 = new NumVol("11AB91");
        NumVol num6 = new NumVol("25GN17");

        // On creer quelques dates des vols
        ZoneId zoneId = ZoneId.of("GMT+2");
        // Date pour vol 1
        List<ZonedDateTime> time1 = new ArrayList<>();
        time1.add(ZonedDateTime.of(2020,11,13,12,00,00,00,zoneId));
        time1.add(ZonedDateTime.of(2020,11,13,23,15,00,00,zoneId));
        // Date pour vol 2
        List<ZonedDateTime> time2 = new ArrayList<>();
        time2.add(ZonedDateTime.of(2020,11,15,12,00,00,00,zoneId));
        time2.add(ZonedDateTime.of(2020,11,15,15,55,00,00,zoneId));
        // Date pour vol 3
        List<ZonedDateTime> time3 = new ArrayList<>();
        time3.add(ZonedDateTime.of(2020,11,7,12,00,00,00,zoneId));
        time3.add(ZonedDateTime.of(2020,11,7,17,25,00,00,zoneId));
        // Date pour vol 4
        List<ZonedDateTime> time4 = new ArrayList<>();
        time4.add(ZonedDateTime.of(2020,12,13,8,45,00,00,zoneId));
        time4.add(ZonedDateTime.of(2020,12,13,14,15,00,00,zoneId));
        // Date pour vol 5
        List<ZonedDateTime> time5 = new ArrayList<>();
        time5.add(ZonedDateTime.of(2021,4,13,18,00,00,00,zoneId));
        time5.add(ZonedDateTime.of(2021,4,13,23,15,00,00,zoneId));
        // Date pour vol 6
        List<ZonedDateTime> time6 = new ArrayList<>();
        time6.add(ZonedDateTime.of(2021,7,13,11,35,00,00,zoneId));
        time6.add(ZonedDateTime.of(2021,7,13,21,15,00,00,zoneId));

        // On cree des villes
        Ville ville1 = new Ville("Paris");
        Ville ville2 = new Ville("Los Angeles");
        Ville ville3 = new Ville("Casablanca");
        Ville ville4 = new Ville("Conakry");

        // On cree des Aeroport
        Aeroport aero1 = new Aeroport("Paris Charle De Gaull","CDG",ville1);
        Aeroport aero2 = new Aeroport("Los Angelos International","LAX",ville2);
        Aeroport aero3 = new Aeroport("Casablanca Mohammed 6","CMN",ville3);
        Aeroport aero4 = new Aeroport("GBESSIA-CONAKRY","CKY",ville4);

        //On cree des Vols.
        List<Company> comps = new ArrayList<>();
        comp1.propose(num1,time1.get(0),time1.get(1),aero1,aero4);
        comp1.propose(num2,time2.get(0),time2.get(1),aero4,aero3);
        comp1.propose(num3,time3.get(0),time3.get(1),aero1,aero3);
        comp2.propose(num4,time4.get(0),time4.get(1),aero2,aero4);
        comp3.propose(num5,time5.get(0),time5.get(1),aero3,aero1);
        comp3.propose(num6,time6.get(0),time6.get(1),aero2,aero3);

        comps.add(comp1);comps.add(comp2);comps.add(comp3);

        // Ajouter des escales au vols
        List<ZonedDateTime> time_esc = new ArrayList<>();
        time_esc.add(ZonedDateTime.of(2020,11,13,17,00,00,00,zoneId));
        time_esc.add(ZonedDateTime.of(2020,11,13,17,45,00,00,zoneId));

        // AJouter un escale pour le vol FRANCE-GUINEE
        Escale esc1 = new Escale(aero3,time_esc.get(0),time_esc.get(1));
        comp1.getVolListe().get(0).add_Escale(esc1);

        // AJouter DEUX escales pour le vol LosAngelos-Conakry
        Escale esc2 = new Escale(aero3,time_esc.get(0),time_esc.get(1));
        comp2.getVolListe().get(0).add_Escale(esc2);
        Escale esc3 = new Escale(aero3,time_esc.get(0),time_esc.get(1));
        comp2.getVolListe().get(0).add_Escale(esc3);

        // Ouvrir tout les vols
        for (Company c:comps) {
            for (Vol v: c.getVolListe()){
                v.ouvrir();
            }
        }

        // Fermer les vol automatiquement s'il reste moins de 6h pour le depart
        for (Company c:comps) {
            for (Vol v: c.getVolListe()){
                ZonedDateTime d1 = v.getDateDepart(); // date de depart du vol
                ZonedDateTime d2 = ZonedDateTime.now(); // date actuelle
                Duration d = Duration.ofHours(6);
                if(Duration.between(d1, d2).compareTo(d) > 0)
                    v.fermer();
            }
        }


//_________________________________________ Partie : Gestion Reservations ______________________________________________


        // Creer des Clients  -----------------
        List<Client> clients = new ArrayList<>();
        Client cli1 = new Client("Zarouki Hamza","cl0001","CB","0765448596");
        Client cli2 = new Client("Moukaddime Nouhaila","cl0002","EP","0623458569");
        Client cli3 = new Client("Brad Pitt","cl0003","CB","0523487569");

        clients.add(cli1);clients.add(cli2);clients.add(cli3);

        // Creer des Passagers  -----------------
        Passager pass1 = new Passager("BOUGOUROUM BOUGOUNA");
        Passager pass2 = new Passager("Mister Unknown");

        //Gerer les reservations des vols -----------------
        List<Reservation> reservations = new ArrayList<>();
        Reservation res1,res2,res3,res4,res5,res6;
        // 1) Pour les clients
        ZonedDateTime t1 = ZonedDateTime.of(2020,10,28,12,15,00,00,zoneId);
                // Premier client va faire une reservation pour lui meme ainsi qu'un ami
        res1=clients.get(0).effectue("BVC13Q",t1,cli1.getNom(),comp1.getVolListe().get(0));
        res2=clients.get(0).effectue("DUX22B",t1,"Diallo Floyd",comp1.getVolListe().get(0));
                // Deuxieme/Troisieme client vont faire une reservation juste pour eux
        ZonedDateTime t2 = ZonedDateTime.of(2020,10,25,00,15,00,00,zoneId);
        ZonedDateTime t3 = ZonedDateTime.of(2020,11,01,20,35,00,00,zoneId);
        res3=clients.get(1).effectue("ZNB00P",t2,cli2.getNom(),comp2.getVolListe().get(0));
        res4=clients.get(2).effectue("DUX22B",t2,cli3.getNom(),comp3.getVolListe().get(1));

            // 2) Pour les passagers
        ZonedDateTime t4 = ZonedDateTime.of(2020,10,30,00,15,00,00,zoneId);
        ZonedDateTime t5 = ZonedDateTime.of(2020,11,01,20,35,00,00,zoneId);
        res5=pass1.effectue("XSL02A",t4,pass1.getNom(),comp1.getVolListe().get(2));
        res6=pass1.effectue("AHA99O",t5,pass2.getNom(),comp3.getVolListe().get(0));

        //Ajouter tout les res a la liste
        reservations.add(res1);reservations.add(res2);reservations.add(res3);
        reservations.add(res4);reservations.add(res5);reservations.add(res6);

        // Modifier les status des reservations
        //Client 1 veut annuler tout les vols reservees
        for (Reservation r:clients.get(0).getReservations()){
            r.annuler();
        }

        // Confirmer une reservations si le proprietaire ne l'a pas annuler apres 24 heurs de la creation
        for (Client c:clients){
            for (Reservation r : c.getReservations()) {
                if(Duration.between(r.getDate(),ZonedDateTime.now()).compareTo(Duration.ofHours(24)) > 0){
                    r.confirmer();
                }
                else
                    r.annuler();
            }
        }

//________________________________________________ Partie : MAIN _______________________________________________________

        // Affichage de menu
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("|                          Réservation Vol                            |");
        System.out.println("|                          Moukaddime Nouhaila                        |");
        System.out.println("|---------------------------------------------------------------------|");
        System.out.println("");
        System.out.println("_______________________ Menu _______________________");
        System.out.println(" 1) Liste des Vols ");
        System.out.println(" 2) Liste des Reservations ");
        System.out.print("Saisissez votre choix :  ");
        Scanner sc = new Scanner(System.in);
        //int choice = sc.nextInt();
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1 :
                // Affichage du tableau de Compagnies & Vols
                for(Company x:comps){
                    System.out.println("----------------------- Liste des Vols -----------------------");
                    x.info();
                }
                break;
            case 2 :
                System.out.println("----------------------- Liste des Reservations -----------------------");
                for(Reservation x:reservations){
                    x.info();
                }
                break;
            default :
                System.out.println("Erreur de saisie");
                break;
        }

        // END
    }
}