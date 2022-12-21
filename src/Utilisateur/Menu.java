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
        System.out.println("Tapez 3 pour créer une population.");
    }


    /** creer un objet de la classe Utilisateur a partir des donnees entrees par l'utilisateur
     * @return l'objet de la classe Utilisateur qui a ete cree a l'aide des informations entrees par l'utilisateur
     * @throws ErrVal afin de s'assurer que les valeurs entrees par l'utilisateur correspondent a ce qui est attendu
     */
    public static Utilisateur creerUtilisateur() throws ErrVal{
        Utilisateur utilisateur = null;
        try{
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
            if (!possedeVoiture.equals("true") && !possedeVoiture.equals("false")){
                throw new ErrVal("il faut entrer true ou false mais vous avez entré " + possedeVoiture);
            }
            Voiture voiture = null;
            if (Boolean.valueOf(possedeVoiture).booleanValue()){
                System.out.println("Avez vous une petite ou une grosse voiture ?");
                String tailleVoiture = scan.nextLine();
                Taille taille;
                if (!tailleVoiture.equals("petite") && !tailleVoiture.equals("grosse")){
                    throw new ErrVal("il faut entrer petite ou grosse mais vous avez entré " + tailleVoiture);
                }
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
                if (!autreLogement.equals("oui") && !autreLogement.equals("non")){
                    throw new ErrVal("il faut entrer oui ou non mais vous avez entré " + autreLogement);
                }
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
            utilisateur = new Utilisateur(alimentation, bienConso, logements, avion, voiture, trainEtBus, services);
            return utilisateur;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return utilisateur;
    }

    /** ecrit un objet de la classe Utilisateur dont les informations sont donnees par l'utilisateur, dans un fichier dont le nom est egalement donne par l'utilisateur
     */
    public static void ecrireUtilisateur(){
        try{
            System.out.println("Fichier dans lequel vous voulez écrire : ");
            String s = scan.nextLine();
            Utilisateur utilisateur = creerUtilisateur();
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

    /** creer un objet de la classe Population a partir des donnees rentrees par l'utilisateur
     * @throws ErrVal afin de s'assurer que les valeurs entrees par l'utilisateur correspondent a ce qui est attendu
     */
    public static void creerPopulation() throws ErrVal{
        try{
            Population population = new Population();
            boolean quit = false;
            do{
                System.out.println("Donnez les informations sur l'utilisateur de votre population.");
                Utilisateur utilisateur = creerUtilisateur();
                population.addUtilisateur(utilisateur);
                System.out.println("Voulez-vous ajouter un autre utilisateur à votre population (oui ou non)?");
                String autreUtilisateur = scan.nextLine();
                if (!autreUtilisateur.equals("oui") && !autreUtilisateur.equals("non")){
                    throw new ErrVal("il faut entrer oui ou non mais vous avez entré " + autreUtilisateur);
                }
                if (autreUtilisateur.equals("non")){
                    quit = true;
                }
            }while (quit == false);
            boolean quit1 = false;
            while (quit1 == false){
                System.out.println("Voulez-vous afficher les informations concernant un utilisateur (oui ou non)?");
                String displayUtilisateur = scan.nextLine();
                if (!displayUtilisateur.equals("oui") && !displayUtilisateur.equals("non")){
                    throw new ErrVal("il faut entrer oui ou non mais vous avez entré " + displayUtilisateur);
                }
                if (displayUtilisateur.equals("oui")){
                    System.out.println("Quel est l'id de cet utilisateur ?");
                    String n = scan.nextLine();
                    population.display(Integer.valueOf(n));
                }
                else{
                    quit1 = true;
                }
            }
            System.out.println("Voulez-vous afficher les informations concernant l'ensemble des utilisateurs de la population (oui ou non)?");
            String toStringPopulation = scan.nextLine();
            if (!toStringPopulation.equals("oui") && !toStringPopulation.equals("non")){
                throw new ErrVal("il faut entrer oui ou non mais vous avez entré " + toStringPopulation);
            }
            if (toStringPopulation.equals("oui")){
                System.out.println(population.toString());
            }
            population.mesuresPolitiques();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try{
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
                    case(3):
                        creerPopulation();
                        break;
                    default:
                        System.out.println("Cette valeur ne fait pas partie des possibilités.");
                }
            }while(quit == false);
            scan.close();
        }
        catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }
}