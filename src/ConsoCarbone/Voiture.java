package ConsoCarbone;

import java.io.Serializable;

/** Un objet Voiture est un Transport qui calcule l’empreinte carbone concernant les déplacements en voiture
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Voiture extends Transport implements Serializable{
  private boolean possede;
  private Taille taille;
  private int amortissement; //positif

  /** setter de possede
   * @param possede qui est un boolean indiquant si l'utilisateur possede une voiture
   */
  public void setPossede(boolean possede){
    this.possede = possede;
    if (possede == true){
      setImpact((super.distance * 1.93 * 0.0001) + (taille.getFabrication() / this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  /** getter de possede
   * @return la valeur de l'attribut possede c'est-a-dire true si l'utilisateur possede une voiture et false sinon
   */
  public boolean getPossede(){
    return possede;
  }

  /** setter de taille
   * @param taille qui correspond a la taille du vehicule (P correspondant a petite voiture et G pour grosse voiture)
   */
  public void setTaille(Taille taille){
    this.taille = taille;
    if (possede == true){
      setImpact((super.distance * 1.93 * 0.0001) + (taille.getFabrication() / this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  /** getter de taille
   * @return la valeur de l'attribut taille c'est-a-dire P si il s'agit d'une petite voiture et G si il s'agit d'une grosse voiture
   */
  public Taille getTaille(){
    return taille;
  }

  /** setter de distance
   * @param distance qui est la distance parcourue en voiture par l'utilisateur
   */
  public void setDistance(int distance){
    if (distance < 0){
      System.out.println("erreur le nombre de kilomètres parcourus par an doit être positif");
			distance = 0;
    }
    super.distance = distance;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  /** getter de distance
   * @return la valeur de l'attribut distance
   */
  public int getDistance(){
    return distance;
  }

  /** setter de amortissement
   * @param amortissement qui correspond a la durée de conservation du véhicule
   */
  public void setAmortissement(int amortissement){
    if (amortissement < 0){
      System.out.println("erreur durée de conservation du véhicule doit être positif");
			amortissement = 0;
    }
    this.amortissement = amortissement;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }

  /** getter de amortissement
   * @return la valeur de l'attribut amortissement
   */
  public int getAmortissement(){
    return amortissement;
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
		if(possede==false){
      return "L’utilisateur.rice. ne possède pas de voiture alors l'impact des déplacements de l’utilisateur.rice sera de 0 TCO2eq. id=" + super.id + "\n";
    }
    else if (taille==Taille.P){
      return "Quand l’utilisateur.rice. possède une petite voiture, que le nombre de kilomètres parcourus est " + super.distance + " par an et que la durée de conservation du véhicule est " + this.amortissement + ", l'impact de ces déplacements est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
    }
    else{
      return "Quand l’utilisateur.rice. possède une grande voiture, que le nombre de kilomètres parcourus est " + super.distance + " par an et que la durée de conservation du véhicule est " + this.amortissement + ", l'impact de ces déplacements est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
    }
	}

  //Constructeurs

  /** constructeur de la classe Voiture
   */
  public Voiture(){
    this(false, Taille.P, 0, 0);
  }

  /** constructeur de la classe Voiture
   * @param possede qui est un boolean indiquant si l'utilisateur possede une voiture
   * @param taille qui correspond a la taille du vehicule (P correspondant a petite voiture et G pour grosse voiture)
   * @param distance qui est la distance parcourue en voiture par l'utilisateur
   * @param amortissement qui correspond a la durée de conservation du véhicule
   */
  public Voiture(boolean possede, Taille taille, int distance, int amortissement){
    super();
    if (distance < 0){
      System.out.println("erreur le nombre de kilomètres parcourus par an doit être positif");
			distance = 0;
    }
    if (amortissement < 0){
      System.out.println("erreur durée de conservation du véhicule doit être positif");
			amortissement = 0;
    }
    this.possede = possede;
    this.taille = taille;
    super.distance = distance;
    this.amortissement = amortissement;
    if (possede == true){
      setImpact((super.distance*1.93*0.0001)+(taille.getFabrication()/this.amortissement));
    }
    else{
      setImpact(0);
    }
  }
}
