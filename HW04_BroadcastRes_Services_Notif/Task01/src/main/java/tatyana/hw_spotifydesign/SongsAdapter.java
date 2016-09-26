package tatyana.hw_spotifydesign;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private ArrayList<Song> mAdapterSongs;
    ISelectableItem selectableItem;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, artist;
        private int position;

        public ViewHolder(final View songView) {
            super(songView);

            title = (TextView) songView.findViewById(R.id.title);
            artist = (TextView) songView.findViewById(R.id.artist);

            songView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectableItem.selectItem(mAdapterSongs.get(position));
                }
            });
        }

        public void setPosition(int songPosition) {
            this.position = songPosition;
        }
    }

    public SongsAdapter (ArrayList<Song> songsList, ISelectableItem item){
        this.mAdapterSongs = songsList;
        this.selectableItem = item;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_list_row, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            Song song = mAdapterSongs.get(position);
            holder.title.setText(song.getTitle());
            holder.artist.setText(song.getArtistName());
            holder.setPosition(position);
        }
    }

    @Override
    public int getItemCount() {
        return mAdapterSongs.size();
    }



}
