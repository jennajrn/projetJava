package ConsoCarbone;

/** Un objet TrainEtBus est un Transport qui calcule l’empreinte carbone concernant les déplacements en train et en bus
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class TrainEtBus extends Transport{
  public int getDistance(){
    return super.distance;
  }

  public void setDistance(int distance){
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    setImpact(distance * 0.00012);
  }

  @Override
  public String toString(){
    return "Quand l’utilisateur.rice fait un trajet de " + super.distance + "km en train alors son impact est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }

  // Constructeurs

  public TrainEtBus(int distance){
    super();
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    setImpact(distance * 0.00012);
  }

  public TrainEtBus(){
    this(0);
  }
}
