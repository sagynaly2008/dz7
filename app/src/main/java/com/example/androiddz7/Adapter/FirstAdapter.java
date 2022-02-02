package com.example.androiddz7.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddz7.Model.ModelFirst;
import com.example.androiddz7.databinding.ItemRecyclerFirstBinding;

import java.util.ArrayList;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder> {
    private ArrayList<ModelFirst> list;
    private OnItemClickListener click;

    public void updateData(ArrayList<ModelFirst> list, OnItemClickListener onClick) {
        this.list = new ArrayList<>();
        this.list = list;
        click = onClick;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemRecyclerFirstBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(view -> {
            click.onClick(position);
        });
    }
    public ModelFirst getItem (int p){
        return list.get(p);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerFirstBinding binding;

        public ViewHolder(@NonNull ItemRecyclerFirstBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(ModelFirst modelFirst) {
            binding.imageView.setImageResource(modelFirst.getImageView());
            binding.live.setText(modelFirst.getThe_live());
            binding.name.setText(modelFirst.getName());
        }
    }

    public interface OnItemClickListener {
        void onClick(int p);
    }

}
