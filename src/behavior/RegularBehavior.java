package behavior;

import exceptions.InvalidOperationException;
import music.Music;

public class RegularBehavior implements UserBehavior{
    int playingLimit = 5;


    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("Regular users cannot create playlists");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit == 0) {
            throw new InvalidOperationException("You reached your limit of plays");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setUserBehavior(new PremiumBehavior(month));
    }
}
