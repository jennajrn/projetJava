package ConsoCarbone;

/** Un objet ServicesPublics est un ConsoCarbone qui calcule l’empreinte carbone concernant l'utilisation des services publics
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class ServicesPublics extends ConsoCarbone{
  private static ServicesPublics singleton = null;

  public static ServicesPublics getInstance(){
    if (singleton == null){
      singleton = new ServicesPublics();
    }
    return singleton;
  }

  public ServicesPublics(){
    super();
    setImpact(1.5);
  }

  public static void empreinteCarboneMoy(){
    System.out.println("Empreinte carbone moyenne des Services Publics : 1489 Kg eq CO2/an" + "\n");
  }

  @Override
  public String toString(){
    return "L'impact pour le poste de consommation carbone induit par les services publics est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
  }
}
