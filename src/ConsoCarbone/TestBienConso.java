package ConsoCarbone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBienConso{
    private BienConso bienConsoTest;

    @BeforeEach
    public void initBienConso(){
        try{
            bienConsoTest = new BienConso();
        }
        catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void undefBienConso(){
        bienConsoTest = null;
    }

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

    @Test
    public void toStringTest(){
        int id = bienConsoTest.getId();
        assertEquals("Quand le montant des dépenses annuelles de l’utilisateur.rice est 0.0, l'impact de ces dépenses est 0.0 TCO2eq. id=" + id + "\n", bienConsoTest.toString());
    }
}

