package com.reckordp.nicestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
//        final Context ctx = getContext();
//
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.lapak_detail, parent, false);
//        }

        DetailLapak item = objects.get(position);

        if (item != null) {
            item.performDetail(view);
        }

        return view;
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
        if (item != null) {
            item.performDetail(holder.itemView);
        }
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
