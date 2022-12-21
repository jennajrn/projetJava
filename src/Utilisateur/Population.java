package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;

/** L'objet Population correspond à une liste d'objets de la classe Utilisateur
 */
public class Population{
    private ArrayList<Utilisateur> population;

    /** constructeur de la classe Population
     */
    public Population(){
        population = new ArrayList<Utilisateur>();
    }

    /** getter de population
     * @return la liste d'objet de la classe Utilisateur population
     */
    public ArrayList<Utilisateur> getPopulation(){
        return population;
    }

    /** methode qui permet de rajouter un objet de la classe Utilisateur à la liste
     * @param utilisateur qui correspond à l'objet à rajouter dans la liste
     */
    public void addUtilisateur(Utilisateur utilisateur){
        population.add(utilisateur);
    }

    /** methode qui permet d'afficher les informations de l'utilisateur ayant n comme id
     * @param n qui correspond à l'id de l'utilisateur dont ont veut afficher les informations
     */
    public void display(int n){
        boolean found = false;
        for(int i=0; i < population.size(); i++) {
            if(population.get(i).getId() == n) {
                System.out.println(population.get(i).toString());
                found = true;
            } }
        if(!found)
            System.out.println("Utilisateur d'id=" + n + " n'existe pas.");
    }

    /** methode toString
     * @return chaine de caracteres servant a decrire l'objet concerne
     */
    @Override
    public String toString(){
        String description = "";
        for(Utilisateur u:population){
            description += (u.toString());
        }
        return description;
    }

    /** methode qui permet de supprimer l'utilisateur ayant n comme id dans la liste
     * @param n qui correpond à l'id de l'utilisateur que l'on souhaite supprimet
     */
    public void removeUtilisateur(int n){
        boolean found = false;
        int i=0;
        while((!found) && i<population.size()){
            if (population.get(i).getId() == n){
                found = true;
                population.remove(i);
            }
            i++; }
    }

    /** propose des mesures afin de reduire l'empreinte carbone de la population
     */
    public void mesuresPolitiques(){
        double impactVoitures = 0.0;
        ArrayList<CE> ce = new ArrayList<CE>();
        for (Utilisateur u:population){
            impactVoitures += u.getVoiture().getImpact();
            ArrayList<Logement> logements = u.getLogements();
            for (Logement l:logements){
                ce.add(l.getCe());
            }
        }
        double impactMoyen = impactVoitures/population.size();
        if (impactMoyen>1.972){
            System.out.println("Mesures politiques afin de reduire l'empreinte carbone de la population : ");
            System.out.println("L’empreinte carbone de la population concernant les déplacements en voiture est trop élevé, nous imposons un dimanche sans voiture.");
        }
        boolean found = false;
        for (CE c:ce){
            if(c==CE.E || c==CE.F || c==CE.G){
                found = true;
            }
        }
        if(found){
            if (impactMoyen<=1.972){
                System.out.println("Mesures politiques afin de reduire l'empreinte carbone de la population : ");
            }
            System.out.println("La consommation énergétique du ou des logement(s) de certains utilisateurs est trop élevée, nous incitions ces personnes à la rénovation énergétique de leur(s) logement(s).");
        }
    }
}
