package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Magasin {
    private StringProperty name;
    private StringProperty city;
    private StringProperty region;
    private StringProperty site;

    public Magasin(String name, String city, String region, String site){
        this.name= new SimpleStringProperty(name);
        this.city= new SimpleStringProperty(city);
        this.region= new SimpleStringProperty(region);
        this.site= new SimpleStringProperty(site);
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

    public ObservableValue<String> getNameProperty() {
        return name;
    }

    public ObservableValue<String> getCityProperty() {
        return city;
    }

    public ObservableValue<String> getRegionProperty() {
        return region;
    }

    public ObservableValue<String> getSiteProperty() {
        return site;
    }
}
