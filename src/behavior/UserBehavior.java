package behavior;

import music.Music;

public interface UserBehavior {
    void createPlaylist (String Title, User Owner);
    void playMusic (Music music);
    void buyPremium (User owner, int month);
}
