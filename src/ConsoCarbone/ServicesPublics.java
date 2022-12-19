package ConsoCarbone;

import java.io.Serializable;

/** Un objet ServicesPublics est un ConsoCarbone qui calcule l’empreinte carbone concernant l'utilisation des services publics
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class ServicesPublics extends ConsoCarbone implements Serializable{
  private static ServicesPublics singleton = null;

  /** permet de s'assurer qu'il n'y a qu'une seule instance de la classe ServicesPublics
   * @return singleton qui est une instance de la classe ServicesPublics
   */
  public static ServicesPublics getInstance(){
    if (singleton == null){
      singleton = new ServicesPublics();
    }
    return singleton;
  }

  /** constructeur de la classe ServicesPublics
   */
  public ServicesPublics(){
    super();
    setImpact(1.5);
  }

  /** affiche le detail de l'empreinte carbone moyenne des francais vis-a-vis des services publics
   */
  public static void empreinteCarboneMoy(){
    System.out.println("Empreinte carbone moyenne des Services Publics : 1489 Kg eq CO2/an" + "\n");
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
    return "L'impact pour le poste de consommation carbone induit par les services publics est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }
}
