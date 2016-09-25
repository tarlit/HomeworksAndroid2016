package tatyana.hw_spotifydesign;

public class Song {
    private String title, artistName;

    public Song(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String value) {
        this.title = value;
    }

    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String value) {
        this.artistName = value;
    }


}
