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
public class CompetitionTest {
    
    @Test
    public void testEquals() {
        Competition c1 = new Competition("CMP1");
        Competition c2 = new Competition("CMP1");
        Competition c3 = new Competition("CMP2");
        
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c2.equals(c3));
        
        c1.setDescription("test");
        assertTrue(c1.equals(c2));
        
        c2.setCode("CMP3");
        assertFalse(c1.equals(c2));
    }
    
    
    @Test
    public void testContains(){
        HashSet<Competition> competitions = new HashSet<Competition>();
        competitions.add(new Competition("CMP1"));
        competitions.add(new Competition("CMP2"));
        competitions.add(new Competition("CMP3"));
        
        assertTrue(competitions.contains(new Competition("CMP1")));
        assertTrue(competitions.contains(new Competition("CMP2")));
        assertTrue(competitions.contains(new Competition("CMP3")));
        assertFalse(competitions.contains(new Competition("CMP4")));        
    }
    
}
