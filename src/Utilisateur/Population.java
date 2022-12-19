package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;

public class Population{
    private ArrayList<Utilisateur> population;

    public Population(){
        population = new ArrayList<Utilisateur>();
    }

    public void addUtilisateur(Utilisateur utilisateur){
        population.add(utilisateur);
    }

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

    @Override
    public String toString(){
        String description = "";
        for(Utilisateur u:population){
            description += (u.toString());
        }
        return description;
    }

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
            System.out.println("L’empreinte carbone de la population concernant les déplacements en voiture est trop élevé, nous imposons un dimanche sans voiture.");
        }
        boolean found = false;
        for (CE c:ce){
            if(c==CE.E || c==CE.F || c==CE.G){
                found = true;
            }
        }
        if(found){
            System.out.println("La consommation énergétique du ou des logement(s) de certains utilisateurs est trop élevée, nous incitions ces personnes à la rénovation énergétique de leur(s) logement(s).");
        }
    }
}
