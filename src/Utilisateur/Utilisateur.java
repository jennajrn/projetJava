package Utilisateur;
import ConsoCarbone.*;

import java.util.ArrayList;
import java.util.Comparator;

/** Un objet Utilisateur permet de calculer et de détailler l'empreinte carbone de l'utilisateur
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Utilisateur {
  private Alimentation alimentation;
  private BienConso bienConso;
  private ArrayList<Logement> logements;
  private Avion avion;
  private Voiture voiture;
  private TrainEtBus trainEtBus;
  private ServicesPublics services;
  private static int cpt;
  protected final int id;

  /** calcule l'empreinte carbone de l'utilisateur
   * @return la valeur de l'empreinte carbone total de l'utilisateur
   */
  public double calculerEmpreinte(){
    double impactLogement = 0.0;
    for (int i = 0; i<logements.size(); i++){
      impactLogement = impactLogement + logements.get(i).getImpact();
    }
    double empreinte = alimentation.getImpact() + bienConso.getImpact() + impactLogement + avion.getImpact() + voiture.getImpact() + trainEtBus.getImpact() + services.getImpact();
    return empreinte;
  }

  /** affiche une description detaillee de l'empreinte carbone de l'utilisateur
   */
  public void detaillerEmpreinte(){
    double impactLogement = 0.0;
    for (int i = 0; i<logements.size(); i++){
      impactLogement = impactLogement + logements.get(i).getImpact();
    }
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son alimentation est " + alimentation.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses dépenses en biens de consommation est " + bienConso.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son ou ses logement(s) est " + impactLogement + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en voiture est " + voiture.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en avion est " + avion.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant ses déplacements en train et en bus est " + trainEtBus.getImpact() + " TCO2eq.");
    System.out.println("L’empreinte carbone de l’utilisateur.rice concernant son utilisation des services publics est " + services.getImpact() + " TCO2eq.");
  }

  /** getter de l'id
   * @return la valeur de l'id de l'objet
   */
  public int getId(){
    return id;
  }

  /** setter de alimentation
   * @param txBoeuf qui est le taux de repas à base de boeuf
   * @param txVege qui est le taux de repas vegetariens
   */
  public void setAlimentation(double txBoeuf, double txVege){
    try {
      alimentation = new Alimentation(txBoeuf, txVege);
    } catch (ErrVal e) {
      System.out.println(e.getMessage());
    }
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

  /** setter de logements
   * @param superficies qui est une liste des superficies des logements de l'utilisateur
   * @param ce qui sont les classes energetiques des logements de l'utilisateur
   */
  public void setLogements(int [] superficies, ArrayList<CE> ce){
    for (int i=0; i<ce.size(); i++){
      Logement logement = new Logement(superficies[i], ce.get(i));
      logements.add(logement);
    }
  }

  /** getter de logements
   * @return la liste des logements
   */
  public ArrayList<Logement> getLogements(){
    return this.logements;
  }

  /** setter de avion
   * @param distance qui est la distance parcourue par l'utilisateur en avion
   */
  public void setAvion(int distance){
    try{
      avion = new Avion(distance);
    } catch (ErrVal e){
      System.out.println(e.getMessage());
    }
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

  public void sortConsoCarbone(){
    ArrayList<ConsoCarbone> listeConso = new ArrayList<ConsoCarbone>();
    listeConso.add(alimentation);
    listeConso.add(bienConso);
    for (int i = 0; i<logements.size(); i++){
      listeConso.add(logements.get(i));
    }
    listeConso.add(avion);
    listeConso.add(trainEtBus);
    listeConso.add(voiture);
    listeConso.add(services);
    listeConso.sort(new Comparator<ConsoCarbone>() {
      @Override
      public int compare(ConsoCarbone o1, ConsoCarbone o2){
        return o1.compareTo(o2);
      }
    });

    System.out.println("Ordre de vos consommations carbones (de celui ayant l'impact le plus faible à celui ayant l'impact le plus élevé) : ");
    for(int i = 0; i<listeConso.size(); i++){
      ConsoCarbone conso = listeConso.get(i);
      if (conso == alimentation){
        System.out.println("alimentation avec impact = " + alimentation.getImpact());
      }
      if (conso == bienConso){
        System.out.println("bien conso avec impact = " + bienConso.getImpact());
      }
      for (int j = 0; j<logements.size(); j++){
        if (conso == logements.get(j)){
          System.out.println("logement " + j + " avec impact = " + logements.get(j).getImpact());
        }
      }
      if (conso == avion){
        System.out.println("avion avec impact = " + avion.getImpact());
      }
      if (conso == trainEtBus){
        System.out.println("train et bus avec impact = " + trainEtBus.getImpact());
      }
      if (conso == voiture){
        System.out.println("voiture avec impact = " + voiture.getImpact());
      }
      if (conso == services){
        System.out.println("services publics avec impact = " + services.getImpact());
      }
    }

    System.out.println();

    System.out.println("Recommendations : ");
    for(int i = 0; i<listeConso.size(); i++){
      ConsoCarbone conso = listeConso.get(i);
      if (conso == alimentation){
        if (conso.getImpact() > 2.09){
          System.out.println("Votre empreinte carbone concernant votre alimentation est trop élevé, nous vous recommandons de réduire votre consommation de viande et d'augmenter votre taux de regas végétariens.");
        }
      }
      if (conso == bienConso){
        if (conso.getImpact() > 2.625){
          System.out.println("L'impact de vos dépenses est trop élevé, nous vous recommandons de réduire le montant de vos dépenses.");
        }
      }
      for (int j = 0; j<logements.size(); j++){
        if (conso == logements.get(j)){
          if (conso.getImpact() > 1.696){
            System.out.println("Votre consommation carbone vis-à-vis du logement " + j + " est trop élevé, nous vous recommandons une rénovation énergétique afin de passer à une meilleure classe énergétique.");
          }
        }
      }
      if (conso == avion){
        if (conso.getImpact() > 0.48){
          System.out.println("Vous prenez beaucoup l'avion, pour des courts trajets nous vous recommandons de prendre le train.");
        }
      }
      if (conso == trainEtBus){
        if (conso.getImpact() > 0.085){
          System.out.println("Vous faites trop de trajets en train et en bus, pour limiter les trajets en bus nous vous recommandons de prendre le vélo.");
        }
      }
      if (conso == voiture){
        System.out.println("Vous faites trop de trajets en voiture, nous vous recommandons de prendre le vélo.");
      }
    }
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    String logementToString = "";
    for (int i=0; i<logements.size(); i++){
      logementToString = logementToString + logements.get(i).toString();
    }
    return alimentation.toString() + bienConso.toString() + logementToString + avion.toString() + trainEtBus.toString() + voiture.toString() + services.toString() + "id=" + id + "\n";
  }

  // Constructeurs

  /** constructeur de la classe Utilisateur
   */
  public Utilisateur(){
    cpt++;
    this.id = cpt;
    try{
      this.alimentation = new Alimentation();
      this.bienConso = new BienConso();
      this.logements = new ArrayList<Logement>();
      this.avion = new Avion();
      this.trainEtBus = new TrainEtBus();
      this.voiture = new Voiture();
      this.services = new ServicesPublics();
    } catch (ErrVal e){
      System.out.println(e.getMessage());
    }
  }

  /** constructeur de la classe Utilisateur
   * @param alimentation qui est un objet de la classe Alimentation
   * @param bienConso qui est un objet de la classe BienConso
   * @param logements qui est une liste d'objets de la classe Logement
   * @param avion qui est un objet de la classe Avion
   * @param voiture qui est un objet de la classe Voiture
   * @param trainEtBus qui est un objet de la classe TrainEtBus
   * @param services qui est un objet de la classe ServicesPublics
   */
  public Utilisateur(Alimentation alimentation, BienConso bienConso, ArrayList<Logement> logements, Avion avion, Voiture voiture, TrainEtBus trainEtBus, ServicesPublics services){
    cpt++;
    this.id = cpt;
    this.alimentation = alimentation;
    this.bienConso = bienConso;
    this.logements = logements;
    this.avion = avion;
    this.voiture = voiture;
    this.trainEtBus = trainEtBus;
    this.services = services;
  }
}
