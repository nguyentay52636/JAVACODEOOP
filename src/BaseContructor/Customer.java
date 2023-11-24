package BaseContructor;

import java.util.ArrayList;

import MainCore.Person;

public class Customer extends Person {
    private boolean customerType;
    private int numberOfCustomers;
    private ArrayList<Product> order;

    public Customer(String name, String telephoneNumber, int age, String address, String gender, boolean customerType,
            int numberOfCustomers, ArrayList<Product> order) {
        super(name, telephoneNumber, age, address, gender);
        this.customerType = customerType;
        this.numberOfCustomers = numberOfCustomers;
        this.order = order;
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public ArrayList<Product> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Product> order) {
        this.order = order;
    }

}