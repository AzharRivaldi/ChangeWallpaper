package com.azhar.changewallpaper;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    Button save_btn;
    ImageView place_pict;
    Bitmap camBitmap;
    Toolbar tbCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        save_btn = findViewById(R.id.save_btn);
        place_pict = findViewById(R.id.place_pic);
        tbCam = findViewById(R.id.mtbCam);
        setSupportActionBar(tbCam);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam, 0);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Success Set Wallpaper", Toast.LENGTH_SHORT).show();
                try {
                    wlp.setBitmap(camBitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        camBitmap = (Bitmap) data.getExtras().get("data");
        place_pict.setImageBitmap(camBitmap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
