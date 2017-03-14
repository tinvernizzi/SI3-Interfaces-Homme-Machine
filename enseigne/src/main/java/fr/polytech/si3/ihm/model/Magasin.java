package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Magasin {
    private StringProperty name;
    private StringProperty city;
    private StringProperty region;

    public Magasin(String name, String city, String region){
        this.name= new SimpleStringProperty(name);
        this.city= new SimpleStringProperty(city);
        this.region= new SimpleStringProperty(region);
    }

    public String getName(){
        return this.name.get();
    }

    public String getCity(){
        return this.city.get();
    }

    public String getRegion(){
        return this.region.get();
    }
}
