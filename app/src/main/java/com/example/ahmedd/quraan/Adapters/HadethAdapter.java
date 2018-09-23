package com.example.ahmedd.quraan.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.quraan.Model.HadethItemView;
import com.example.ahmedd.quraan.R;

import java.util.ArrayList;

public class HadethAdapter extends RecyclerView.Adapter<HadethAdapter.ViewHolder> {

    ArrayList<HadethItemView> itemViews;
    Context context;
    onItemClickListener onCardClickListener;



    public HadethAdapter(ArrayList<HadethItemView> itemViews, Context context) {
        this.itemViews = itemViews;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtHadethTitle;
        CardView hadeth_cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            txtHadethTitle = itemView.findViewById(R.id.txtHadethTitle);
            hadeth_cardView = itemView.findViewById(R.id.hadeth_cardView);
        }
    }

    public void setOnCardClickListener (onItemClickListener onCardClickListener){
        this.onCardClickListener = onCardClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_hadeth,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final HadethItemView itemView = itemViews.get(position);

        holder.txtHadethTitle.setText(itemView.getTitle());

        if (onCardClickListener != null){

            holder.hadeth_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardClickListener.onClick(position,itemView);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }


    public interface onItemClickListener{

        void onClick(int position, HadethItemView itemView);
    }

}
