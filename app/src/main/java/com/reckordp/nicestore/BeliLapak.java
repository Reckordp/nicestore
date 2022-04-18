package com.reckordp.nicestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BeliLapak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_lapak);
        Intent intent = getIntent();
        LapakNiceStore lapak;
        lapak = (LapakNiceStore)intent.getParcelableExtra(LapakAdapterViewHolder.LAPAK_NICE_STORE);

        ((TextView)findViewById(R.id.merchant_id)).setText(lapak.nama);
        int harga = lapak.harga;
        int ribuan = 1;
        int hasil = 1;
        StringBuilder teks = new StringBuilder();
        while(hasil != 0) {
            hasil = harga / ribuan;
            if (hasil == 1) break;
            teks.insert(0, hasil);
            if (hasil != 0) teks.insert(0, ".");
        }
        ((TextView)findViewById(R.id.merchant_harga)).setText(teks.toString());

        Glide.with(this)
                .load(lapak.jalurUri)
                .into((ImageView) findViewById(R.id.merchant_thumbnail));
    }
}