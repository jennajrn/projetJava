package ConsoCarbone;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlimentation{
    private Alimentation alimentationTest;

    @BeforeEach
    public void initAlimentation() {
        alimentationTest = new Alimentation();
    }

    @AfterEach
    public void undefAlimentation() {
        alimentationTest = null;
    }

    @Test
    public void setTxVegeTest(){
        alimentationTest.setTxVege(0.5);
        assertEquals(0.5, alimentationTest.getImpact()); //modifier valeur impact
        assertEquals(0.5, alimentationTest.getTxVege());
    }


    @Test
    public void setTxBoeufTest(){
        alimentationTest.setTxBoeuf(0.5);
        assertEquals(0.5, alimentationTest.getImpact()); //modifier valeur impact
        assertEquals(0.5, alimentationTest.getTxBoeuf());
    }
}
