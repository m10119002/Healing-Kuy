package com.fightingspirit.healingkuy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// 6 Juli 2022, 10119032, Ginanjar Tubagus Gumilar, IF1
public class ListWisataFragment extends Fragment {

    private RecyclerView recyclerView;
    wisataAdapter
            adapter; // Create Object of the Adapter class
    DatabaseReference mbase; // Create object of the
    // Firebase Realtime Database

    public ListWisataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_listwisata, container, false);

        // Create a instance of the database and get
        // its reference
        mbase
                = FirebaseDatabase.getInstance().getReference();

        recyclerView = rootView.findViewById(R.id.recycler1);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<wisata> options
                = new FirebaseRecyclerOptions.Builder<wisata>()
                .setQuery(mbase, wisata.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new wisataAdapter(options, getContext());
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    public void onStart()
    {
        super.onStart();
        adapter.startListening();
        adapter.notifyDataSetChanged();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override
    public void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}