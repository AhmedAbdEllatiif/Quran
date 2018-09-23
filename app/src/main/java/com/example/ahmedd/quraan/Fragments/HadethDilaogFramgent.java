package com.example.ahmedd.quraan.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahmedd.quraan.R;

public class HadethDilaogFramgent extends DialogFragment {

   private String title, content;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HadethDilaogFramgent() {
    }


    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.ahadeth_dialog_fragment,container,false);

        TextView txtContent = view.findViewById(R.id.txtContent);
        TextView txtDialogTitle = view.findViewById(R.id.txtDialogTitle);

        txtDialogTitle.setText(title);
        txtContent.setText(content);

       return view;
    }
}
