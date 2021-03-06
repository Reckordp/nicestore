package com.reckordp.nicestore;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LapakAdapter extends RecyclerView.Adapter<LapakAdapterViewHolder> {
    int layout;
    List<DetailLapak> objects;


    public LapakAdapter(int resource, @NonNull List<DetailLapak> obj) {
        this.layout = resource;
        this.objects = obj;
    }

    @NonNull
    @Override
    public LapakAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewGroup layoutGroup = (ViewGroup) inflater.inflate(layout, parent, false);
        return new LapakAdapterViewHolder(layoutGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull LapakAdapterViewHolder holder, int position) {
        DetailLapak item = objects.get(position);
        holder.setLapak(item);
        if (item != null) {
            item.performDetail(holder);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
