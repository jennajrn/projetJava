package ConsoCarbone;

public class Main{
  public static void main(String[] args){
    Alimentation alimentation = null;
    try {
      alimentation = new Alimentation(0.5,0.4);
    } catch (ErrVal e) {
      System.out.println(e.getMessage());
    }
    System.out.println(alimentation.getImpact());
    BienConso bienConso = new BienConso(10000);
    Logement logement = new Logement(91, CE.A);
    //Transport transport = new Transport(true, Taille.P, 12200, 7);
    ConsoCarbone consoCarbone = new ConsoCarbone();
    //ConsoCarbone conso = new Alimentation(0.5,0.6);


    //alimentation.empreinteCarboneMoy();
    //bienConso.empreinteCarboneMoy();
    //logement.empreinteCarboneMoy();
    //transport.empreinteCarboneMoy();
    //consoCarbone.empreinteCarboneMoy();

    System.out.println(alimentation.toString());
    System.out.println(bienConso.toString());
    System.out.println(logement.toString());
    //System.out.println(transport.toString());
    System.out.println(consoCarbone.toString());
    //System.out.println(conso.toString()); //renvoie la méthode toString de la classe Alimentation
    //conso.getTxVege(); renvoie une erreur car conso est déclaré comme ConsoCarbone

    //System.out.println(conso instanceof ConsoCarbone);
    //System.out.println(conso instanceof Alimentation);
    System.out.println(alimentation instanceof ConsoCarbone);
    System.out.println(alimentation instanceof Alimentation);
    //System.out.println(transport instanceof ConsoCarbone);
  }
}
