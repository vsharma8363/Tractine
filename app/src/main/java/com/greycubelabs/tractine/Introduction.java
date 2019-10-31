package com.greycubelabs.tractine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.greycubelabs.tractine.nav.GallerySearch;
import com.greycubelabs.tractine.nav.ImageSearch;
import com.greycubelabs.tractine.nav.Instructions;
import com.greycubelabs.tractine.nav.Database;

public class Introduction extends AppCompatActivity {

    private TextView instructions1, instructions2, instructions3, disclaimer, sep1, sep2;
    private final int MS_Interval = 1500; //3.5 seconds
    private Button instructions, recents, picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        instructions1 = (TextView) findViewById(R.id.instruct_1);
        instructions2 = (TextView) findViewById(R.id.instruct_2);
        instructions3 = (TextView) findViewById(R.id.instruct_3);
        sep1 = (TextView) findViewById(R.id.sep1);
        sep2 = (TextView) findViewById(R.id.sep2);
        disclaimer = (TextView) findViewById(R.id.disclaimer_warn);

        instructions = (Button)findViewById(R.id.instructions_redirect);
        recents = (Button)findViewById(R.id.recents_redirect);
        picture = (Button)findViewById(R.id.picture_redirect);

        //Hide everything on page startup
        sep1.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        sep2.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        instructions1.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        instructions2.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        instructions3.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        disclaimer.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        instructions.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        recents.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out
        picture.startAnimation(new AlphaAnimation(1.0f, 0.0f)); //Get it out

        //Fade in the instructions
        Animation fade_in = new AlphaAnimation(0.0f, 1.0f);
        fade_in.setDuration(MS_Interval);
        instructions1.startAnimation(fade_in);

        fade_in = new AlphaAnimation(0.0f, 1.0f);
        fade_in.setDuration(MS_Interval*2);
        instructions2.startAnimation(fade_in);

        fade_in = new AlphaAnimation(0.0f, 1.0f);
        fade_in.setDuration(MS_Interval*3);
        instructions3.startAnimation(fade_in);
        sep1.startAnimation(fade_in);
        sep2.startAnimation(fade_in);

        fade_in = new AlphaAnimation(0.0f, 1.0f);
        fade_in.setDuration(MS_Interval*4);
        disclaimer.startAnimation(fade_in);

        //Fade in the buttons
        fade_in = new AlphaAnimation(0.0f, 1.0f);
        fade_in.setDuration(MS_Interval*5);
        instructions.startAnimation(fade_in);
        recents.startAnimation(fade_in);
        picture.startAnimation(fade_in);

        instructions.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(Introduction.this, Instructions.class);
                Introduction.this.startActivity(mainIntent);
            }
        });

        recents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                /*Intent mainIntent = new Intent(Introduction.this, GallerySearch.class);
                Introduction.this.startActivity(mainIntent);*/
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://datadiscovery.nlm.nih.gov/Drugs-and-Supplements/Pillbox/crzr-uvwg"));
                startActivity(viewIntent);
            }
        });

        picture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent mainIntent = new Intent(Introduction.this, ImageSearch.class);
                Introduction.this.startActivity(mainIntent);
            }
        });
    }
}
