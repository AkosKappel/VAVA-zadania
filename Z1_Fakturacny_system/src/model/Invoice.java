/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kappe
 */
public class Invoice {

    private Date issueDate;
    private Customer customer;
    private ArrayList<Product> products;
    private ArrayList<Integer> productCounts;
    private double totalSum;

    public Invoice(Date issueDate, Customer customer, ArrayList<Product> products, ArrayList<Integer> productsCount, double totalSum) {
        this.issueDate = issueDate;
        this.customer = customer;
        this.products = products;
        this.productCounts = productsCount;
        this.totalSum = totalSum;
    }

    public String toString(DecimalFormat formatter, SimpleDateFormat dateFormatter) {
        String str = "\n\n";
        for (int i = 0; i < products.size(); i++) {
            str += products.get(i).toString(formatter) + ", " + 
                   String.valueOf(productCounts.get(i)) + " ks\n";
        }
        return "Meno: " + customer.getFullName() + "\nAdresa: " + customer.getAddress() + 
               "\nMesto: " + customer.getCity() + "\nPSČ: " + customer.getPostcode() + 
               "\nDátum: " + dateFormatter.format(issueDate) + str + 
               "\nSpolu: " + formatter.format(totalSum) + " €\n";
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Integer> getProductCounts() {
        return productCounts;
    }

    public void setProductCounts(ArrayList<Integer> productCounts) {
        this.productCounts = productCounts;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

}
