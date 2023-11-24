import java.util.ArrayList;

import MainCore.Person;

public class ListProduct extends Product {
    ArrayList<Person> listPerson = new ArrayList<>();

    public ListProduct(int idProduct, String name, String type, float price, ArrayList<Person> listPerson) {
        super(idProduct, name, type, price);
        this.listPerson = listPerson;
    }

}