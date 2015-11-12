package es.abordonado.socceranalytics.persistence.Team;

import es.abordonado.socceranalytics.AbstractDomainTest;
import es.abordonado.socceranalytics.domain.Country;
import es.abordonado.socceranalytics.domain.Team;
import es.abordonado.socceranalytics.persistence.country.CountryMapper;
import es.abordonado.socceranalytics.persistence.team.TeamMapper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;


public class TeamMapperTest extends AbstractDomainTest {
    
    @Autowired 
    TeamMapper teamMapper;
    
    @Autowired
    CountryMapper countryMapper;
    
    
    @Test
    public void testCreateNoDuplicate() {
        Country c = countryMapper.findById(new Integer(1));
        Team t1 = new Team("SEV", c);
        t1.setName("Sevilla");
        teamMapper.create(t1);
        
        Team t2 = teamMapper.findByCodeCountry("SEV", new Integer(1));
        assertEquals(t1, t2);
    }
    
    
    @Test(expected = DuplicateKeyException.class)
    public void testCreateDuplicate() {
        Country c = countryMapper.findById(new Integer(1));
        Team t1 = new Team("ALB", c);
        t1.setName("Alba");
        teamMapper.create(t1);
        fail("Code duplicated!!!");
    }
    
    
    @Test
    public void testFindByIdIfExists() {
        Team t = teamMapper.findById(new Integer(1));
        assertNotNull(t);
        assertEquals("ALB", t.getCode());
        assertEquals("Albacete", t.getName());
        assertEquals("ESP", t.getCountry().getCode());
        assertEquals("España", t.getCountry().getDescription());
    }
    
    
    @Test
    public void testFindByIdIfNoExists() {
        Team t = teamMapper.findById(new Integer(100));
        assertNull(t);
    }
    
    
    @Test
    public void testFindByCodeIfExists() {
        Team t = teamMapper.findByCodeCountry("ZAR", new Integer(1));
        assertNotNull(t);
    }
    
    
    @Test
    public void testFindByCodeIfNoExists() {
        Team t = teamMapper.findByCodeCountry("ZAR", new Integer(100));
        assertNull(t);
        
        t = teamMapper.findByCodeCountry("JAR", new Integer(1));
        assertNull(t);
    }
    
    
    @Test
    public void testUpdate() {
        Team t1 = teamMapper.findById(new Integer(1));
        t1.setCountry(countryMapper.findById(new Integer(2)));
        teamMapper.update(t1);
        
        Team t2 = teamMapper.findById(new Integer(1));
        assertEquals(t1, t2);
    }
    

    @Test
    public void testDelete() {
        Team t = teamMapper.findById(new Integer(1));
        assertNotNull(t);
        
        teamMapper.delete(t);
        t = teamMapper.findById(new Integer(1));
        assertNull(t);
    }

    
    @Test
    public void testFindAll() {
        assertTrue(teamMapper.findAll().size() > 0);
    }
    
}
