package dao;

import object.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    private Map<String, User> usersDb = new HashMap<>();
    {
        usersDb.put("duynga", new User(1, "duynga", "12345", "Duy Nga Lo", "dlo@mum.edu","1000 N ", "(641) 123-1234"));
        usersDb.put("thaodao", new User(2, "thaodao", "12345", "Thi Van Thao Dao", "tdao@mum.edu","2000 N Court St, Fairfield, Iowa", "(641) 123-1234"));
    }

    public boolean checkExistUser(String username, String password){
        if(usersDb.containsKey(username) && usersDb.get(username).getPassWord().equals(password)){
            return true;
        }
        return false;
    }

    public boolean checkExitsByUsername (String username){
        if(usersDb.containsKey(username))
            return true;
        return false;
    }

    public boolean addUser (String username, String password, String fullname, String email, String address, String phone){
        if (checkExitsByUsername(username))
            return false;
        else
        {
            usersDb.put(username, new User(usersDb.size()+1, username, password, fullname, email, address, phone));
            return true;
        }
    }

    public User getUserByUsername(String username){
        return usersDb.get(username);
    }
}
