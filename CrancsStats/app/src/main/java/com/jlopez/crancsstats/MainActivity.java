package com.jlopez.crancsstats;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer myChrono;
    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myChrono = (Chronometer) findViewById(R.id.chronometer2);
    }

    public void playChrono(View v)
    {
        myChrono.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        myChrono.start();
    }
    public void pauseChrono(View v)
    {
        timeWhenStopped = myChrono.getBase() - SystemClock.elapsedRealtime();
        myChrono.stop();
    }
    public void stopChrono(View v)
    {
        myChrono.setBase(SystemClock.elapsedRealtime());
        myChrono.stop();
        timeWhenStopped = 0;
    }
}
