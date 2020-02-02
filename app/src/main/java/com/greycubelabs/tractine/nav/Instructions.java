package com.greycubelabs.tractine.nav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.greycubelabs.tractine.R;

public class Instructions extends AppCompatActivity {

    ImageView pill_diagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        pill_diagram = (ImageView)findViewById(R.id.instructions_diagram);
        pill_diagram.setImageResource(R.drawable.pill);
    }
}
