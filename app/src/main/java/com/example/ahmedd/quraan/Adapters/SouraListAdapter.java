package com.example.ahmedd.quraan.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.quraan.Model.SouraModel;
import com.example.ahmedd.quraan.R;

import java.util.List;

public class SouraListAdapter extends RecyclerView.Adapter<SouraListAdapter.ViewHolder> {
    private List<SouraModel> souraModels;
    private Context context;
    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SouraListAdapter(Context context, List<SouraModel> souraModels) {
        this.souraModels = souraModels;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_souraname_, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        final SouraModel souraModel = souraModels.get(position);
        holder.txtName.setText(souraModel.getName());

        if(onItemClickListener != null){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onClick(position, souraModel);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return souraModels.size();
    }


public interface onItemClickListener{

      void onClick(int position, SouraModel souraModel);

}

}
