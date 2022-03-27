package com.reckordp.nicestore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LapakAdapter extends ArrayAdapter<DetailLapak> {
    int layout;
    List<DetailLapak> objects;


    public LapakAdapter(@NonNull Context context, int resource, @NonNull List<DetailLapak> obj) {
        super(context, resource, obj);
        layout = resource;
        objects = obj;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        final Context ctx = getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lapak_detail, parent, false);
        }

        DetailLapak item = objects.get(position);

        if (item != null) {
            item.performDetail(view);
        }

        return view;
    }
}
