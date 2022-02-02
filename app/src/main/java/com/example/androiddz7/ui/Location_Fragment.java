package com.example.androiddz7.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androiddz7.Adapter.FirstAdapter;
import com.example.androiddz7.Adapter.LocationAdapter;
import com.example.androiddz7.Model.ModelFirst;
import com.example.androiddz7.Model.ModelLocation;
import com.example.androiddz7.R;
import com.example.androiddz7.databinding.FragmentLocationBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class Location_Fragment extends Fragment implements LocationAdapter.OnItemClickListener {
    private FragmentLocationBinding binding;
    private RecyclerView recyclerView;
    private LocationAdapter adapter;
    private ArrayList<ModelLocation> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationBinding.inflate(LayoutInflater.from(requireContext()),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }

    private void initRecyclerview() {
        recyclerView = binding.containerRecyclerLocation;
        adapter = new LocationAdapter();
        adapter.updateData(addList(),this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<ModelLocation> addList() {
        list = new ArrayList<>();
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.earth)));
        list.add(new ModelLocation(getString(R.string.cluster),getString(R.string.abadango)));
        list.add(new ModelLocation(getString(R.string.space_station),getString(R.string.citadel_of_ricks)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.worldenders_lair)));
        list.add(new ModelLocation(getString(R.string.microverse),getString(R.string.anatomy_park)));
        list.add(new ModelLocation(getString(R.string.tv),getString(R.string.Interdimensional_cable)));
        list.add(new ModelLocation(getString(R.string.resort),getString(R.string.Immortality_field_resort)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.post_apocalyptic_earth)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.purge_planet)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.venzenulon_7)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.bepis_9)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.cronenberg_earth)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.nuptia_4)));
        list.add(new ModelLocation(getString(R.string.space_station),getString(R.string.st_gloopy_noops_hospital)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.gromflom_prime)));
        list.add(new ModelLocation(getString(R.string.planet),getString(R.string.earth_rpl_dimension)));
        return list;
    }

    @Override
    public void OnClick(int p) {
        Toast.makeText(getContext(), "ура", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        ModelLocation mode = adapter.getItem(p);
        bundle.putSerializable("model2", mode);
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        getParentFragmentManager().beginTransaction().replace(R.id.nav_host,detailsFragment).addToBackStack(null).commit();



    }
}