package com.reckordp.nicestore;

import android.net.Uri;
import android.os.Parcel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

public class LapakNiceStore implements DetailLapak {
    int thumbnail;
    String nama;
    int harga;
    Uri jalurUri;

    LapakNiceStore() {
    }

    LapakNiceStore(Parcel src) {
        thumbnail = src.readInt();
        nama = src.readString();
        harga = src.readInt();
        jalurUri = Uri.parse(src.readString());
    }

    public static final Creator<LapakNiceStore> CREATOR = new Creator<LapakNiceStore>() {
        @Override
        public LapakNiceStore createFromParcel(Parcel in) {
            return new LapakNiceStore(in);
        }

        @Override
        public LapakNiceStore[] newArray(int size) {
            return new LapakNiceStore[size];
        }
    };

    @Override
    public void performDetail(@NonNull LapakAdapterViewHolder viewHolder) {
        MainActivity activity = MainActivity.getInstance();
        View area = viewHolder.itemView;
        ImageView image = area.findViewById(R.id.thumbnail);
        this.jalurUri = Uri.parse("android.resource://" + activity.getPackageName() + "/" + thumbnail);
        Glide.with(activity)
                .load(jalurUri)
                .into(image);
        TextView text = area.findViewById(R.id.teks);
        text.setText(this.nama);

        viewHolder.lapakNama = this.nama;
        viewHolder.lapakHarga = this.harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(thumbnail);
        dest.writeString(nama);
        dest.writeInt(harga);
        dest.writeString(jalurUri.toString());
    }
}
