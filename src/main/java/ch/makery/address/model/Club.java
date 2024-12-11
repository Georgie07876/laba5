package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Club.
 *
 * @author Marco Jakob
 */
public class Club {

    private final StringProperty School;
    private final StringProperty club;
    private final StringProperty director;
    private final IntegerProperty phonenumber;
    private final StringProperty adress;
    private final StringProperty clubactivity;
    private final IntegerProperty childnumber;
    private final IntegerProperty cost;

    /**
     * Default constructor.ё
     */
    public Club() {
        this(null, null, null, 0);
    }

    /**
     * Constructor with some initial data.
     *
     * @param School
     * @param club
     * @param director
     * @param phonenumber
     */
    public Club(String School, String club, String director, Integer phonenumber) {
        this.School = new SimpleStringProperty(School);
        this.club = new SimpleStringProperty(club);
        this.director = new SimpleStringProperty(director);
        this.phonenumber = new SimpleIntegerProperty(phonenumber);



        // Some initial dummy data, just for convenient testing.
        this.adress = new SimpleStringProperty("some adress");
        this.clubactivity = new SimpleStringProperty("some clubactivity");
        this.childnumber = new SimpleIntegerProperty(1234);
        this.cost = new SimpleIntegerProperty(1234);
    }

    public String getSchool() {
        return School.get();
    }

    public void setSchool(String School) {
        this.School.set(School);
    }

    public StringProperty SchoolProperty() {
        return School;
    }

    public String getclub() {
        return club.get();
    }

    public void setclub(String club) {
        this.club.set(club);
    }

    public StringProperty clubProperty() {
        return club;
    }

    public String getdirector() {
        return director.get();
    }

    public void setdirector(String director) {
        this.director.set(director);
    }

    public StringProperty directorProperty() {
        return director;
    }

    public int getphoneunmber() {
        return phonenumber.get();
    }

    public void setphonenumber(int phonenumber) {
        this.phonenumber.set(phonenumber);
    }

    public IntegerProperty phonenumberProperty() {
        return phonenumber;
    }

    public String getadress() {
        return adress.get();
    }

    public void setadress(String adress) {
        this.adress.set(adress);
    }

    public StringProperty adressProperty() {
        return adress;
    }

    public String getclubactivity() {
        return clubactivity.get();
    }

    public void setclubactivity(String clubactivity) {
        this.clubactivity.set(clubactivity);
    }

    public StringProperty clubactivityProperty() {
        return clubactivity;
    }

    public int getchildnumber() {
        return childnumber.get();
    }

    public void setchildnumber(int childnumber) {
        this.childnumber.set(childnumber);
    }

    public IntegerProperty childnumberProperty() {
        return childnumber;
    }

    public int getcost() {
        return cost.get();
    }

    public void setcost(int cost) {
        this.cost.set(cost);
    }

    public IntegerProperty costProperty() {
        return cost;
    }
}