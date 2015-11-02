package Etsy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxm on 11/1/15.
 */
public class UserService {

    private static UserService _instance;
    private Map<String, User> userMap;

    private UserService() {
        userMap = new HashMap<>();

    }

    public boolean register(User user) {

    }

    public boolean unregister(User user) {

    }


    public boolean follows(User follower, User followee) {

    }

    public boolean unfollows(User follower, User followee) {

    }

    public int getNumOfFollowers(User user) {

    }

    public Map<String, Integer> getNumOfFollowersForAll() {

    }

    /**Getters and Setters*/
    public static UserService get_instance() {
        if (_instance == null) {
            _instance = new UserService();
        }
        return _instance;
    }


    public Map<String, User> getUserMap() {
        return userMap;
    }


}
