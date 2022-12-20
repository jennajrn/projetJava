package ConsoCarbone;

/** La classe ErrVal permet de gérer les différentes exceptions
 */
public class ErrVal extends Exception{
    /** constructeur de la classe ErrVal
     */
    public ErrVal(){}

    /** constructeur de la classe ErrVal
     * @param s qui correpond au message d'erreur à afficher
     */
    public ErrVal(String s){
        super(s);
    }
}
