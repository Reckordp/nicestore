package com.reckordp.nicestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DetailLapak> deret = new ArrayList<>();
        deret.add(new LapakNiceStore());

        LapakAdapter adapter = new LapakAdapter(MainActivity.this,
                R.layout.lapak_detail, deret);

        ListView lview = findViewById(R.id.lapak);
        lview.setAdapter(adapter);
    }
}