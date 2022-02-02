package com.example.androiddz7.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddz7.Model.ModelLocation;
import com.example.androiddz7.databinding.ItemRecyclerLocationBinding;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private ArrayList<ModelLocation> list;
    private OnItemClickListener click;

    public void updateData(ArrayList<ModelLocation> list,OnItemClickListener onClick){
        this.list = new  ArrayList<>();
        this.list = list;
        click = onClick;
        notifyDataSetChanged();
    }
    public ModelLocation getItem (int p){
        return list.get(p);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemRecyclerLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(view -> {
            click.OnClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerLocationBinding binding;

        public ViewHolder(@NonNull ItemRecyclerLocationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }


        public void bind(ModelLocation modelLocation) {
            binding.location.setText(modelLocation.getLocation());
            binding.nameLocation.setText(modelLocation.getNameLocation());
        }
    }

    public interface OnItemClickListener  {
        void OnClick(int p);
    }
}
