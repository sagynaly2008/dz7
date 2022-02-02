package com.example.androiddz7.Model;

import java.io.Serializable;

public class ModelLocation implements Serializable {
    String location;
    String nameLocation;

    public ModelLocation(String location, String nameLocation) {
        this.location = location;
        this.nameLocation = nameLocation;
    }

    public String getLocation() {
        return location;
    }


    public String getNameLocation() {
        return nameLocation;
    }

}
