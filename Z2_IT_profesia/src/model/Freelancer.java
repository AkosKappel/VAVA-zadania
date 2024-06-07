/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author kappe
 */
public abstract class Freelancer implements Specialist, Serializable {

    private double pricePerDay;              // cena za den
    private int practiceLength;              // dlzka praxe v rokoch
    private String highestEducation;         // najvyssie dosiahnute vzdelanie
    private ArrayList<String> certificates;  // certifikaty
    private String name;
    private boolean available;

    public Freelancer(String name, double pricePerDay, int practiceLength,
            String highestEducation, ArrayList<String> certificates) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.practiceLength = practiceLength;
        this.highestEducation = highestEducation;
        this.certificates = certificates;
        this.available = true;  // po vytvoreni je automaticky dostupny
    }

    abstract public String getCertificatesString();

    @Override
    public String toString() {
        return name + ", " + new DecimalFormat("########0.00").format(getPricePerDay()) + " €";
    }

    @Override
    public String getSpecialistType() {
        return "";
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPracticeLength() {
        return practiceLength;
    }

    public void setPracticeLength(int practiceLength) {
        this.practiceLength = practiceLength;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public ArrayList<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<String> certificates) {
        this.certificates = certificates;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
