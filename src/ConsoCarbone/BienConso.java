package ConsoCarbone;

import java.io.Serializable;

/** Un objet BienConso est un ConsoCarbone qui calcule l’empreinte carbone concernant les dépenses en biens de consommation
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class BienConso extends ConsoCarbone implements Serializable{
  private double montant; //positif

  /** setter du montant et met à jour l'impact
   * @param montant est le montant des dépenses annuelles de l'utilisateur
   */
  public void setMontant(double montant) throws ErrVal{
    if (montant < 0){
      throw new ErrVal("Le montant doit être positif mais est " + montant);
    }
    this.montant = montant;
    setImpact(this.montant / 1750);
  }

  /** getter du montant
   * @return valeur de l'attribut montant
   */
  public double getMontant(){
    return montant;
  }

  /** affiche le detail de l'empreinte carbone moyenne des francais vis-a-vis des biens de consommations
   */
  public static void empreinteCarboneMoy(){
		System.out.println("Empreinte carbone vis à vis de l'habillement : 763 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis des autres biens et services : 682 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis de l'achat et usages Internet et technologies : 1180 Kg eq CO2/an" + "\n");
  }

  /** methode toString
   * @return chaine de caracteres servant a decrire l'objet concerne
   */
  @Override
  public String toString(){
		return "Quand le montant des dépenses annuelles de l’utilisateur.rice est " + this.montant + ", l'impact de ces dépenses est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
	}

  //Constructeurs

  /** constructeur de la classe BienConso
   * @param montant est le montant des dépenses annuelles de l'utilisateur
   */
  public BienConso(double montant) throws ErrVal{
    super();
    if (montant < 0){
      throw new ErrVal("Le montant doit être positif mais est " + montant);
    }
    this.montant = montant;
    setImpact(this.montant / 1750);
  }

  /** constructeur de la classe BienConso
   */
  public BienConso() throws ErrVal{
    this(0);
    if (montant < 0){
      throw new ErrVal("Le montant doit être positif mais est " + montant);
    }
  }
}
