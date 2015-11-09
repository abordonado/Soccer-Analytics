package es.abordonado.socceranalytics.persistence;

import es.abordonado.socceranalytics.domain.User;


public interface UserMapper {
    
    public User getUser(int userId);
    
    public int addUser(User user);
    
}
