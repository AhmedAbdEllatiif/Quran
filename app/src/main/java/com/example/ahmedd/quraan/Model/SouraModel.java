package com.example.ahmedd.quraan.Model;

public class SouraModel {

    private String name ;
    private String ayah;

    public SouraModel(String name, String ayah) {
        this.name = name;
        this.ayah = ayah;
    }

    public SouraModel(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAyah() {
        return ayah;
    }
}
