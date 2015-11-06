package es.abordonado.socceranalytics.domain;

import es.abordonado.socceranalytics.Application;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CountryTest {
    
    @Test
    public void testEquals() {
        Country c1 = new Country("ESP");
        Country c2 = new Country("ESP");
        Country c3 = new Country("ITA");
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c2.equals(c3));
        
        c1.setDescription("Spain");
        assertTrue(c1.equals(c2));
        
        c2.setCode("GER");
        assertFalse(c1.equals(c2));
    }
    
    @Test
    public void testContains(){
        HashSet<Country> countries = new HashSet<Country>();
        countries.add(new Country("ESP"));
        countries.add(new Country("ITA"));
        countries.add(new Country("GER"));
        
        assertTrue(countries.contains(new Country("ESP")));
        assertTrue(countries.contains(new Country("ITA")));
        assertTrue(countries.contains(new Country("GER")));
        assertFalse(countries.contains(new Country("BEL")));        
    }
    
}
