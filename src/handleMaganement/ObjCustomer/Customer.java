package handleMaganement.ObjCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import handleMaganement.Person;
import handleMaganement.ObjOrder.SanPham;

/*4. Khách hàng có 2 loại: khách uống tại chỗ và khách mua mang đi.
 */
public class Customer extends Person {
    private boolean customerType;
    private ArrayList<SanPham> order;

    public Customer(String name, String telephoneNumber, int age, String address, String gender, boolean customerType) {
        super(name, telephoneNumber, age, address, gender);
        this.customerType = customerType;
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

    public void receiveOrder() {
        System.out.println("Nhân viên " + getName() + " đang nhận đơn hàng từ khách hàng.");
        createOrder();
    }

    public void createOrder() {
        List<SanPham> orderedProducts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin đơn hàng:");

        // Nhập thông tin về khách hàng
        System.out.print("Nhập tên khách hàng: ");
        String customerName = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String customerPhoneNumber = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        Customer customer = new Customer(customerName, customerPhoneNumber, age, address, gender, true);

    }

}
