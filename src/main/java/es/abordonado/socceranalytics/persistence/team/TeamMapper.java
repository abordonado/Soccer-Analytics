package es.abordonado.socceranalytics.persistence.team;

import es.abordonado.socceranalytics.domain.Team;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface TeamMapper {
    
    //CRUD
    void create(Team Team);
    Team findById(Integer id);
    Team findByCodeCountry(@Param("code")String code, @Param("country") Integer idCountry);    
    void update(Team team);
    void delete(Team team);
    
    //OTHER's
    List<Team> findAll();
    
}
