package tatyana.hw_spotifydesign;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;

public class SongsService extends Service {

    public static final int JUMP_DURATION = 5000;

    private int songLength;
    private boolean isStopped;
    private SongsBinder songsBinder;
    private MediaPlayer audioPlayer;

    public class SongsBinder extends Binder {
        public SongsService getService() {
            return SongsService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.songsBinder = new SongsBinder();
        this.audioPlayer = new MediaPlayer();

        this.audioPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        this.audioPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.audioPlayer = new MediaPlayer();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return songsBinder;
    }

    public void playSong(Uri songPath) {
        if (this.audioPlayer.isPlaying()) {
            this.audioPlayer.stop();
        }

        try {
            this.audioPlayer.reset();
            this.audioPlayer.setDataSource(getApplicationContext(), songPath);
            this.audioPlayer.prepare();
            this.isStopped = false;

            this.audioPlayer.start();

        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "Wrong path!", Toast.LENGTH_SHORT).show();
        }
    }

    public void playMusic(Song song) {
        if (this.audioPlayer.isPlaying()) {
            return;

        } else if (this.isStopped) {
            this.playSong(song.getFilePath());

        } else {
            this.audioPlayer.seekTo(songLength);
            this.audioPlayer.start();
        }
    }

    public void pauseMusic() {
        this.audioPlayer.pause();
        this.songLength = audioPlayer.getCurrentPosition();
    }

    public void stopMusic() {
        this.audioPlayer.stop();
        this.isStopped = true;
    }

    public void jumpForward() {
        if (this.audioPlayer.isPlaying()) {
            int newPosition = this.audioPlayer.getCurrentPosition() + JUMP_DURATION;

            if (newPosition < this.audioPlayer.getDuration()) {
                this.audioPlayer.seekTo(newPosition);
            }
        }
    }

    public void jumpBackward() {
        if (this.audioPlayer.isPlaying()) {
            int newPosition = this.audioPlayer.getCurrentPosition() - JUMP_DURATION;

            if (newPosition > 0) {
                this.audioPlayer.seekTo(newPosition);
            }
        }
    }
}
