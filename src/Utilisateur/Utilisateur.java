package Utilisateur;
import ConsoCarbone.*;

/** Un objet Utilisateur permet de calculer et de détailler l'empreinte carbone de l'utilisateur
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Utilisateur {
  private Alimentation alimentation;
  private BienConso bienConso;
  private Logement logement;
  private Avion avion;
  private Voiture voiture;
  private TrainEtBus trainEtBus;
  private ServicesPublics services;

  /** calcule l'empreinte carbone de l'utilisateur
   * @return la valeur de l'empreinte carbone total de l'utilisateur
   */
  public double calculerEmpreinte(){
    double empreinte = alimentation.getImpact() + bienConso.getImpact() + logement.getImpact() + avion.getImpact() + voiture.getImpact() + trainEtBus.getImpact() + services.getImpact();
    return empreinte;
  }

  /** affiche une description detaillee de l'empreinte carbone de l'utilisateur
   */
  public void detaillerEmpreinte(){
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son alimentation est " + alimentation.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses dépenses en biens de consommation est " + bienConso.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son logement est " + logement.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en voiture est " + voiture.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en avion est " + avion.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en train et en bus est " + trainEtBus.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son utilisation des services publics est " + services.getImpact() + " TCO2eq.");
  }

  /** setter de alimentation
   * @param txBoeuf qui est le taux de repas à base de boeuf
   * @param txVege qui est le taux de repas vegetariens
   */
  public void setAlimentation(double txBoeuf, double txVege){
    alimentation = new Alimentation(txBoeuf, txVege);
  }

  /** getter de alimentation
   * @return l'objet alimentation
   */
  public Alimentation getAlimentation(){
    return this.alimentation;
  }

  /** setter de bienConso
   * @param montant qui est le montant des dépenses annuelles de l'utilisateur
   */
  public void setBienConso(double montant){
    bienConso = new BienConso(montant);
  }

  /** getter de bienConso
   * @return l'objet bienConso
   */
  public BienConso getBienConso(){
    return this.bienConso;
  }

  /** setter de logement
   * @param superficie qui est la superficie du logement de l'utilisateur
   * @param ce qui est la classe energetique du logement de l'utilisateur
   */
  public void setLogement(int superficie, CE ce){
    logement = new Logement(superficie, ce);
  }

  /** getter de logement
   * @return l'objet logement
   */
  public Logement getLogement(){
    return this.logement;
  }

  /** setter de avion
   * @param distance qui est la distance parcourue par l'utilisateur en avion
   */
  public void setAvion(int distance){
    avion = new Avion(distance);
  }

  /** getter de avion
   * @return l'objet avion
   */
  public Avion getAvion(){
    return this.avion;
  }

  /** getter de voiture
   * @return l'objet voiture
   */
  public Voiture getVoiture(){
    return this.voiture;
  }

  /** setter de voiture
   * @param possede qui est un boolean indiquant si l'utilisateur possede une voiture
   * @param taille qui correspond a la taille du vehicule (P correspondant a petite voiture et G pour grosse voiture)
   * @param distance qui est la distance parcourue en voiture par l'utilisateur
   * @param amortissement qui correspond a la durée de conservation du véhicule
   */
  public void setVoiture(boolean possede, Taille taille, int distance, int amortissement){
    voiture = new Voiture(possede, taille, distance, amortissement);
  }

  /** getter de trainEtBus
   * @return l'objet trainEtBus
   */
  public TrainEtBus getTrainEtBus(){
    return this.trainEtBus;
  }

  /** setter de trainEtBus
   * @param distance qui est la distance parcourue en train ou en bus par l'utilisateur
   */
  public void setTrainEtBus(int distance){
    trainEtBus = new TrainEtBus(distance);
  }

  /** getter de services
   * @return l'objet services
   */
  public ServicesPublics getServices(){
    return this.services;
  }

  /** setter de services
   */
  public void setServices(){
    this.services = new ServicesPublics();
  }

  // Constructeurs

  /** constructeur de la classe Utilisateur
   */
  public Utilisateur(){
    this.alimentation = new Alimentation();
    this.bienConso = new BienConso();
    this.logement = new Logement();
    this.avion = new Avion();
    this.trainEtBus = new TrainEtBus();
    this.voiture = new Voiture();
    this.services = new ServicesPublics();
  }

  /** constructeur de la classe Utilisateur
   * @param alimentation qui est un objet de la classe Alimentation
   * @param bienConso qui est un objet de la classe BienConso
   * @param logement qui est un objet de la classe Logement
   * @param avion qui est un objet de la classe Avion
   * @param voiture qui est un objet de la classe Voiture
   * @param trainEtBus qui est un objet de la classe TrainEtBus
   * @param services qui est un objet de la classe ServicesPublics
   */
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
