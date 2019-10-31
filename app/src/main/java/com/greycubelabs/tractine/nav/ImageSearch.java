package com.greycubelabs.tractine.nav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import com.greycubelabs.tractine.R;

public class ImageSearch extends AppCompatActivity {

    private static final int pic_id = 650;
    private ImageView medication_view;
    private TextView drug_facts, drug_name, disposal_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search);
        medication_view = (ImageView) findViewById(R.id.medication_view);
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, pic_id);
        drug_facts = (TextView) findViewById(R.id.drug_facts);
        drug_name = (TextView) findViewById(R.id.name_guess);
        disposal_info = (TextView) findViewById(R.id.disposal_info);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            medication_view.setImageBitmap(photo);
        }
    }
}

