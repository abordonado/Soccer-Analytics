package es.abordonado.socceranalytics.domain;


public abstract class DomainClass {
    
    private Integer Id;
    
    public Integer getId() { 
        return this.Id; 
    }
    
    @Override
    public abstract boolean equals(Object object);
    
    @Override
    public abstract int hashCode();    
    
}
