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
public class Administrator extends Freelancer {

    private String preferedPlatform;         // preferovana platforma/system
    private String type;                     // zaradenie/typ (Aplikacny, Sietovy, SAP, ...)

    public Administrator(String name, String preferedPlatform, String type, double pricePerDay,
            int practiceLength, String highestEducation, ArrayList<String> certificates) {
        super(name, pricePerDay, practiceLength, highestEducation, certificates);
        this.preferedPlatform = preferedPlatform;
        this.type = type;
    }

    public String getPreferedPlatform() {
        return preferedPlatform;
    }

    public void setPreferedPlatform(String preferedPlatform) {
        this.preferedPlatform = preferedPlatform;
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
                + "\nCertifikáty: " + getCertificatesString()
                + "\nPreferovaná platforma: " + getPreferedPlatform();
    }

    @Override
    public String getSpecialistType() {
        return "Administrátor";
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
