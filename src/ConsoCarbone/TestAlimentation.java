package ConsoCarbone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlimentation{
    private Alimentation alimentationTest;

    @BeforeEach
    public void initAlimentation() {
        try {
            alimentationTest = new Alimentation();
        } catch (ErrVal e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterEach
    public void undefAlimentation() {
        alimentationTest = null;
    }

    @Test
    public void setTxVegeTest(){
        try {
            alimentationTest.setTxVege(0.5);
            assertEquals(1.25, alimentationTest.getImpact());
            assertEquals(0.5, alimentationTest.getTxVege());
        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.2, 0.5, 0.8 })
    public void getTxVegeTest(double arg){
        try {
            alimentationTest.setTxVege(arg);
            assertEquals(arg, alimentationTest.getTxVege());
        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void setTxBoeufTest(){
        try {
            alimentationTest.setTxBoeuf(0.5);
            assertEquals(4.8, alimentationTest.getImpact());
            assertEquals(0.5, alimentationTest.getTxBoeuf());
        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.2, 0.5, 0.8 })
    public void getTxBoeufTest(double arg){
        try{
            alimentationTest.setTxBoeuf(arg);
            assertEquals(arg, alimentationTest.getTxBoeuf());
        } catch (ErrVal e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void toStringTest(){
        int id = alimentationTest.getId();
        assertEquals("Quand le taux de repas à base de boeuf est de 0.0 et le taux de repas végétariens est de 0.0, l'impact de l'alimentation de l'utilisateur.rice en termes d'émissions de GES est de 1.6 TCO2eq. id=" + id + "\n", alimentationTest.toString());
    }
}
