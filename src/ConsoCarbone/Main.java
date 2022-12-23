package ConsoCarbone;

public class Main{
  public static void main(String[] args){
    try{
      Alimentation alimentation = new Alimentation(0.5,0.4);
      BienConso bienConso = new BienConso(7000);
      Logement logement = new Logement(91, CE.A);
      Avion avion = new Avion(10000);
      Voiture voiture = new Voiture(true, Taille.P, 10000, 7);
      TrainEtBus trainEtBus = new TrainEtBus(500);
      ServicesPublics services = new ServicesPublics();

      System.out.println("Détail de l'empreinte carbone : \n");
      System.out.print(alimentation.toString());
      System.out.print(bienConso.toString());
      System.out.print(logement.toString());
      System.out.print(avion.toString());
      System.out.print(voiture.toString());
      System.out.print(trainEtBus.toString());
      System.out.print(services.toString());

      System.out.println();

      System.out.println("Détail de l'empreinte carbone moyenne des Français : \n");
      alimentation.empreinteCarboneMoy();
      bienConso.empreinteCarboneMoy();
      logement.empreinteCarboneMoy();
      Transport.empreinteCarboneMoy();
      services.empreinteCarboneMoy();
      ConsoCarbone.empreinteCarboneMoy();

      //Test du polymorphisme

      ConsoCarbone consoAl = new Alimentation(0.4,0.3);
      ConsoCarbone consoLo = new Logement(100, CE.C);
      ConsoCarbone consoAv = new Avion(5000);
      ConsoCarbone consoBC = new BienConso(5000);

      System.out.println("Test du polymorphisme : ");
      System.out.print(consoAl.toString()); //renvoie la méthode toString de la classe Alimentation
      System.out.print(consoLo.toString()); //renvoie la méthode toString de la classe Logement
      System.out.print(consoAv.toString()); //renvoie la méthode toString de la classe Avion
      System.out.println(consoBC.toString()); //renvoie la méthode toString de la classe BienConso
      //consoAl.getTxVege(); renvoie une erreur car consoAl est déclaré comme un objet de la classe ConsoCarbone

      //System.out.println(consoAl instanceof ConsoCarbone);
      //System.out.println(consoAl instanceof Alimentation);
      //System.out.println(alimentation instanceof ConsoCarbone);
      //System.out.println(alimentation instanceof Alimentation);
      //System.out.println(avion instanceof ConsoCarbone);
      //System.out.println(avion instanceof Transport);
      //System.out.println(consoAv instanceof ConsoCarbone);
      //System.out.println(consoAv instanceof Transport);
      //System.out.println(consoAv instanceof Avion);
    }
    catch (ErrVal e){
      System.out.println(e.getMessage());
    }
  }
}
