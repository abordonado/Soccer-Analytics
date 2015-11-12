package es.abordonado.socceranalytics.domain;

import es.abordonado.socceranalytics.Application;
import java.util.HashSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FixtureTest {
    
    Team t1, t2, t3;
    Competition c1;
    
    @Before
    public void beforeTest(){
        Country c = new Country("ES");
       t1 = new Team("ATM", c);
       t2 = new Team("CEL", c);
       t3 = new Team("ZAR", c);
       c1 = new Competition("CMP1");
    }
    
    @Test
    public void testEquals() {
        Fixture f1 = new Fixture((byte)1, t1, t2, c1);
        Fixture f2 = new Fixture((byte)1, t1, t2, c1);
        Fixture f3 = new Fixture((byte)1, t1, t3, c1);
        
        assertTrue(f1.equals(f2));
        assertFalse(f1.equals(f3));
        assertFalse(f2.equals(f3));
        
        f2.setDateSeason((byte)2);
        assertFalse(f1.equals(f2));
    }
    
    
    @Test
    public void testContains(){
        HashSet<Fixture> fixtures = new HashSet<Fixture>();
        fixtures.add(new Fixture((byte)1, t1, t2, c1));
        fixtures.add(new Fixture((byte)2, t1, t3, c1));
        fixtures.add(new Fixture((byte)3, t2, t3, c1));
        
        assertTrue(fixtures.contains(new Fixture((byte)1, t1, t2, c1)));
        assertTrue(fixtures.contains(new Fixture((byte)2, t1, t3, c1)));
        assertTrue(fixtures.contains(new Fixture((byte)3, t2, t3, c1)));
        assertFalse(fixtures.contains(new Fixture((byte)4, t1, t2, c1)));
    }
    
}
