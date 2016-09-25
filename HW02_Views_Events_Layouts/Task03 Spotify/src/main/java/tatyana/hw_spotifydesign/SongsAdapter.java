package tatyana.hw_spotifydesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder>{

    private List<Song> songsList;

    public SongsAdapter (List<Song> songsList){
        this.songsList = songsList;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.songs_list_row, parent, false);
        return new SongsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, int position) {
        Song song = songsList.get(position);
        holder.title.setText(song.getTitle());
        holder.artist.setText(song.getArtistName());
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder {

        public TextView title, artist;

        public SongsViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            artist = (TextView) view.findViewById(R.id.artist);
        }
    }

}
