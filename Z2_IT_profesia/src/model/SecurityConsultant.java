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
public class SecurityConsultant extends Freelancer {

    private boolean kybersecurityAuditor;  // NBU

    public SecurityConsultant(String name, boolean kybersecurityAuditor, double pricePerDay,
            int practiceLength, String highestEducation, ArrayList<String> certificates) {
        super(name, pricePerDay, practiceLength, highestEducation, certificates);
        this.kybersecurityAuditor = kybersecurityAuditor;
    }

    public boolean isKybersecurityAuditor() {
        return kybersecurityAuditor;
    }

    public void setKybersecurityAuditor(boolean kybersecurityAuditor) {
        this.kybersecurityAuditor = kybersecurityAuditor;
    }

    @Override
    public String getDetails() {
        String details = "Typ špecialistu: " + getSpecialistType()
                + "\nMeno: " + getName()
                + "\nCena za deň: " + new DecimalFormat("########0.00").format(getPricePerDay()) + " €"
                + "\nDĺžka praxe: " + getPracticeLength() + " rokov"
                + "\nNajvyššie dosiahnuté vzdelanie: " + getHighestEducation()
                + "\nCertifikáty: " + getCertificatesString()
                + "\nJe/nie je audítor kybernetickej bezpečnosti NBU: ";
        details += isKybersecurityAuditor() ? "áno" : "nie";
        return details;
    }

    @Override
    public String getSpecialistType() {
        return "Bezpečnostný konzultant";
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
