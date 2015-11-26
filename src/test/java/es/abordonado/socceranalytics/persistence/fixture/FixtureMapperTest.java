package es.abordonado.socceranalytics.persistence.fixture;

import es.abordonado.socceranalytics.AbstractDomainTest;
import es.abordonado.socceranalytics.domain.Competition;
import es.abordonado.socceranalytics.domain.Fixture;
import es.abordonado.socceranalytics.domain.Team;
import es.abordonado.socceranalytics.persistence.competition.CompetitionMapper;
import es.abordonado.socceranalytics.persistence.country.CountryMapper;
import es.abordonado.socceranalytics.persistence.team.TeamMapper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;


public class FixtureMapperTest extends AbstractDomainTest{
    
    @Autowired FixtureMapper fixtureMapper;
    @Autowired CountryMapper countryMapper;
    @Autowired TeamMapper teamMapper;
    @Autowired CompetitionMapper competitionMapper;
    
    
    @Test
    public void testCreateNoDuplicated(){
        byte dateSeason = 2;
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f1 = new Fixture(dateSeason, team1, team2, competition);
        fixtureMapper.create(f1);
        
        Integer c1 = competition.getId();
        Integer t1 = team1.getId();
        Integer t2 = team2.getId();
        
        Fixture f2 = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        assertEquals(f1.getDateSeason(), f2.getDateSeason());
        assertEquals(f1.getHomeTeam().getId(), f2.getHomeTeam().getId());
        assertEquals(f1.getAwayTeam().getId(), f2.getAwayTeam().getId());
        assertEquals(f1.getCompetition().getId(), f2.getCompetition().getId());
        //TODO: Load all dependencies in mapper
        //assertEquals(f1, f2);
    }
    
    
    @Test(expected = DuplicateKeyException.class)
    public void testCreateDuplicate() {
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f1 = new Fixture((byte) 1, team1, team2, competition);
        fixtureMapper.create(f1);
        fail("Code duplicated!!!");
    }
    

    @Test
    public void testFindByIdIfExists() {
        Fixture f = fixtureMapper.findById(new Integer(1));
        assertNotNull(f);
        //TODO: Add more asserts
    }
    
    
    @Test
    public void testFindByIdIfNoExists() {
        Fixture f = fixtureMapper.findById(new Integer(100));
        assertNull(f);
    }
    
    
    @Test
    public void testFindByCompetitionDateHomeAwayIfExists() {
        byte dateSeason = 1;
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        assertNotNull(f);
        assertNotNull(f.getCompetition());
        assertNull(f.getCompetition().getCountry());
        assertNotNull(f.getHomeTeam());
        assertNull(f.getHomeTeam().getCountry());
        assertNotNull(f.getAwayTeam());
        assertNull(f.getAwayTeam().getCountry());
    }
    
    
    @Test
    public void testFindByCompetitionDateHomeAwayIfNoExists() {
        byte dateSeason = 2;
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        assertNull(f);
    }
    

    @Test
    public void testUpdate() {
        byte dateSeason = 1;
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f1 = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        f1.setHomeTeam(team2);
        f1.setAwayTeam(team1);
        fixtureMapper.update(f1);
        
        Fixture f2 = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team2.getId(), team1.getId());
        assertEquals(f1.getDateSeason(), f2.getDateSeason());
        assertEquals(f1.getHomeTeam().getId(), f2.getHomeTeam().getId());
        assertEquals(f1.getAwayTeam().getId(), f2.getAwayTeam().getId());
        assertEquals(f1.getCompetition().getId(), f2.getCompetition().getId());
        //TODO: Load all dependencies in mapper
        //assertEquals(f1, f2);
    }
    

    @Test
    public void testDelete() {
        byte dateSeason = 1;
        Team team1 = teamMapper.findById(new Integer(1));
        Team team2 = teamMapper.findById(new Integer(2));
        Competition competition = competitionMapper.findById(new Integer(1));
        
        Fixture f1 = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        assertNotNull(f1);
        fixtureMapper.delete(f1);
        
        Fixture f2 = fixtureMapper.findByCompetitionDateHomeAway(competition.getId(), dateSeason, team1.getId(), team2.getId());
        assertNull(f2);
    }
    
    
    @Test
    public void testFindAll() {
        assertTrue(fixtureMapper.findAll().size() > 0);
    }
       
}
