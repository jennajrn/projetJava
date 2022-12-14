package Utilisateur;
import ConsoCarbone.*;

/** Un objet Utilisateur permet de calculer et de détailler l'empreinte carbone de l'utilisateur
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class Utilisateur {
  private Alimentation alimentation;
  private BienConso bienConso;
  private Logement logement;
  private Avion avion;
  private Voiture voiture;
  private TrainEtBus trainEtBus;
  private ServicesPublics services;

  public double calculerEmpreinte(){
    double empreinte = alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + avion.getImpact() + voiture.getImpact() + trainEtBus.getImpact() + services.getImpact();
    return empreinte;
  }

  public void detaillerEmpreinte(){
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son alimentation est " + alimentation.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses dépenses en biens de consommation est " + bienConso.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son logement est " + logement.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en voiture est " + voiture.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en avion est " + avion.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en train et en bus est " + trainEtBus.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son utilisation des services publics est " + services.getImpact() + " TCO2eq.");
  }

  public void setAlimentation(double txBoeuf, double txVege){
    alimentation = new Alimentation(txBoeuf, txVege);
  }

  public Alimentation getAlimentation(){
    return this.alimentation;
  }

  public void setBienConso(double montant){
    bienConso = new BienConso(montant);
  }

  public BienConso getBienConso(){
    return this.bienConso;
  }

  public void setLogement(int superficie, CE ce){
    logement = new Logement(superficie, ce);
  }

  public Logement getLogement(){
    return this.logement;
  }

  public void setAvion(){
    avion = new Avion();
  }

  public Avion getAvion(){
    return this.avion;
  }

  public Voiture getVoiture(){
    return this.voiture;
  }

  public void setVoiture(){
    voiture = new Voiture();
  }

  public TrainEtBus getTrainEtBus(){
    return this.trainEtBus;
  }

  public void setTrainEtBus(){
    trainEtBus = new TrainEtBus();
  }

  public ServicesPublics getServicesPublics(){
    return this.services;
  }

  // Constructeurs

  public Utilisateur(){
    this.alimentation = new Alimentation();
    this.bienConso = new BienConso();
    this.logement = new Logement();
    this.avion = new Avion();
    this.trainEtBus = new TrainEtBus();
    this.voiture = new Voiture();
    this.services = new ServicesPublics();
  }

  public Utilisateur(Alimentation alimentation, BienConso bienConso, Logement logement, Avion avion, Voiture voiture, TrainEtBus trainEtBus, ServicesPublics services){
    this.alimentation = alimentation;
    this.bienConso = bienConso;
    this.logement = logement;
    this.avion = avion;
    this.voiture = voiture;
    this.trainEtBus = trainEtBus;
    this.services = services;
  }
}
