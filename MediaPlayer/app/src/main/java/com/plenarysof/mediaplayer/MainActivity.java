package com.plenarysof.mediaplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView tvStartTime, tvEndTime;
    private ImageView ivPlayPause;
    private SeekBar srControl;
    private static MediaPlayer rMediaPlayer = null;

    int startTime, endTime;

    private Handler myHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayPause = findViewById(R.id.iv_play_pause);
        srControl = findViewById(R.id.sr_control);
        tvEndTime = findViewById(R.id.end_time);
        tvStartTime = findViewById(R.id.current_time);

        ivPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rMediaPlayer != null && !rMediaPlayer.isPlaying()) {
                    ivPlayPause.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                    rMediaPlayer.start();
                } else if (rMediaPlayer == null) {
                    rMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.al_fatiha);
                    ivPlayPause.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                    endTime = rMediaPlayer.getDuration();
                    startTime = rMediaPlayer.getCurrentPosition();

                    tvEndTime.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) endTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) endTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                            toMinutes((long) endTime)))
                    );
                    tvStartTime.setText(startTime + "");
                    rMediaPlayer.start();
                    srControl.setMax((int) endTime);
                    srControl.setProgress((int)startTime);
                    myHandler.postDelayed(UpdateSongTime, 100);
                } else {
                    if (rMediaPlayer.isPlaying()) {
                        rMediaPlayer.pause();
                        ivPlayPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                    }
                }
            }

        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = rMediaPlayer.getCurrentPosition();
            tvStartTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            Log.d("TimeUpdate",""+startTime);
            srControl.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

}
