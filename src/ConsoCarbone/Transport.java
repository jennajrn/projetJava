package ConsoCarbone;

/** Un objet Transport est un ConsoCarbone qui calcule l’empreinte carbone concernant les déplacements
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public abstract class Transport extends ConsoCarbone{
  protected int distance;

  public abstract int getDistance();
  public abstract void setDistance(int distance);

  public static void empreinteCarboneMoy(){
		System.out.print("Empreinte carbone vis à vis des déplacements en train et bus : 85 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis des déplacements en fret et messagerie : 383 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis des déplacements en avion : 480 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis des déplacements en voiture : 1972 Kg eq CO2/an" + "\n");
  }

  //Constructeurs

  public Transport(){
    super();
  }
}
