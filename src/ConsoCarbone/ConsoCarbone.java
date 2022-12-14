package ConsoCarbone;

/** Un objet ConsoCarbone
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class ConsoCarbone implements Comparable<ConsoCarbone>{
  protected final int id;
  private double impact;
  private static int cpt;

  /** permet de comparer deux instances de ConsoCarbone en fonction de leur impact
  @param c l'instance que l'on compare
  @return 0 si c'est le même impact, 1 si l'impact de l'objet prit en parametre est inferieur et -1 si l'impact de l'objet prit en parametre est superieur
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

  /** renvoie l'id
  @return valeur de l'id de l'objet
  */
  public int getId(){
    return id;
  }

  public void setImpact(double impact){
    this.impact = impact;
  }

  /** renvoie l'impact
  @return valeur de l'impact de l'objet
  */
  public double getImpact(){
    return impact;
  }

  /** affiche l'empreinte carbone moyenne des Francais
  */
  public static void empreinteCarboneMoy(){
    System.out.println("Empreinte carbone moyenne des Français : 12 092 kg/an" + "\n");
  }

  /** methode toString
  @return chaîne de caractères servant à décrire l'objet concerné
  */
  public String toString(){
    return "L'impact est de " + this.impact + " TCO2eq. id=" + this.id + "\n";
  }

  public ConsoCarbone(){
    cpt++;
    this.id = cpt;
    this.impact = 0;
  }
}
