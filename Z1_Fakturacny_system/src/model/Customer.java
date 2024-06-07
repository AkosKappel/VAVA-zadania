/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kappe
 */
public class Customer {

    private String fullName;
    private String address;
    private String city;
    private String postcode;

    public Customer(String fullName, String address, String city, String postcode) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return fullName + ", " + city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
