package com.example.ahmedd.quraan.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.quraan.Model.ItemView;
import com.example.ahmedd.quraan.R;

import java.util.List;

public class SouraAdapter extends RecyclerView.Adapter<SouraAdapter.ViewHolder> {
    private List<ItemView> itemViews;
    private Context context;


    public SouraAdapter(Context context, List<ItemView> itemViews) {
        this.itemViews = itemViews;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtAyah;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAyah = (TextView) itemView.findViewById(R.id.txtAyah);

        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ayah_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        final ItemView itemView = itemViews.get(position);
        holder.txtAyah.setText(itemView.getAyah());



    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }

//ViewHolder


}
