package com.azhar.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_item1, btn_item2, cam_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_item1 = findViewById(R.id.btn_item1);
        btn_item2 = findViewById(R.id.btn_item2);
        cam_btn = findViewById(R.id.cam_btn);

        cam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent campage = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(campage);
            }
        });

        btn_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThemeActivity.class);
                String pathPic = "bg_item1";
                i.putExtra("PATH_PICTURE", pathPic);
                startActivity(i);
            }
        });

        btn_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ThemeActivity.class);
                String pathPic = "bg_item2";
                i.putExtra("PATH_PICTURE", pathPic);
                startActivity(i);
            }
        });

    }
}
