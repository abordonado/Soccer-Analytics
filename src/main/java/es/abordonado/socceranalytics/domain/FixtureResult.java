package es.abordonado.socceranalytics.domain;


public class FixtureResult {
    
    private byte homeGoals;
    private byte awayGoals;

    public FixtureResult(byte homeGoals, byte awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public byte getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(byte homeGoals) {
        this.homeGoals = homeGoals;
    }

    public byte getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(byte awayGoals) {
        this.awayGoals = awayGoals;
    }    
    
}
