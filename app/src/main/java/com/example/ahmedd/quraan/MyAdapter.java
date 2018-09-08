package com.example.ahmedd.quraan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ItemView> itemViews;
    private Context context;
    onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MyAdapter(Context context, List<ItemView> itemViews) {
        this.itemViews = itemViews;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        final ItemView itemView = itemViews.get(position);
        holder.txtName.setText(itemView.getName());

        if(onItemClickListener != null){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(position,itemView);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemViews.size();
    }


public interface onItemClickListener{

      public   void onClick(int position,ItemView itemView);

}

}
