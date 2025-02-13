package com.POS.SB.backend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="Customer_ID",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerID;

    @Column(name="Customer_Name",length = 100)
    private String customerName;

    @Column(name="Customer_Address",length = 400)
    private String customerAddress;

    @Type(JsonType.class)
    @Column(name="Contact_Numbers",length = 20,columnDefinition = "json")
    private ArrayList<String> ContactNumber;

    @Column(name = "Customer_Salary")
    private Double salary;

    @Column(name="nic")
    private String NIC;

    @Column(name="active_State",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customers")
    private Set<Order> orders;


    public Customer() {
    }

    public Customer(int customerID, String customerName, String customerAddress, ArrayList<String> contactNumber, Double salary, String NIC, boolean active) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
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
