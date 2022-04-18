package com.reckordp.nicestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static MainActivity instance = null;

    static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);

        ArrayList<DetailLapak> deret = new ArrayList<>();
        TypedArray thumbnail = getResources().obtainTypedArray(R.array.thumbnail);
        String[] namaLapak = getResources().getStringArray(R.array.nama_lapak);
        int[] hargaLapak = getResources().getIntArray(R.array.harga);
        for (int i = 0; i < thumbnail.length(); i++) {
            LapakNiceStore lapak = new LapakNiceStore();
            lapak.nama = namaLapak[i];
            lapak.thumbnail = thumbnail.getResourceId(i, -1);
            lapak.harga = hargaLapak[i];
            deret.add(lapak);
        }
        thumbnail.recycle();

        LapakAdapter adapter = new LapakAdapter(R.layout.lapak_detail, deret);

        RecyclerView recycle = findViewById(R.id.lapak);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setHasFixedSize(true);
    }
}