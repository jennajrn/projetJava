package ConsoCarbone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBienConso{
    private BienConso bienConsoTest;

    @BeforeEach
    public void initBienConso(){
        bienConsoTest = new BienConso();
    }

    @AfterEach
    public void undefBienConso(){
        bienConsoTest = null;
    }

    @Test
    public void setMontantTest(){
        bienConsoTest.setMontant(1750);
        assertEquals(1.0, bienConsoTest.getImpact());
        assertEquals(1750, bienConsoTest.getMontant());
    }

    @Test
    public void setMontantTest2(){
        bienConsoTest.setMontant(1750);
        assertEquals(1.0, bienConsoTest.getImpact());
        assertEquals(10, bienConsoTest.getMontant());
    }
}

