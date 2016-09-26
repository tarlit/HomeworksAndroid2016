package tatyana.hw_spotifydesign;

import android.net.Uri;

public class Song {

    private String title;
    private String artistName;
    private Uri filePath;

    public Song(String title, String artistName, Uri filePath) {
        this.title = title;
        this.artistName = artistName;
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public Uri getFilePath() {
        return filePath;
    }
}
