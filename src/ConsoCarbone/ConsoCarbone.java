package ConsoCarbone;

import java.io.Serializable;

/** Un objet ConsoCarbone représente un poste de consommation carbone générique
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class ConsoCarbone implements Comparable<ConsoCarbone>, Serializable{
  protected final int id;
  private double impact;
  private static int cpt;

  /** permet de comparer deux instances de ConsoCarbone en fonction de leur impact
   * @param c l'instance que l'on compare
   * @return 0 si c'est le même impact, 1 si l'impact de l'objet prit en parametre est inferieur et -1 si l'impact de l'objet prit en parametre est superieur
  */
  public int compareTo(ConsoCarbone c){
    if (c.getImpact() == this.getImpact()){
      return 0;
    }
    else if (c.getImpact() < this.getImpact()){
      return 1;
    }
    else{
      return -1;
    }
  }

  /** getter de l'id
   * @return la valeur de l'id de l'objet
  */
  public int getId(){
    return id;
  }

  /** setter de l'impact
   * @param impact est l'impact de l'utilisateur en termes d’émissions de GES en TCO2eq
   */
  public void setImpact(double impact){
    this.impact = impact;
  }

  /** getter de l'impact
   * @return la valeur de l'impact de l'utilisateur
  */
  public double getImpact(){
    return impact;
  }

  /** affiche l'empreinte carbone moyenne des Francais
  */
  public static void empreinteCarboneMoy(){
    System.out.println("Empreinte carbone moyenne des Français : 12 092 Kg eq CO2/an" + "\n");
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
  */
  public String toString(){
    return "L'impact est de " + this.impact + " TCO2eq. id=" + this.id + "\n";
  }

  /** constructeur de la classe ConsoCarbone
   */
  public ConsoCarbone(){
    cpt++;
    this.id = cpt;
    this.impact = 0;
  }
}
