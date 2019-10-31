package com.greycubelabs.tractine.nav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import com.greycubelabs.tractine.R;

public class GallerySearch extends AppCompatActivity {

    private static final int pic_id = 650;
    private ImageView medication_view;
    private TextView drug_facts, drug_name, disposal_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_search);
        medication_view = (ImageView) findViewById(R.id.gallery_medication_view);
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, pic_id);
        drug_facts = (TextView) findViewById(R.id.gallery_drug_facts);
        drug_name = (TextView) findViewById(R.id.gallery_name_guess);
        disposal_info = (TextView) findViewById(R.id.gallery_disposal_info);

        pickFromGallery();
    }

    private void pickFromGallery(){
        //Create an Intent with action as ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,pic_id);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            medication_view.setImageBitmap(photo);
        }
    }
}

