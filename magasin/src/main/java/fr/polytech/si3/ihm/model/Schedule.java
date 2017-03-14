package fr.polytech.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Almond on 12/03/2017.
 */
public class Schedule {
    private final SimpleStringProperty day;
    private final SimpleStringProperty openingHour;

    public Schedule(String day, String openingHour) {
        this.day = new SimpleStringProperty(day);
        this.openingHour = new SimpleStringProperty(openingHour);
    }

    public String getDay() {
        return day.get();
    }

    public String getOpeningHour() {
        return openingHour.get();
    }

}
