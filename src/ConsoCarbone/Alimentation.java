package ConsoCarbone;

import java.io.Serializable;

/** Un objet Alimentation est un ConsoCarbone qui calcule l’empreinte carbone concernant l'alimentation
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Alimentation extends ConsoCarbone implements Serializable{
	private static final double coeffBoeuf = 8;
	private static final double coeffVolaille = 1.6;
	private static final double coeffVege = 0.9;
	private double txBoeuf; //valeur entre 0 et 1
	private double txVege; //valeur entre 0 et 1

	/** setter de txBoeuf
	 * @param txBoeuf qui est le taux de repas a base de boeuf
	 * @throws ErrVal afin de s'assurer que txBoeuf soit compris entre 0 et 1
	 */
	public void setTxBoeuf(double txBoeuf) throws ErrVal{
		if (txBoeuf < 0 || txBoeuf > 1){
			throw new ErrVal("Le taux de repas à base de boeuf doit être entre 0 et 1 mais est " + txBoeuf);
		}
		this.txBoeuf = txBoeuf;
		setImpact((coeffBoeuf * this.txBoeuf) + coeffVolaille * (1 - this.txVege - this.txBoeuf) + coeffVege * this.txVege);
	}

	/** getter de txBoeuf
	 * @return la valeur de l'attribut txBoeuf
	 */
	public double getTxBoeuf(){
		return txBoeuf;
	}

	/** setter de txVege
	 * @param txVege qui est le le taux de repas vegetariens
	 * @throws ErrVal afin de s'assurer que txVege soit compris entre 0 et 1
	 */
	public void setTxVege(double txVege) throws ErrVal{
		if (txVege < 0 || txVege > 1){
			throw new ErrVal("Le taux de repas végétariens doit être entre 0 et 1 mais est " + txVege);
		}
		this.txVege = txVege;
		setImpact((coeffBoeuf * this.txBoeuf) + coeffVolaille * (1 - this.txVege - this.txBoeuf) + coeffVege * this.txVege);
	}

	/** getter de txVege
	 * @return la valeur de l'attribut txVege
	 */
	public double getTxVege(){
		return txVege;
	}

	/** affiche le detail de l'empreinte carbone moyenne des francais vis-a-vis de l'alimentation
	 */
	public static void empreinteCarboneMoy(){
		System.out.println("Empreinte carbone moyenne vis à vis des boissons : 263 Kg eq CO2/an" + "\n" + "Empreinte carbone moyenne vis à vis des produits laitiers et oeufs : 408 Kg eq CO2/an" + "\n" + "Empreinte carbone moyenne vis à vis des viandes et poissons : 1144 Kg eq CO2/an" + "\n" + "Empreinte carbone moyenne vis à vis des autres : 538 Kg eq CO2/an" + "\n");
	}

	/** methode toString
	 * @return chaine de caracteres servant a decrire l'objet concerne
	 */
	@Override
	public String toString(){
		return "Quand le taux de repas à base de boeuf est de " + this.txBoeuf + " et le taux de repas végétariens est de " + this.txVege + ", l'impact de l'alimentation de l'utilisateur.rice en termes d'émissions de GES est de " + getImpact() + " TCO2eq. id=" + super.id + "\n";
	}

	//Constructeurs

	/** constructeur de la classe Alimentation
	 * @param txBoeuf qui est le le taux de repas a base de boeuf
	 * @param txVege qui est le le taux de repas vegetariens
	 * @throws ErrVal afin de s'assurer que txBoeuf et txVege soient compris entre 0 et 1
	 */
	public Alimentation(double txBoeuf, double txVege) throws ErrVal{
		super();
		if (txBoeuf < 0 || txBoeuf > 1){
			throw new ErrVal("Le taux de repas à base de boeuf doit être entre 0 et 1 mais est " + txBoeuf);
		}
		if (txVege < 0 || txVege > 1){
			throw new ErrVal("Le taux de repas végétariens doit être entre 0 et 1 mais est " + txVege);
		}
		this.txBoeuf = txBoeuf;
		this.txVege = txVege;
		setImpact((coeffBoeuf * this.txBoeuf) + coeffVolaille * (1 - this.txVege - this.txBoeuf) + coeffVege * this.txVege);
	}

	/** constructeur de la classe Alimentation
	 * @throws ErrVal afin de s'assurer que txBoeuf et txVege soient compris entre 0 et 1
	 */
	public Alimentation() throws ErrVal{
		this(0.0, 0.0);
		if (txBoeuf < 0 || txBoeuf > 1){
			throw new ErrVal("Le taux de repas à base de boeuf doit être entre 0 et 1 mais est " + txBoeuf);
		}
		if (txVege < 0 || txVege > 1){
			throw new ErrVal("Le taux de repas végétariens doit être entre 0 et 1 mais est " + txVege);
		}
	}
}
