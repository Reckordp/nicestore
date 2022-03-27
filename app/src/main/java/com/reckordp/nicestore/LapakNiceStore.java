package com.reckordp.nicestore;

import android.view.View;
import android.widget.TextView;

public class LapakNiceStore implements DetailLapak {
    @Override
    public void performDetail(View area) {
        TextView text = area.findViewById(R.id.teks);
        text.setText("Lapak");
    }
}
