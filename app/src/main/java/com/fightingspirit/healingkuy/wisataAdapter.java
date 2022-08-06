package com.fightingspirit.healingkuy;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.Map;

// 6 Juli 2022, 10119032, Ginanjar Tubagus Gumilar, IF1
public class wisataAdapter extends FirebaseRecyclerAdapter<
        wisata, wisataAdapter.wisataViewholder> implements View.OnClickListener {

    Context context;
    int bindAdapter;
    int counter;

    public wisataAdapter(
            @NonNull FirebaseRecyclerOptions<wisata> options, Context context)
    {
        super(options);
        this.context = context;
        counter = 0;
    }

    @Override
    protected void
    onBindViewHolder(@NonNull wisataViewholder holder,
                     int position, @NonNull wisata model)
    {
        Picasso.get().load(model.getFoto()).into(holder.foto);

        holder.lokasi.setText(model.getLokasi());

        holder.nama.setText(model.getNama());

        holder.alamat.setText(model.getAlamat());
    }


    @NonNull
    @Override
    public wisataViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wisata, parent, false);
        counter+=1;
        return new wisataAdapter.wisataViewholder(view, counter);
    }

    @Override
    public void onClick(View view) {

    }

    class wisataViewholder
            extends RecyclerView.ViewHolder {
        TextView lokasi, nama, alamat;
        ImageView foto;
        String url_foto, lok_lat, lok_long;

        public wisataViewholder(@NonNull View itemView, @NonNull int counter) {
            super(itemView);

            foto = itemView.findViewById(R.id.foto);
            lokasi = itemView.findViewById(R.id.lokasi);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), DetailWisataActivity.class);
                    i.putExtra("foto", url_foto);
                    i.putExtra("lokasi", lokasi.getText());
                    i.putExtra("nama", nama.getText());
                    i.putExtra("alamat", alamat.getText());
                    i.putExtra("lok_lat", lok_lat);
                    i.putExtra("lok_long", lok_long);
                    view.getContext().startActivity(i);
                }
            });
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

            DatabaseReference databaseReference = firebaseDatabase.getReference();

            DatabaseReference getFoto = databaseReference.child("wisata".concat(String.valueOf(counter))).child("foto");

            getFoto.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String link = dataSnapshot.getValue(String.class);

                    Picasso.get().load(link).into(foto);
                    url_foto = link;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // we are showing that error message in toast
                    Toast.makeText(context, "Error Loading Image", Toast.LENGTH_SHORT).show();
                }
            });

            DatabaseReference getLok_lat = databaseReference.child("wisata".concat(String.valueOf(counter))).child("lok_lat");

            getLok_lat.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String str_lok_lat = dataSnapshot.getValue(String.class);
                    lok_lat = str_lok_lat;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // we are showing that error message in toast
                    Toast.makeText(context, "Error Loading Image", Toast.LENGTH_SHORT).show();
                }
            });

            DatabaseReference getLok_long = databaseReference.child("wisata".concat(String.valueOf(counter))).child("lok_long");

            getLok_long.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String str_lok_long = dataSnapshot.getValue(String.class);
                    lok_long = str_lok_long;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // we are showing that error message in toast
                    Toast.makeText(context, "Error Loading Image", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
