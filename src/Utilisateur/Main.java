package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Alimentation alimentation = new Alimentation(0.5,0.6);
        BienConso bienConso = new BienConso(10000);
        Logement logement = new Logement(91, CE.A);
        ArrayList<Logement> logements = new ArrayList<Logement>();
        logements.add(logement);
        Voiture voiture = new Voiture(true, Taille.P, 12200, 7);
        Avion avion = new Avion(1200);
        TrainEtBus train = new TrainEtBus(1500);
        ServicesPublics services = new ServicesPublics();
        Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logements, avion, voiture, train, services);
        utilisateur.sortConsoCarbone();
    }
}
