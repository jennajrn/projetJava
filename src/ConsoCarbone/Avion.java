package ConsoCarbone;

import java.io.Serializable;

/** Un objet Avion est un Transport qui calcule l’empreinte carbone concernant les deplacements en avion
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Avion extends Transport implements Serializable{
  /** getter de la distance
   * @return la valeur de l'attribut distance
   */
  public int getDistance(){
    return super.distance;
  }

  /** setter de la distance et met à jour l'impact
   * @param distance est la distance parcourue par l'utilisateur en avion
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public void setDistance(int distance) throws ErrVal{
    if (distance < 0){
      throw new ErrVal("La distance parcourue en avion doit être positive mais est " + distance);
    }
    super.distance = distance;
    if (distance < 1000){
      setImpact(distance * 0.00023);
    }
    else if (distance < 3500){
      setImpact(distance * 0.0001784);
    }
    else{
      setImpact(distance * 0.00015166);
    }
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    return "Quand l’utilisateur.rice parcourt " + super.distance + "km par an en avion alors son impact est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }

  // Constructeurs

  /** constructeur de la classe Avion
   * @param distance est la distance parcourue par l'utilisateur en avion
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public Avion(int distance) throws ErrVal{
    super();
    if (distance < 0){
      throw new ErrVal("La distance parcourue en voiture doit être positive mais est " + distance);
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
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public Avion() throws ErrVal{
    this(0);
    if (distance < 0){
      throw new ErrVal("La distance parcourue en avion doit être positive mais est " + distance);
    }
  }
}
