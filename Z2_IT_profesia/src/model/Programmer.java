/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author kappe
 */
public class Programmer extends Freelancer {

    private String type;                     // zaradenie/typ (Java, C++, ABAP, VBA, Python, Ruby, iOS, ...)

    public Programmer(String name, String type, double pricePerDay,
            int practiceLength, String highestEducation, ArrayList<String> certificates) {
        super(name, pricePerDay, practiceLength, highestEducation, certificates);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDetails() {
        return "Typ špecialistu: " + getSpecialistType()
                + "\nMeno: " + getName()
                + "\nCena za deň: " + new DecimalFormat("########0.00").format(getPricePerDay()) + " €"
                + "\nDĺžka praxe: " + getPracticeLength() + " rokov"
                + "\nNajvyššie dosiahnuté vzdelanie: " + getHighestEducation()
                + "\nZaradenie: " + getType()
                + "\nCertifikáty: " + getCertificatesString();
    }

    @Override
    public String getSpecialistType() {
        return "Programátor";
    }

    @Override
    public String getCertificatesString() {
        String certificates = "";
        ArrayList<String> lst = getCertificates();

        for (int i = 0; i < lst.size(); i++) {
            certificates += lst.get(i);
            if (i != lst.size() - 1) {
                certificates += ", ";
            }
        }

        return certificates;
    }

}
