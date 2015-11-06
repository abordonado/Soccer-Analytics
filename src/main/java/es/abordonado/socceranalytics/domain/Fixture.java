package es.abordonado.socceranalytics.domain;

import java.util.Date;
import java.util.Objects;


public class Fixture extends DomainClass {
    
    private byte dateSeason;
    private Date dateFixture;
    private Team homeTeam;
    private Team awayTeam;
    private Competition competition;

    public Fixture(byte dateSeason, Team homeTeam, Team awayTeam, Competition competition) {
        this.dateSeason = dateSeason;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.competition = competition;
    }

    public byte getDateSeason() {
        return dateSeason;
    }

    public void setDateSeason(byte dateSeason) {
        this.dateSeason = dateSeason;
    }

    public Date getDateFixture() {
        return dateFixture;
    }

    public void setDateFixture(Date dateFixture) {
        this.dateFixture = dateFixture;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.dateSeason;
        hash = 59 * hash + Objects.hashCode(this.homeTeam);
        hash = 59 * hash + Objects.hashCode(this.awayTeam);
        hash = 59 * hash + Objects.hashCode(this.competition);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fixture other = (Fixture) obj;
        if (this.dateSeason != other.dateSeason) {
            return false;
        }
        if (!Objects.equals(this.homeTeam, other.homeTeam)) {
            return false;
        }
        if (!Objects.equals(this.awayTeam, other.awayTeam)) {
            return false;
        }
        if (!Objects.equals(this.competition, other.competition)) {
            return false;
        }
        return true;
    }
    
}
