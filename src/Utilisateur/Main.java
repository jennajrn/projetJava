package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        try{
            Alimentation alimentation = new Alimentation(0.2,0.5);
            BienConso bienConso = new BienConso(5000);
            Logement logement = new Logement(91, CE.A);
            ArrayList<Logement> logements = new ArrayList<Logement>();
            logements.add(logement);
            Voiture voiture = new Voiture(true, Taille.G, 7000, 9);
            Avion avion = new Avion(7500);
            TrainEtBus train = new TrainEtBus(700);
            ServicesPublics services = new ServicesPublics();
            Utilisateur utilisateur1 = new Utilisateur(alimentation, bienConso, logements, avion, voiture, train, services);

            System.out.println("Information détaillé sur l'utilisateur d'id=1\n");
            utilisateur1.sortConsoCarbone();

            Alimentation alimentation2 = new Alimentation(0.3,0.4);
            BienConso bienConso2 = new BienConso(4000);
            Logement logement2 = new Logement(100, CE.B);
            Logement logement1 = new Logement(150, CE.C);
            ArrayList<Logement> logements2 = new ArrayList<Logement>();
            logements2.add(logement1);
            logements2.add(logement2);
            Voiture voiture2 = new Voiture(true, Taille.P, 5000, 5);
            Avion avion2 = new Avion(2000);
            TrainEtBus train2 = new TrainEtBus(500);
            Utilisateur utilisateur2 = new Utilisateur(alimentation2, bienConso2, logements2, avion2, voiture2, train2, services);

            Utilisateur utilisateur3 = new Utilisateur("Utilisateur.txt");

            System.out.println();

            Population population = new Population();
            population.addUtilisateur(utilisateur1);
            population.addUtilisateur(utilisateur2);
            population.addUtilisateur(utilisateur3);

            System.out.println("Information sur l'utilisateur d'id=3");
            population.display(3);

            population.removeUtilisateur(2); //suppresion de l'utilisateur d'id=2

            System.out.println("Information sur l'ensemble des utilisateurs de la population : ");
            System.out.println(population.toString());

            population.mesuresPolitiques();

        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }
}
