package es.abordonado.socceranalytics.persistence.competition;

import es.abordonado.socceranalytics.AbstractDomainTest;
import es.abordonado.socceranalytics.domain.Competition;
import es.abordonado.socceranalytics.domain.Country;
import es.abordonado.socceranalytics.persistence.country.CountryMapper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;


public class CompetitionMapperTest extends AbstractDomainTest {
    
    @Autowired 
    CompetitionMapper competitionMapper;
    
    @Autowired
    CountryMapper countryMapper;
    
    
    @Test
    public void testCreateNoDuplicate() {
        Country c = countryMapper.findById(new Integer(1));
        Competition cmp1 = new Competition("ESP2");
        cmp1.setCountry(c);
        cmp1.setSeason(2015);
        competitionMapper.create(cmp1);
        
        Competition cmp2 = competitionMapper.findByCodeSeason("ESP2", 2015);
        assertEquals(cmp1, cmp2);
    }
    
    
    @Test(expected = DuplicateKeyException.class)
    public void testCreateDuplicate() {
        Country c = countryMapper.findById(new Integer(1));
        Competition cmp1 = new Competition("ESP1");
        cmp1.setCountry(c);
        cmp1.setSeason(2015);
        competitionMapper.create(cmp1);
        fail("Code duplicated!!!");
    }
    
    
    @Test
    public void testFindByIdIfExists() {
        Competition c = competitionMapper.findById(new Integer(1));
        assertNotNull(c);
        assertEquals(new Integer(1), c.getId());
        assertEquals("ESP1", c.getCode());
        assertEquals("ESP", c.getCountry().getCode());
        assertEquals(new Integer(2015), c.getSeason());
    }
    
    
    @Test
    public void testFindByIdIfNoExists() {
        Competition c = competitionMapper.findById(new Integer(1000));
        assertNull(c);
    }
    
    
    @Test
    public void testFindByCodeSeasonIfExists() {
        Competition c = competitionMapper.findByCodeSeason("ESP1", 2015);
        assertNotNull(c);
    }
    
    
    @Test
    public void testFindByCodeSeasonIfNoExists() {
        Competition c1 = competitionMapper.findByCodeSeason("ESP1", 2016);
        assertNull(c1);
        
        Competition c2 = competitionMapper.findByCodeSeason("ESP2", 2015);
        assertNull(c1);
    }
    

    @Test
    public void testUpdate() {
        Competition c1 = competitionMapper.findByCodeSeason("ESP1", 2015);
        c1.setDescription("updated!!!");
        competitionMapper.update(c1);
        
        Competition c2 = competitionMapper.findByCodeSeason("ESP1", 2015);
        assertEquals(c1, c2);
    }
    

    @Test
    public void testDelete() {
        Competition c1 = competitionMapper.findByCodeSeason("ESP1", 2015);
        assertNotNull(c1);
        competitionMapper.delete(c1);
        
        Competition c2 = competitionMapper.findByCodeSeason("ESP1", 2015);
        assertNull(c2);
    }
    
    
    @Test
    public void testFindAll() {
        assertTrue(competitionMapper.findAll().size() > 0);
    }
    
}
