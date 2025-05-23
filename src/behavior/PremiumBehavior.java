package behavior;

import music.Music;
import music.Playlist;

public class PremiumBehavior implements UserBehavior {
    private int month;
    public int getMonth() { return month; }

    public PremiumBehavior(int month) {
        this.month = month;
    }

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist(title, owner);
        owner.addPlaylist(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        this.month += month;
    }
}
