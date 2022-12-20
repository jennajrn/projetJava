package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/** La classe Menu est un menu interactif permettant d'interagir dans la console avec l'utilisateur du programme
 */
public class Menu{
    private static Scanner scan = new Scanner(System.in);

    /** affiche le menu sur la console
     */
    public static void printMenu(){
        System.out.println("-------------");
        System.out.println("Voici le Menu");
        System.out.println("-------------");
        System.out.println("Tapez 0 pour sortir du menu.");
        System.out.println("Tapez 1 pour écrire un Utilisateur dans un fichier.");
        System.out.println("Tapez 2 pour lire un Utilisateur dans un fichier.");
    }

    /** ecrit un objet de la classe Utilisateur dont les informations sont donnees par l'utilisateur, dans un fichier dont le nom est egalement donne par l'utilisateur
     */
    public static void ecrireUtilisateur(){
        try{
            System.out.println("Fichier dans lequel vous voulez écrire : ");
            String s = scan.nextLine();
            System.out.println("Quel est votre taux de repas à base de boeuf ?");
            String txBoeuf = scan.nextLine();
            System.out.println("Quel est votre taux de repas végétariens ?");
            String txVege = scan.nextLine();
            Alimentation alimentation = new Alimentation(Double.valueOf(txBoeuf), Double.valueOf(txVege));
            System.out.println("Quel est le montant de vos dépenses ?");
            String montant = scan.nextLine();
            BienConso bienConso = new BienConso(Double.valueOf(montant));
            System.out.println("Possedez vous une voiture (true si oui, false sinon) ?");
            String possedeVoiture = scan.nextLine();
            Voiture voiture = null;
            if (Boolean.valueOf(possedeVoiture).booleanValue()){
                System.out.println("Avez vous une petite ou une grosse voiture ?");
                String tailleVoiture = scan.nextLine();
                Taille taille;
                System.out.println(tailleVoiture);
                if (tailleVoiture.equals("petite")){
                    taille = Taille.P;
                }
                else{
                    taille = Taille.G;
                }
                System.out.println("Quel est votre nombre de kilomètres parcourue par an en voiture ?");
                String distanceVoiture = scan.nextLine();
                System.out.println("Quel est votre durée de conservation du véhicule ?");
                String amortissement = scan.nextLine();
                voiture = new Voiture(Boolean.valueOf(possedeVoiture).booleanValue(), taille, Integer.valueOf(distanceVoiture), Integer.valueOf(amortissement));
            }
            else{
                voiture = new Voiture(false, Taille.P, 0, 0);
            }
            System.out.println("Quel est votre nombre de kilomètres parcourue par an en avion ?");
            String distanceAvion = scan.nextLine();
            Avion avion = new Avion(Integer.valueOf(distanceAvion));
            System.out.println("Quel est votre nombre de kilomètres parcourue par an en train et en bus ?");
            String distanceTrainEtBus = scan.nextLine();
            TrainEtBus trainEtBus = new TrainEtBus(Integer.valueOf(distanceTrainEtBus));
            System.out.println("Quel est la superficie en m^2 de votre logement ?");
            String superficie = scan.nextLine();
            System.out.println("Quel est la classe énergétique de votre logement (A,B,C,D,E,F ou G) ?");
            String ce = scan.nextLine();
            Logement logement1 = new Logement(Integer.valueOf(superficie), CE.value(ce));
            ArrayList<Logement> logements = new ArrayList<Logement>();
            logements.add(logement1);
            boolean quit = false;
            do{
                System.out.println("Avez vous un autre logement (oui ou non) ?");
                String autreLogement = scan.nextLine();
                if (autreLogement.equals("oui")){
                    System.out.println("Quel est la superficie en m^2 de votre logement ?");
                    String superficie2 = scan.nextLine();
                    System.out.println("Quel est la classe énergétique de votre logement (A,B,C,D,E,F ou G) ?");
                    String ce2 = scan.nextLine();
                    Logement logement2 = new Logement(Integer.valueOf(superficie2), CE.value(ce2));
                    logements.add(logement2);
                }
                else{
                    quit = true;
                }
            } while (quit == false);
            ServicesPublics services = new ServicesPublics();
            Utilisateur utilisateur = new Utilisateur(alimentation, bienConso, logements, avion, voiture, trainEtBus, services);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(s), true));
            oos.writeObject(utilisateur);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /** lit un objet de la classe Utilisateur contenu dans un fichier dont le nom est donne par l'utilisateur et l'affiche sur la console
     */
    public static void lireUtilisateur(){
        try{
            System.out.println("Fichier que vous voulez lire : ");
            String s = scan.nextLine();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(s)));
            Utilisateur utilisateur = (Utilisateur) ois.readObject();
            System.out.println(utilisateur);
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        boolean quit = false;
        do{
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case(0):
                    quit = true;
                    break;
                case(1):
                    ecrireUtilisateur();
                    break;
                case(2):
                    lireUtilisateur();
                    break;
                default:
                    System.out.println("Cette valeur ne fait pas partie des possibilités.");
            }
        }while(quit == false);
        scan.close();
    }
}
