/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kappe
 */
public class RentalRecord implements Serializable {

    private ArrayList<Freelancer> freelancers;
    private Company employer;

    public RentalRecord(ArrayList<Freelancer> freelancers, Company employer) {
        this.freelancers = freelancers;
        this.employer = employer;
    }

    public ArrayList<Freelancer> getFreelancers() {
        return freelancers;
    }

    public void setFreelancers(ArrayList<Freelancer> freelancers) {
        this.freelancers = freelancers;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    public String getFreelancerNames() {
        String names = "";

        for (int i = 0; i < freelancers.size(); i++) {
            names += freelancers.get(i).getName();
            if (i != freelancers.size() - 1) {
                names += ", ";
            }
        }

        return names;
    }

}
