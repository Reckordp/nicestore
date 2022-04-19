package com.reckordp.nicestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BeliLapak extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_beli_lapak);
        Intent intent = getIntent();
        LapakNiceStore lapak;
        lapak = (LapakNiceStore)intent.getParcelableExtra(LapakAdapterViewHolder.LAPAK_NICE_STORE);

        ((TextView)findViewById(R.id.merchant_id)).setText(lapak.nama);
        int harga = lapak.harga;
        int ribuan = 1;
        int hasil = 1;
        StringBuilder teks = new StringBuilder();
        StringBuilder ketikan = new StringBuilder();
        while(true) {
            hasil = harga / ribuan;
            if (hasil <= 1) break;
            ketikan.insert(0, hasil % 1000);
            while (ketikan.length() < 3) ketikan.insert(0, 0);
            ketikan.insert(0, ".");
            teks.insert(0, ketikan);
            ribuan *= 1000;
        }
        teks.deleteCharAt(0);
        ((TextView)findViewById(R.id.merchant_harga)).setText(teks.toString());

        Glide.with(this)
                .load(lapak.jalurUri)
                .into((ImageView) findViewById(R.id.merchant_thumbnail));

        findViewById(R.id.merchant_beli).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View button) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://shopee.co.id/nicestore._"));
        startActivity(intent);
    }
}