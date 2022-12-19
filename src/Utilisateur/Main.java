package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        try{
            Alimentation alimentation = new Alimentation(0.5,0.4);
            Avion avion = new Avion(1200);
            BienConso bienConso = new BienConso(10000);
            Logement logement = new Logement(91, CE.A);
            ArrayList<Logement> logements = new ArrayList<Logement>();
            logements.add(logement);
            Voiture voiture = new Voiture(true, Taille.P, 12200, 7);
            TrainEtBus train = new TrainEtBus(1500);
            ServicesPublics services = new ServicesPublics();
            Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logements, avion, voiture, train, services);
            utilisateur.sortConsoCarbone();

            Alimentation alimentation2 = new Alimentation(0.3,0.5);
            BienConso bienConso2 = new BienConso(1000);
            Logement logement2 = new Logement(100, CE.B);
            Logement logement1 = new Logement(150, CE.C);
            ArrayList<Logement> logements2 = new ArrayList<Logement>();
            logements2.add(logement1);
            logements2.add(logement2);
            Voiture voiture2 = new Voiture(true, Taille.G, 13000, 5);
            Avion avion2 = new Avion(2000);
            TrainEtBus train2 = new TrainEtBus(500);
            Utilisateur utilisateur2 = new Utilisateur(alimentation2, bienConso2, logements2, avion2, voiture2, train2, services);

            System.out.println();

            Population population = new Population();
            population.addUtilisateur(utilisateur);
            population.addUtilisateur(utilisateur2);
            //population.display(1);
            //population.removeUtilisateur(2);
            System.out.println(population.toString());
        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }
}
