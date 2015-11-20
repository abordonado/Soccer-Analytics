package es.abordonado.socceranalytics.persistence.competition;

import es.abordonado.socceranalytics.domain.Competition;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface CompetitionMapper {
    
    //CRUD
    void create(Competition competition);
    Competition findById(Integer id);
    Competition findByCodeSeason(@Param("code")String code, @Param("season") Integer season);    
    void update(Competition competition);
    void delete(Competition competition);
    
    //OTHER's
    List<Competition> findAll();
    
}
