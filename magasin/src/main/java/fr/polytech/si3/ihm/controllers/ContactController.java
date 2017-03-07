package fr.polytech.si3.ihm.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * Created by Antoine on 3/7/2017.
 */
public class ContactController {
    public Label adress;
    public Label phone;
    public Label webPage;
    public ImageView map;
    public ListView schedules;
    public BorderPane contactView;

    public Label getAdress() {
        return adress;
    }

    public void setAdress(Label adress) {
        this.adress = adress;
    }

    public Label getPhone() {
        return phone;
    }

    public void setPhone(Label phone) {
        this.phone = phone;
    }

    public Label getWebPage() {
        return webPage;
    }

    public void setWebPage(Label webPage) {
        this.webPage = webPage;
    }

    public ImageView getMap() {
        return map;
    }

    public void setMap(ImageView map) {
        this.map = map;
    }

    public ListView getSchedules() {
        return schedules;
    }

    public void setSchedules(ListView schedules) {
        this.schedules = schedules;
    }
}
