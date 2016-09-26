package tatyana.hw_spotifydesign;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements ISelectableItem{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Song> songs;
    private Song selectedSong;
    private SongsService songsService;
    private ServiceConnection connection;
    private Intent songsIntent;
    private TextView selectedSongInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.songs = new ArrayList<>();
        prepareSongsData();

        selectedSongInfo = (TextView) findViewById(R.id.songInfo);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SongsAdapter(songs, this);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                SongsService.SongsBinder binder = (SongsService.SongsBinder) service;
                songsService = binder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        };

        this.songsIntent = new Intent(this, SongsService.class);
        bindService(songsIntent, connection, Context.BIND_AUTO_CREATE);
        this.startService(songsIntent);
    }

    @Override
    public void selectItem(Song song) {
        this.selectedSong = song;
        this.selectedSongInfo.setText(song.getArtistName());
        this.songsService.playSong(song.getFilePath());
    }

    @Override
    protected void onDestroy() {
        this.stopService(songsIntent);
        unbindService(connection);

        super.onDestroy();
    }

    public void playBtnPressed(View view) {
        this.songsService.playMusic(selectedSong);
    }

    public void pauseBtnPressed(View view) {
        this.songsService.pauseMusic();
    }

    public void stopBtnPressed(View view) {
        this.songsService.stopMusic();
    }

    public void forwardBtnPressed(View view) {
        this.songsService.jumpForward();
    }

    public void backwardBtnPressed(View view) {
        this.songsService.jumpBackward();
    }

    private void prepareSongsData() {
        this.songs.add(new Song("Ride", "Twenty One Pilots . Ride", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song1)));
        this.songs.add(new Song("Cheap Thrills", "Sia Featuring Sean Paul . Cheap Thrills", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song2)));
        this.songs.add(new Song("Send My Love (To Your New Lover)", "Adele . Send My Love", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song3)));
        this.songs.add(new Song("Cold Water", "Major Lazer Featuring Justin Bieber & MO . Cold Water", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song4)));
        this.songs.add(new Song("This Is What You Came For", "Calvin Harris Featuring Rihanna . This Is What You Came For", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song5)));
        this.songs.add(new Song("Treat You Better", "Shawn Mendes . Treat You Better", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song6)));
        this.songs.add(new Song("Closer", "The Chainsmokers Featuring Halsey . Closer", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song7)));
        this.songs.add(new Song("Into You", "Ariana Grande . Into You", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song8)));
        this.songs.add(new Song("Don't Let Me Down", "The Chainsmokers Featuring Daya . Don't Let Me Down", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song9)));
        this.songs.add(new Song("One Dance", "Drake Featuring WizKid & Kyla . One Dance", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.song10)));
    }
}
