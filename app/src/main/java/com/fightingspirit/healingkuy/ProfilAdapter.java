package com.fightingspirit.healingkuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfilAdapter extends RecyclerView.Adapter<ProfilAdapter.ViewHolder> {
    private List<Mahasiswa> mTMahasiswa;

    public ProfilAdapter(List<Mahasiswa> tabel_mahasiswa) {
        mTMahasiswa = tabel_mahasiswa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_mahasiswa, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa mahasiswa = mTMahasiswa.get(position);

        // Set item views based on your views and data model
        TextView v_nim = holder.v_nim;
        v_nim.setText(mahasiswa.getNim());
        TextView v_nama = holder.v_nama;
        v_nama.setText(mahasiswa.getNama());
        ImageView v_pic = holder.v_pic;
        v_pic.setImageResource(mahasiswa.getPic());
    }

    @Override
    public int getItemCount() {
        return mTMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView v_nim;
        public TextView v_nama;
        public ImageView v_pic;

        public ViewHolder(View itemView) {
            super(itemView);

            v_nim = (TextView) itemView.findViewById(R.id.mhs_tv_nim);
            v_nama = (TextView) itemView.findViewById(R.id.mhs_tv_nama);
            v_pic = (ImageView) itemView.findViewById(R.id.mhs_pic);
        }
    }
}