package music;

import behavior.User;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusic = new ArrayList<>();


    public String getTitle() {
        return title;
    }
    public User getSinger() {
        return singer;
    }
    public int getNumberOfStream() {
        return numberOfStream;
    }
    public static List<Music> getAllMusic() {
        return new ArrayList<>(allMusic);
    }

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusic.add(this);
    }
    public void play() {
        numberOfStream++;
        System.out.println(title + " by " + singer.getUsername() + " | Streamed: " + numberOfStream + " times");
    }
    public static List<Music> search(String title) {
        List<Music> result = new ArrayList<>();
        for (Music music : allMusic) {
            if (music.title.equals(title)) {
                result.add(music);
            }
        }
        return result;
    }

    public static Music search(String title, User singer) {
        for (Music music : allMusic) {
            if (music.title.equals(title) && music.singer.equals(singer)) {
                return music;
            }
        }
        return null;
    }

}
