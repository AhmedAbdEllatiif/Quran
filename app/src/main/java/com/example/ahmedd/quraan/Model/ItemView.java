package com.example.ahmedd.quraan.Model;

public class ItemView {

    String name ;
    String ayah;
    public ItemView(String name, String ayah) {
        this.name = name;
        this.ayah = ayah;
    }

    public ItemView(String string) {
        this.name = string;
    }

    public String getAyah() {
        return ayah;
    }

    public void setAyah(String ayah) {
        this.ayah = ayah;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
