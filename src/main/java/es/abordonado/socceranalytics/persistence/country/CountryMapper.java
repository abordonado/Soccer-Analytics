package es.abordonado.socceranalytics.persistence.country;

import es.abordonado.socceranalytics.domain.Country;
import java.util.List;


public interface CountryMapper {
    
    //CRUD
    void create(Country country);
    Country findById(Integer id);
    Country findByCode(String code);    
    void update(Country country);
    void delete(Country country);
    
    //OTHER's
    List<Country> findAll();
    
}
