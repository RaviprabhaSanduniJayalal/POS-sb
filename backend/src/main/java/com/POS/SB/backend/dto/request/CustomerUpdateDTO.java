package com.POS.SB.backend.dto.request;

public class CustomerUpdateDTO {
    private int CustomerID;
    private String customerName;
    private String customerAddress;
    private Double salary;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerID, String customerName, String customerAddress, Double salary) {
        this.CustomerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "CustomerID=" + CustomerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", salary=" + salary +
                '}';
    }
}

