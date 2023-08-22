package com.example.planetapp;

//this class acts as model class for our listView
public class Planets {
    //Attributes
    private String planetName, moonCount;
    private int planetImage;

    //Constructor
    public Planets(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
