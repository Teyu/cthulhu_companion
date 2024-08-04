package com.example.cthulhucompanion.screens.activity.chooseaction.recyclerview.enemyinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cthulhucompanion.R;

public class EnemyRecyclerViewAdapter extends RecyclerView.Adapter<EnemyViewHolder> {

    private String[] localDataSet;

    public EnemyRecyclerViewAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public EnemyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.display_enemy_info_immutable, parent, false);

        return new EnemyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnemyViewHolder holder, int position) {
        holder.getTextView().setText(localDataSet[position]);

    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
