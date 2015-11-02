package Etsy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zxm on 11/1/15.
 */
public class User {
    private String name;
    private final int followingCapacity = 1;
    private int numOfFollowingPeople;
    Set<User> followers;
    Set<User> following;

    public User(String name) {
        this.name = name;
        followers = new HashSet<>();
        following = new HashSet<>();
    }

    public void follow() {

    }

    public void unfollow() {

    }

    public int getNumOfFollowers() {
        return followers.size();
    }

    /**Setters and Getters*/
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowingCapacity() {
        return followingCapacity;
    }

    public int getNumOfFollowingPeople() {
        return numOfFollowingPeople;
    }

    public void setNumOfFollowingPeople(int numOfFollowingPeople) {
        this.numOfFollowingPeople = numOfFollowingPeople;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> following) {
        this.following = following;
    }


}