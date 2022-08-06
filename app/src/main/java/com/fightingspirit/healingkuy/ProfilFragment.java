package com.fightingspirit.healingkuy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

// 6 Juli 2022, 10119002, Firman Sahita, IF1
public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profil, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_mhs);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Mahasiswa> tMhs = new ArrayList<Mahasiswa>();
        tMhs.add(new Mahasiswa("10118003", "Rio Franata", R.drawable.pic_rio));
        tMhs.add(new Mahasiswa("10119002", "Firman Sahita", R.drawable.pic_firman));
        tMhs.add(new Mahasiswa("10119023", "Muhammad Farhan Roesfiazhar", R.drawable.pic_farhan));
        tMhs.add(new Mahasiswa("10119032", "Ginanjar Tubagus Gumilar", R.drawable.pic_ginanjar));
        tMhs.add(new Mahasiswa("10119046", "Alfi Nurizkya", R.drawable.pic_alfi));

        ProfilAdapter mAdapter = new ProfilAdapter(tMhs);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }
}