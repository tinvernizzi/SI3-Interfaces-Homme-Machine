package fr.polytech.si3.ihm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguy on 14/03/17.
 */
public class Contact {

    private String webPage;
    private String phone;
    private String address;


    private List<Schedule> schedules;

    public Contact() {
        address = ("06600 Antibes");
        phone = ("06.72.98.21.21");
        webPage = ("www.tobeortohave.com");
        //init of schedule
        schedules = new ArrayList<Schedule>();
        schedules.add((new Schedule("Lun", "09:00 à 19:00")));
        schedules.add((new Schedule("Mar", "09:00 à 19:00")));
        schedules.add((new Schedule("Mer", "09:00 à 19:00")));
        schedules.add((new Schedule("Jeu", "09:00 à 19:00")));
        schedules.add((new Schedule("Ven", "09:00 à 19:00")));
        schedules.add((new Schedule("Sam", "09:00 à 12:00")));
        schedules.add((new Schedule("Dim", "Fermé")));
    }

    public String getWebPage() {
        return webPage;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public String getAdress() {
        return address;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public void setPhoneNumber(String phoneNumber) {
        phone = phoneNumber;
    }

    public void setAdress(String adress) {
        address = adress;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedules = schedule;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
