package com.example.ahmedd.quraan.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.quraan.API.Model.RadioItem;
import com.example.ahmedd.quraan.R;

import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {

   private List<RadioItem> radioItems;


    public RadioAdapter(List<RadioItem> radioItems) {
        this.radioItems = radioItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtRadioChannel;

        public ViewHolder(View itemView) {
            super(itemView);

            txtRadioChannel = itemView.findViewById(R.id.txtRadioChannel);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_radio,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RadioItem item = radioItems.get(position);

        holder.txtRadioChannel.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return radioItems.size();
    }


}
