package service;

import connection.Connection;
import domain.User;

/**
 * Created by Tao on 3/23/2017.
 */
public class UserService {
    private Connection connection=null;

    public UserService(){
        connection=new Connection();
    }

    public void add(User user){
        connection.add(user);
    }

    public User find(String username){
        return connection.find(username);
    }

}
