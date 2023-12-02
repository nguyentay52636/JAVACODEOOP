package handleMaganement.ObjEmployee;

import java.util.ArrayList;
import java.util.Scanner;

import handleMaganement.ObjBill.Bill;
import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjOrder.SanPham;

public class OrderEmployee extends Employee {
    private ArrayList<Bill> bills;
    private boolean isDineIn;
    private int numCustomers;
    private String selectedTable;
    private String Status;
    Scanner scanner = new Scanner(System.in);

    public OrderEmployee(String name, String telephoneNumber, int age, String address, String gender, String idEmployee,
            int daysOff, int dayOfWork, ArrayList<Bill> bills, boolean isDineIn, int numCustomers,
            String selectedTable, String Status, Scanner scanner) {
        super(name, telephoneNumber, age, address, gender, idEmployee, daysOff, dayOfWork);
        this.bills = bills;
        this.isDineIn = isDineIn;
        this.numCustomers = numCustomers;
        this.selectedTable = selectedTable;
        this.Status = Status;
        this.scanner = scanner;
    }

    public OrderEmployee() {
        super(null, null, 0, null, null, null, 0, 0);
        this.bills = new ArrayList<>();
        this.isDineIn = false;
        this.numCustomers = 0;
        this.selectedTable = null;
        this.Status = null;
        this.scanner = new Scanner(System.in);
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public boolean isDineIn() {
        return isDineIn;
    }

    public void setDineIn(boolean isDineIn) {
        this.isDineIn = isDineIn;
        if (isDineIn) {
            System.out.print("Nhập số lượng khách hàng: ");
            this.numCustomers = scanner.nextInt();
            System.out.print("Chọn bàn phù hợp: ");
            this.selectedTable = scanner.next();
        }
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    private void confirmOrder(Customer customer, Bill bill) {
        System.out.println("Đơn đặt hàng của khách hàng" + customer.getName() + " đã được xác nhận.");
        System.out.println("Chi tiết đơn hàng:");
        bill.displayBill();
    }

    public void createBill(Customer customer,ArrayList<SanPham> products,ArrayList<Integer> quantities) {
    	this.Status = "Đang Đặt";
        if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
            Bill bill = new Bill(customer,products,quantities);
            bills.add(bill);
            confirmOrder(customer, bill);
        } else {
            System.out.println("Không thể đặt đơn khi không ở trạng thái 'Đang Đặt'.");
        }
    }

    public void modifyOrder(Bill bill) {
        if ("Đang Đặt".equalsIgnoreCase(this.getStatus())) {
            System.out.println("Đơn hàng hiện tại:");
            bill.displayBill();
            System.out.println("1. Thay đổi nước uống");
            System.out.println("2. Thêm/Sửa đổi món");
            System.out.print("Chọn hành động (1 hoặc 2): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    String newProductCode = scanner.next();
                    System.out.println("Nhập số lượng mới: ");
                    int newQuantity = scanner.nextInt();
                    for (int i = 0; i < bill.getProducts().size(); i++) {
                        if (bill.getProducts().get(i).getMaSanPham().equals(newProductCode)) {
                            bill.getQuantities().set(i, newQuantity);
                            System.out.println("Thay đổi nước uống thành công.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập mã sản phẩm mới: ");
                    String newProductCode2 = scanner.next();
                    System.out.println("Nhập số lượng mới: ");
                    int newQuantity2 = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < bill.getProducts().size(); i++) {
                        if (bill.getProducts().get(i).getMaSanPham().equals(newProductCode2)) {
                            int updatedQuantity = bill.getQuantities().get(i) + newQuantity2;
                            bill.getQuantities().set(i, updatedQuantity);
                            System.out.println("Thêm/Sửa đổi món thành công.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm trong đơn hàng. Thêm mới...");
                        // Thêm sản phẩm mới vào đơn hàng
                        System.out.print("Nhập mã sản phẩm mới: ");
                        String newProductCode3 = scanner.next();
                        System.out.println("Thêm món mới thành công.");
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println("Đơn hàng sau khi thay đổi:");
            bill.displayBill();
        } else {
            System.out.println("Không thể thay đổi đơn hàng đã đặt.");
        }
    }
}
