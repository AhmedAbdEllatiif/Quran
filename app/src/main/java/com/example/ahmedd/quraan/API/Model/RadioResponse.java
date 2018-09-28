package com.example.ahmedd.quraan.API.Model;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class RadioResponse {

    @SerializedName("Radios")
    List<RadioItem> radioItems;


    public List<RadioItem> getRadioItems() {
        return radioItems;
    }

    public void setRadioItems(List<RadioItem> radioItems) {
        this.radioItems = radioItems;
    }
}
