package com.reckordp.nicestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DetailLapak> deret = new ArrayList<>();
        deret.add(new LapakNiceStore(R.drawable.black_japanese, "Black Japanese"));
        deret.add(new LapakNiceStore(R.drawable.gray_japanese, "Gray Japanese"));
        deret.add(new LapakNiceStore(R.drawable.navy_japanese, "Navy Japanese"));
        deret.add(new LapakNiceStore(R.drawable.red_japanese, "Red Japanese"));
        deret.add(new LapakNiceStore(R.drawable.wallet, "Wallet"));
        deret.add(new LapakNiceStore(R.drawable.mont_blanc, "Mont Blanc"));
        deret.add(new LapakNiceStore(R.drawable.wallet_dicky, "Wallet Dicky"));
        deret.add(new LapakNiceStore(R.drawable.wallet_lives, "Wallet Lives"));

        LapakAdapter adapter = new LapakAdapter(R.layout.lapak_detail, deret);

        RecyclerView recycle = findViewById(R.id.lapak);
        recycle.setAdapter(adapter);
    }
}