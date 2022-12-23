package ConsoCarbone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** La classe TestBienConso permet de faire des test sur certaines methodes de la classe BienConso
 */
public class TestBienConso{
    private BienConso bienConsoTest;

    /** methode effectuee avant chaque test afin d'initialiser l'objet bienConsoTest
     */
    @BeforeEach
    public void initBienConso(){
        try{
            bienConsoTest = new BienConso();
        }
        catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    /** methode effectuee après chaque test afin de remettre à null l'objet bienConsoTest
     */
    @AfterEach
    public void undefBienConso(){
        bienConsoTest = null;
    }

    /** methode qui test la methode setMontant de la classe BienConso
     */
    @Test
    public void setMontantTest(){
        try{
            bienConsoTest.setMontant(1750);
            assertEquals(1.0, bienConsoTest.getImpact());
            assertEquals(1750, bienConsoTest.getMontant());
        }
        catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    /** methode qui test la methode getMontant de la classe BienConso
     * @param arg qui est la valeur à tester
     */
    @ParameterizedTest
    @ValueSource(ints = { 2000, 2500, 3000, 3250 })
    public void getMontantTest(int arg){
        try{
            bienConsoTest.setMontant(arg);
            assertEquals(arg, bienConsoTest.getMontant());
        }
        catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    /** methode qui test la methode toString de la classe BienConso
     */
    @Test
    public void toStringTest(){
        int id = bienConsoTest.getId();
        assertEquals("Quand le montant des dépenses annuelles de l’utilisateur.rice est 0.0, l'impact de ces dépenses est 0.0 TCO2eq. id=" + id + "\n", bienConsoTest.toString());
    }
}

