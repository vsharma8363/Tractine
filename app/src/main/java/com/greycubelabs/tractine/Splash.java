package com.greycubelabs.tractine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends Activity {

    private final int TIME_MS = 5000;
    private ImageView logo;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, Introduction.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, TIME_MS);
    }
}