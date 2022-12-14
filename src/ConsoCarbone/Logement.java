package ConsoCarbone;

/** Un objet Logement est un ConsoCarbone qui calcule l’empreinte carbone concernant le logement
 * @author Jenna JOURNO Shana BAROUKH
 * @version 1.0
*/
public class Logement extends ConsoCarbone{
	private int superficie; //positif
	private CE ce;

	/** getter de la superficie
	 * @return la valeur de l'attribut superficie
	 */
	public int getSuperficie(){
		return superficie;
	}

	/** actualiser les variables superficie et impact
	 * @param superficie qui est la superficie du logement de l'utilisateur
	 */
	public void setSuperficie(int superficie){
		if (superficie < 0){
			System.out.println("erreur la superficie doit être positif");
			superficie = 0;
		}
		this.superficie = superficie;
		setImpact(this.ce.getAlphaCE() * this.superficie);
	}

	/** getter de la classe energetique ce
	 * @return la valeur de l'attribue ce
	 */
	public CE getCe(){
		return ce;
	}

	/** setter de la classe energetique ce
	 * @param ce qui est la classe energetique du logement de l'utilisateur
	 */
	public void setCe(CE ce){
		this.ce = ce;
		setImpact(ce.getAlphaCE() * this.superficie);
	}

	/** affiche le detail de l'empreinte carbone moyenne des francais vis-a-vis du logement
	 */
	public static void empreinteCarboneMoy(){
		System.out.println("Empreinte carbone moyenne vis à vis des equipements des logements : 335 Kg eq CO2/an" + "\n" + "Empreinte carbone moyenne vis à vis des constructions et gros entretien : 675 Kg eq CO2/an" + "\n" + "Empreinte carbone moyenne vis à vis des énergies et utilités : 1696 Kg eq CO2/an");
	}

	/** methode toString
	 * @return chaine de caracteres servant a decrire l'objet concerne
	 */
	@Override
	public String toString(){
		return "Quand la superficie est de " + this.superficie + "m^2, et la classe énergétique du logement est la classe " + this.ce + ", l'impact du logement en termes d’émissions de GES est " + getImpact() + " TCO2eq. id=" + super.id + "\n";
	}

	//Constructeurs

	/** constructeur de la classe Logement
	 * @param superficie qui est la superficie du logement de l'utilisateur
	 * @param ce qui est la classe energetique du logement de l'utilisateur
	 */
	public Logement(int superficie, CE ce){
		super();
		if (superficie < 0){
			System.out.println("erreur la superficie doit être positif");
			superficie = 0;
		}
		this.superficie = superficie;
		this.ce = ce;
		setImpact(ce.getAlphaCE() * this.superficie);
	}

	/** constructeur de la classe Logement
	 */
	public Logement(){
		this(0, CE.A);
	}
}
