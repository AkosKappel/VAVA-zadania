/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author kappe
 */
public class Company implements Serializable {

    private String name;
    private String businessArea;
    private int employeeCount;
    private ImageIcon logo;

    public Company(String name, String businessArea, int employeeCount, ImageIcon logo) {
        this.name = name;
        this.businessArea = businessArea;
        this.employeeCount = employeeCount;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

}
