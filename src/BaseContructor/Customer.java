
import java.util.ArrayList;
import java.util.List;

class Customer {
    private CustomerType customerType;
    private int numberOfCustomers;
    private Table table;
    private List<Product> order;

    public Customer(CustomerType customerType, int numberOfCustomers) {
        this.customerType = customerType;
        this.numberOfCustomers = numberOfCustomers;
        this.order = new ArrayList<>();
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Product> getOrder() {
        return order;
    }

    public void setOrder(List<Product> order) {
        this.order = order;
    }
public void placeOrder(Order order) {
    
}
}
/*
 placeOrder(Order order): Đặt đơn hàng và liên kết nó với khách hàng.
selectTable(Table table): Chọn bàn nếu khách hàng dùng tại chỗ.
 */