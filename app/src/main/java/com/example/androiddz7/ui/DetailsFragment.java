package com.example.androiddz7.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androiddz7.Model.ModelFirst;
import com.example.androiddz7.Model.ModelLocation;
import com.example.androiddz7.databinding.FragmentDetailsBinding;


public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    private ModelFirst modelFirst;
    private ModelLocation modelLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getInformationLocation();
        getInformationPerson();

    }

    private void getInformationLocation() {
        assert getArguments() != null;
        modelLocation = (ModelLocation) getArguments().getSerializable("model2");
        if (modelLocation != null){
            binding.textName.setText(modelLocation.getNameLocation());
            binding.live.setText(modelLocation.getLocation());
        }
    }

    private void getInformationPerson() {
        assert getArguments() != null;
        modelFirst = (ModelFirst) getArguments().getSerializable("model");
        if (modelFirst != null) {
            binding.image.setImageResource(modelFirst.getImageView());
            binding.live.setText(modelFirst.getThe_live());
            binding.textName.setText(modelFirst.getName());
        }
    }


}