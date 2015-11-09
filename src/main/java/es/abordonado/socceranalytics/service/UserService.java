package es.abordonado.socceranalytics.service;

import es.abordonado.socceranalytics.domain.User;
import es.abordonado.socceranalytics.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    
    public User getUser(int userId){
        return userMapper.getUser(userId);
    }
    
}
