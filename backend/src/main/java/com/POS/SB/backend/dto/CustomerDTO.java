package com.POS.SB.backend.dto;

import java.util.ArrayList;

public class CustomerDTO {
    private int CustomerID;
    private String customerName;
    private String customerAddress;
    private ArrayList<String> ContactNumber;
    private Double salary;
    private String NIC;
    private boolean active;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String customerName, String customerAddress, ArrayList<String> contactNumber, Double salary, String NIC, boolean active) {
        this.CustomerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.ContactNumber = contactNumber;
        this.salary = salary;
        this.NIC = NIC;
        this.active = active;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList<String> getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(ArrayList<String> contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "CustomerID=" + CustomerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", ContactNumber=" + ContactNumber +
                ", salary=" + salary +
                ", NIC='" + NIC + '\'' +
                ", active=" + active +
                '}';
    }
}
