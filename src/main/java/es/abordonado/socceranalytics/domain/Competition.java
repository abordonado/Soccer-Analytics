package es.abordonado.socceranalytics.domain;

import java.util.Date;
import java.util.Objects;


public class Competition extends DomainClass {
    
    private String code;
    private String description;
    private Integer seasson;
    private Date startAt;
    private Date endAt;
    private Country country;

    public Competition(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeasson() {
        return seasson;
    }

    public void setSeasson(Integer seasson) {
        this.seasson = seasson;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.code);
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
        final Competition other = (Competition) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
}
