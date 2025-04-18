package music;

import behavior.User;
import exceptions.InvalidOperationException;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
    private String title;
    private User owner;
    private ArrayList<Music> playlist;

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public ArrayList<Music> getPlaylist() {
        return new ArrayList<>(playlist);
    }

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
        this.playlist = new ArrayList<>();
    }

    void editTitle(String newTitle, String password) {
        if (!owner.checkPassword(password)) {
            throw new InvalidOperationException("Unauthorized access to edit playlist");
        }
        this.title = newTitle;
    }

    void addMusic(Music music, String password) {
        if (!owner.checkPassword(password)) {
            if (playlist.contains(music)) {
                throw new InvalidOperationException("This track already exists in your playlist");
            }
            playlist.add(music);
        }
        throw new InvalidOperationException("Unauthorized access to edit playlist");
    }

    void removeMusic(Music music, String password) {
        if (!owner.checkPassword(password)) {
            if (!(playlist.contains(music))) {
                throw new InvalidOperationException("This track does not exist in your playlist");
            }
            playlist.remove(music);
        }
        throw new InvalidOperationException("Unauthorized access to edit playlist");
    }

    Music searchInPlaylist(Music music) {
        for (Music m : playlist) {
            if (m.equals(music)) {
                return music;
            }
        }
        throw new InvalidOperationException("This music doesn't exist in your playlist");
    }

    void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }

    void shuffle() {
        ArrayList<Music> shuffled = new ArrayList<>(playlist);
        Collections.shuffle(shuffled);

        for (Music music : shuffled) {
            music.play();
        }
    }


}
