package es.abordonado.socceranalytics.domain;

import es.abordonado.socceranalytics.Application;
import java.util.HashSet;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TeamTest {
    
    @Test
    public void testEquals() {
        Country c = new Country("ESP");
        Team t1 = new Team("ATM", c);
        Team t2 = new Team("ATM", c);
        Team t3 = new Team("CEL", c);
        assertTrue(t1.equals(t2));
        assertFalse(t1.equals(t3));
        assertFalse(t2.equals(t3));
        
        t1.setName("test");
        assertTrue(t1.equals(t2));
        
        t2.setCode("ZAR");
        assertFalse(t1.equals(t2));
    }
    
    @Test
    public void testContains(){
        Country c = new Country("ESP");
        HashSet<Team> teams = new HashSet<Team>();
        teams.add(new Team("ATM", c));
        teams.add(new Team("BAR", c));
        teams.add(new Team("CEL", c));
        
        assertTrue(teams.contains(new Team("ATM", c)));
        assertTrue(teams.contains(new Team("BAR", c)));
        assertTrue(teams.contains(new Team("CEL", c)));
        assertFalse(teams.contains(new Team("ZAR", c)));        
    }
    
}
