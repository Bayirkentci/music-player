package behavior;

import exceptions.InvalidOperationException;
import music.*;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private UserBehavior behavior;

    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUsers = new ArrayList<>(); //validation

    public String getUsername() {
        return username;
    }
    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }
    public ArrayList<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }

    public User(String username, String password) {
        if (password.isEmpty()) {
            throw new InvalidOperationException("Password cannot be empty");
        }
        for (User user : allUsers) {
            if (user.username.equals(username)) {
                throw new InvalidOperationException("This username is taken");
            }
        }
        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        allUsers.add(this);
    }

    void setUserBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    void follow (User user) {
        if (!(this.followingList.contains(user))) {
            this.followingList.add(user);
            user.followerList.add(this);
        }
        if (!(allUsers.contains(user))) {
            throw new InvalidOperationException("This user does not exist");
        }
    }

    public void unfollow(User user) {
        if (this.followingList.contains(user)) {
            this.followingList.remove(user);
            user.followerList.remove(this);
        } else {
            throw new InvalidOperationException("You are not following this user");
        }
    }

    void createPlaylist (String Title, User Owner){
        this.behavior.createPlaylist(Title, Owner);
    }

    void playMusic (Music music) {
        this.behavior.playMusic(music);
    }

    void buyPremium (User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }
}
