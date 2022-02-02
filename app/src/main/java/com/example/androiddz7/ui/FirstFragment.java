package com.example.androiddz7.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddz7.Adapter.FirstAdapter;
import com.example.androiddz7.Model.ModelFirst;
import com.example.androiddz7.R;
import com.example.androiddz7.databinding.FragmentFirstBinding;

import java.io.Serializable;
import java.util.ArrayList;


public class FirstFragment extends Fragment implements FirstAdapter.OnItemClickListener{
    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private FirstAdapter adapter;
    private ArrayList<ModelFirst> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerview();
    }

    private void initRecyclerview() {
        recyclerView = binding.recyclerCont;
        adapter = new FirstAdapter();
        adapter.updateData(addList(),this);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<ModelFirst> addList() {
        list = new ArrayList<>();
        list.add(new ModelFirst(R.drawable.rick_sanchez,getString(R.string.alive),getString(R.string.rick_sanchez)));
        list.add(new ModelFirst(R.drawable.morty_smith,getString(R.string.alive),getString(R.string.morty_smith)));
        list.add(new ModelFirst(R.drawable.albert_einstein,getString(R.string.dead),getString(R.string.albert_einstein)));
        list.add(new ModelFirst(R.drawable.jerry_smith,getString(R.string.alive),getString(R.string.jerry_smith)));
        return list;
    }

    @Override
    public void onClick(int p) {
        Toast.makeText(requireActivity(), "I Thanos", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        ModelFirst mode = adapter.getItem(p);
        bundle.putSerializable("model", mode);
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        getParentFragmentManager().beginTransaction().replace(R.id.nav_host,detailsFragment).addToBackStack(null).commit();

    }

}