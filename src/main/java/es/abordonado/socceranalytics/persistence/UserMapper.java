package es.abordonado.socceranalytics.persistence;

import es.abordonado.socceranalytics.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("SELECT * FROM user WHERE id=#{userId}")
    public User getUser(long userId);
    
    @Insert("Insert into user(email, userName) values(#{email}, #{userName})")
    public int addUser(User user);
    
}
