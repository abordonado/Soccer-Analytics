package es.abordonado.socceranalytics.persistence.fixture;

import es.abordonado.socceranalytics.domain.Fixture;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface FixtureMapper {
    
    //CRUD
    void create(Fixture fixture);
    Fixture findById(Integer id);
    Fixture findByCompetitionDateHomeAway(
            @Param("competition") Integer idCompetition,
            @Param("dateSeason")  byte dateSeason,
            @Param("homeTeam")    Integer idHomeTeam,
            @Param("awayTeam")    Integer idAwayTeam);
    
    void update(Fixture fixture);
    void delete(Fixture fixture);
            
    
    //OTHER's
    List<Fixture> findAll();
    
}
