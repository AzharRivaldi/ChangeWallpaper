package com.azhar.changewallpaper;

import android.Manifest;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import java.io.IOException;

public class ThemeActivity extends AppCompatActivity {

    RelativeLayout theme_preview;
    Button save_btn;
    String newString;
    Toolbar tbSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        //permission
        ActivityCompat.requestPermissions(ThemeActivity.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        theme_preview = findViewById(R.id.theme_preview);
        save_btn = findViewById(R.id.save_btn);
        tbSet = findViewById(R.id.mtbSet);
        setSupportActionBar(tbSet);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("PATH_PICTURE");

                if (newString.equals("bg_item1")) {
                    theme_preview.setBackgroundResource(R.drawable.bg_item1);

                    save_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                            Toast.makeText(getApplicationContext(), "Success Set Wallpaper", Toast.LENGTH_SHORT).show();
                            try {
                                wlp.setResource(+R.drawable.bg_item1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else if (newString.equals("bg_item2")) {
                    theme_preview.setBackgroundResource(R.drawable.bg_item2);

                    save_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            WallpaperManager wlp = WallpaperManager.getInstance(getApplicationContext());
                            Toast.makeText(getApplicationContext(), "Success Set Wallpaper", Toast.LENGTH_SHORT).show();
                            try {
                                wlp.setResource(+R.drawable.bg_item2);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }
            }
        }
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
