package ConsoCarbone;

/** Un objet BienConso est un ConsoCarbone qui calcule l’empreinte carbone concernant les dépenses en biens de consommation
@author Jenna JOURNO Shana BAROUKH
@version 1.0
*/
public class BienConso extends ConsoCarbone{
  private double montant; //positif

  public void setMontant(double montant){
    if (montant < 0){
			System.out.println("erreur le montant doit être positif");
			montant = 0;
		}
    this.montant = montant;
    setImpact(this.montant / 1750);
  }

  public double getMontant(){
    return montant;
  }

  public static void empreinteCarboneMoy(){
		System.out.println("Empreinte carbone vis à vis de l'habillement : 763 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis des autres biens et services : 682 Kg eq CO2/an" + "\n" + "Empreinte carbone vis à vis de l'achat et usages Internet et technologies : 1180 Kg eq CO2/an" + "\n");
  }

  @Override
  public String toString(){
		return "Quand le montant des dépenses annuelles de l’utilisateur.rice est " + this.montant + ", l'impact de ces dépenses est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
	}

  //Constructeurs

  public BienConso(){
    this(0);
  }

  public BienConso(double montant){
    super();
    if (montant < 0){
      System.out.println("erreur le montant doit être positif");
      montant = 0;
    }
    this.montant = montant;
    setImpact(this.montant / 1750);
  }
}
