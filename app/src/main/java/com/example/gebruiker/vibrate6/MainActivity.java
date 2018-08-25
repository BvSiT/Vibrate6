package com.example.gebruiker.vibrate6;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /** Called when the user taps the Start button */
    public void startMetronome(View view) {
        /* Do something in response to button */
        Button b = (Button) view;
        Vibrator v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        TextView tv=(TextView)findViewById(R.id.editBpm);
        long bpm=Long.parseLong(tv.getText().toString());



        if (b.getText().toString().equals(getResources().getString(R.string.btnStart))) {
            b.setText(R.string.btnStop);

            /* long bpm = 100; */
            if (bpm != 0) {
                long beat_interval_ms = 60000L / bpm;
                long beat_duration_ms = 100;

                if (beat_duration_ms>=beat_interval_ms){
                    beat_duration_ms = beat_interval_ms /2;
                }




                // Start without a delay
                // Vibrate for 100 milliseconds
                // Sleep for 1000 milliseconds
                long[] pattern = {0, beat_duration_ms, beat_interval_ms-beat_duration_ms};

                // The '0' here means to repeat indefinitely
                // '0' is actually the index at which the pattern keeps repeating from (the start)
                // To repeat the pattern from any other point, you could increase the index, e.g. '1'
                v.vibrate(pattern, 0);
            }

        }
        else{
            b.setText(R.string.btnStart);
            v.cancel();
        }
    }
}
