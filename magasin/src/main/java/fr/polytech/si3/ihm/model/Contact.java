package fr.polytech.si3.ihm.model;

/**
 * Created by tanguy on 14/03/17.
 */
public class Contact {

    private String webPage;
    private String phone;
    private String address;

    public Contact() {
        address = ("06600 Antibes");
        phone = ("06.72.98.21.21");
        webPage = ("www.tobeortohave.com");
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
}