package com.fightingspirit.healingkuy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

// 6 Juli 2022, 10119023, Muhammad Farhan Roesfiazhar, IF1
public class DetailWisataActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    public TextView lokasi, nama, alamat;
    public ImageView foto;
    public String lok_lat, lok_long, str_nama;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            foto = findViewById(R.id.dw_foto);
            Picasso.get().load(getIntent().getStringExtra("foto")).into(foto);
            lokasi = findViewById(R.id.dw_lokasi);
            lokasi.setText(getIntent().getStringExtra("lokasi"));
            nama = findViewById(R.id.dw_nama);
            str_nama = getIntent().getStringExtra("nama");
            nama.setText(str_nama);
            alamat = findViewById(R.id.dw_alamat);
            alamat.setText(getIntent().getStringExtra("alamat"));
            lok_lat = getIntent().getStringExtra("lok_lat");
            lok_long = getIntent().getStringExtra("lok_long");
        }

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {
        mMap = googleMap;

        //passing lat long value
        LatLng wisata = new LatLng(Double.parseDouble(lok_lat), Double.parseDouble(lok_long));

        //passing title
        MarkerOptions mark = new MarkerOptions().position(wisata).title(str_nama);

        mMap.addMarker(mark);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(wisata,13));
    }
}