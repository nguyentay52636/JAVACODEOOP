import java.util.ArrayList;

import MainCore.Person;

/*4. Khách hàng có 2 loại: khách uống tại chỗ và khách mua mang đi.
 */
public class Customer extends Person {
    private boolean customerType;
    private ArrayList<SanPham> order;

    public Customer(String name, String telephoneNumber, int age, String address, String gender) {
        super(name, telephoneNumber, age, address, gender);
        // this.customerType = customerType;
        this.order = new ArrayList<>();
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }

    public ArrayList<SanPham> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<SanPham> order) {
        this.order = order;
    }

}
