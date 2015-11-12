package es.abordonado.socceranalytics.persistence.country;


import es.abordonado.socceranalytics.AbstractDomainTest;
import es.abordonado.socceranalytics.domain.Country;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import static org.junit.Assert.*;
import org.springframework.dao.DataIntegrityViolationException;


public class CountryMapperTest extends AbstractDomainTest {
    
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
        country.setCode("ESP");
        country.setDescription("España");
        countryMapper.create(country);
        fail("Code duplicated!!!");
    }
    
    
    @Test
    public void testFindByIdIfExists() {
        Country country = countryMapper.findByCode("ESP");
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
        Country country = countryMapper.findByCode("ESP");
        assertNotNull(country);
    }
    
    
    @Test
    public void testFindByCodeIfNoExists() {
        Country country = countryMapper.findByCode("POR");
        assertNull(country);       
    }
    
    
    @Test
    public void testUpdate() {
        Country country = countryMapper.findByCode("ESP");
        country.setDescription("update");
        countryMapper.update(country);
        Country otherCountry = countryMapper.findByCode("ESP");
        assertEquals(country, otherCountry);
    }
    

    @Test
    public void testDelete() {
        Country country = countryMapper.findByCode("POR");
        countryMapper.delete(country);
        country = countryMapper.findByCode("POR");
        assertNull(country);        
    }
    
    
    @Test(expected = DataIntegrityViolationException.class)
    public void testDeleteDataIntegrity() {
        Country country = countryMapper.findByCode("ESP");
        countryMapper.delete(country);
        fail("Data Integrity violantion");
    }
    
    
    @Test
    public void testFindAll() {
        assertTrue(countryMapper.findAll().size() > 0);
    }
    
}
