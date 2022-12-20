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
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public void setDistance(int distance) throws ErrVal{
    if (distance < 0){
      throw new ErrVal("La distance parcourue en train et en bus doit être positive mais est " + distance);
    }
    super.distance = distance;
    setImpact(distance * 0.0001219);
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    return "Quand l’utilisateur.rice parcourt " + super.distance + "km par an en train et en bus alors son impact est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }

  // Constructeurs

  /** constructeur de la classe TrainEtBus
   * @param distance qui est la distance parcourue en train ou en bus par l'utilisateur
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public TrainEtBus(int distance) throws ErrVal{
    super();
    if (distance < 0){
      throw new ErrVal("La distance parcourue en train et en bus doit être positive mais est " + distance);
    }
    super.distance = distance;
    setImpact(distance * 0.00012);
  }

  /** constructeur de la classe TrainEtBus
   * @throws ErrVal afin de s'assurer que distance soit positif
   */
  public TrainEtBus() throws ErrVal{
    this(0);
    if (distance < 0){
      throw new ErrVal("La distance parcourue en train et en bus doit être positive mais est " + distance);
    }
  }
}
