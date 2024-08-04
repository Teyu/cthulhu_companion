package com.example.cthulhucompanion.screens.activity.chooseaction.recyclerview.enemyinfo;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cthulhucompanion.R;

public class EnemyViewHolder extends RecyclerView.ViewHolder {

    TextView text;

    public EnemyViewHolder(@NonNull View view) {
        super(view);

        text = view.findViewById(R.id.life_points_immutable_tv);
    }

    TextView getTextView(){
        return text;
    }
}
