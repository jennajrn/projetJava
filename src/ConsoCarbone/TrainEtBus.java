package ConsoCarbone;

import java.io.Serializable;

/** Un objet TrainEtBus est un Transport qui calcule l’empreinte carbone concernant les déplacements en train et en bus
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class TrainEtBus extends Transport implements Serializable{
  /** getter de distance
   * @return la valeur de l'attribut distance
   */
  public int getDistance(){
    return super.distance;
  }

  /** setter de distance
   * @param distance qui est la distance parcourue en train ou en bus par l'utilisateur
   */
  public void setDistance(int distance){
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    setImpact(distance * 0.00012);
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    return "Quand l’utilisateur.rice fait un trajet de " + super.distance + "km en train alors son impact est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }

  // Constructeurs

  /** constructeur de la classe TrainEtBus
   * @param distance qui est la distance parcourue en train ou en bus par l'utilisateur
   */
  public TrainEtBus(int distance){
    super();
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    setImpact(distance * 0.00012);
  }

  /** constructeur de la classe TrainEtBus
   */
  public TrainEtBus(){
    this(0);
  }
}
