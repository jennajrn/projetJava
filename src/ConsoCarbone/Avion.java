package ConsoCarbone;

/** Un objet Avion est un Transport qui calcule l’empreinte carbone concernant les déplacements en avion
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Avion extends Transport{
  /** getter de la distance
   * @return la valeur de l'attribut distance
   */
  public int getDistance(){
    return super.distance;
  }

  /** setter de la distance et met à jour l'impact
   * @param distance est la distance parcourue par l'utilisateur en avion
   */
  public void setDistance(int distance){
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    if (distance < 1000){
      setImpact(distance * 0.00023);
    }
    else if (distance < 3500){
      setImpact(distance * 0.00017);
    }
    else{
      setImpact(distance * 0.00015);
    }
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    return "Quand l’utilisateur.rice fait un trajet de " + super.distance + "km en avion alors son impact est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }

  // Constructeurs

  /** constructeur de la classe Avion
   * @param distance est la distance parcourue par l'utilisateur en avion
   */
  public Avion(int distance){
    super();
    if (distance < 0){
      System.out.println("erreur la distance doit être positif");
			distance = 0;
    }
    super.distance = distance;
    if (distance < 1000){
      setImpact(distance * 0.00023);
    }
    else if (distance < 3500){
      setImpact(distance * 0.00017);
    }
    else{
      setImpact(distance * 0.00015);
    }
  }

  /** constructeur de la classe Avion
   */
  public Avion(){
    this(0);
  }
}
