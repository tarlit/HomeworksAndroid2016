package tatyana.hw_spotifydesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Song> songsList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SongsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new SongsAdapter(songsList);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareSongData();
    }

    private void prepareSongData() {
        Song song = new Song("Ride", "twenty one pilots . Ride");
        songsList.add(song);

        song = new Song("Cheap Thrills", "Sia Featuring Sean Paul . Cheap Thrills");
        songsList.add(song);

        song = new Song("Send My Love (To Your New Lover)", "Adele . Send My Love");
        songsList.add(song);

        song = new Song("Cold Water", "Major Lazer Featuring Justin Bieber & MO . Cold Water");
        songsList.add(song);

        song = new Song("This Is What You Came For", "Calvin Harris Featuring Rihanna . This Is What You Came For");
        songsList.add(song);

        song = new Song("Treat You Better", "Shawn Mendes . Treat You Better");
        songsList.add(song);

        song = new Song("Closer", "The Chainsmokers Featuring Halsey . Closer");
        songsList.add(song);

        song = new Song("Into You", "Ariana Grande . Into You");
        songsList.add(song);

        song = new Song("Don't Let Me Down", "The Chainsmokers Featuring Daya . Don't Let Me Down");
        songsList.add(song);

        song = new Song("One Dance", "Drake Featuring WizKid & Kyla . One Dance");
        songsList.add(song);

        mAdapter.notifyDataSetChanged();
    }
}
