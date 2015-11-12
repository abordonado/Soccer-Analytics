package es.abordonado.socceranalytics.persistence.country;


import es.abordonado.socceranalytics.AbstractDomainTest;
import es.abordonado.socceranalytics.domain.Country;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import static org.junit.Assert.*;


public class CountryTest extends AbstractDomainTest {
    
    @Autowired
    CountryMapper countryMapper;
    
    
    @Test 
    public void testCreateNoDuplicate() {
        Country country = new Country();
        country.setCode("POR");
        country.setDescription("Portugal");
        countryMapper.create(country);
        countryMapper.findById(country.getId());
        assertNotNull(country);
    }
    

    @Test(expected = DuplicateKeyException.class)
    public void testCreateDuplicate() {
        Country country = new Country();
        country.setCode("ES");
        country.setDescription("España");
        countryMapper.create(country);
        fail("Code duplicated!!!");
    }
    
    
    @Test
    public void testFindByIdIfExists() {
        Country country = countryMapper.findByCode("ES");
        Country sameCountry = countryMapper.findById(country.getId());
        assertEquals(country, sameCountry);
    }
    
    
    @Test
    public void testFindByIdIfNoExists() {
        Country country = countryMapper.findById(new Integer(200));
        assertNull(country);       
    }
    
    
    @Test
    public void testFindByCodeIfExists() {
        Country country = countryMapper.findByCode("ES");
        assertNotNull(country);
    }
    
    
    @Test
    public void testFindByCodeIfNoExists() {
        Country country = countryMapper.findByCode("PO");
        assertNull(country);       
    }
    
    
    @Test
    public void testUpdate() {
        Country country = countryMapper.findByCode("ES");
        country.setDescription("update");
        countryMapper.update(country);
        Country otherCountry = countryMapper.findByCode("ES");
        assertEquals(country, otherCountry);
    }
    

    @Test
    public void testDelete() {
        Country country = countryMapper.findByCode("ES");
        countryMapper.delete(country);
        assertEquals(0, countryMapper.findAll().size());
    }

    
    @Test
    public void testFindAll() {
        assertTrue(countryMapper.findAll().size() > 0);
    }
    
}
