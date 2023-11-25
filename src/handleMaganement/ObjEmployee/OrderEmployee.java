package handleMaganement.ObjEmployee;

import java.util.Scanner;

import handleMaganement.ObjBill.Bill;
import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjOrder.SanPham;

public class OrderEmployee extends Employee {
    private Bill[] bills;
    private int numOfBills;
    private boolean isDineIn; // Biến để kiểm tra xem khách hàng dùng tại chỗ hay mang đi
    private int numCustomers; // Số lượng khách hàng khi dùng tại chỗ
    private String selectedTable;
    private String Status;
    Scanner scanner = new Scanner(System.in);

    public OrderEmployee(String name, String telephoneNumber, int age, String address, String gender, String idEmployee,
            int daysOff, int dayOfWork, Bill[] bills, int numOfBills, boolean isDineIn, int numCustomers,
            String selectedTable, String Status, Scanner scanner) {
        super(name, telephoneNumber, age, address, gender, idEmployee, daysOff, dayOfWork);
        this.bills = bills;
        this.numOfBills = numOfBills;
        this.isDineIn = isDineIn;
        this.numCustomers = numCustomers;
        this.selectedTable = selectedTable;
        this.Status = Status;
        this.scanner = scanner;
    }

    public Bill[] getBills() {
        return bills;
    }

    public void setBills(Bill[] bills) {
        this.bills = bills;
    }

    public int getNumOfBills() {
        return numOfBills;
    }

    public void setNumOfBills(int numOfBills) {
        this.numOfBills = numOfBills;
    }

    public boolean isDineIn() {
        return isDineIn;
    }

    public void setDineIn(boolean isDineIn) {
        this.isDineIn = isDineIn;
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

    // Thêm hàm để hỏi khách hàng có dùng tại chỗ hay mang đi
    public void askDineInOrTakeAway(boolean isDineIn) {
        this.isDineIn = isDineIn;
        if (isDineIn) {
            System.out.print("Nhập số lượng khách hàng: ");
            this.numCustomers = scanner.nextInt();
            System.out.print("Chọn bàn phù hợp: ");
            this.selectedTable = scanner.next();
        }
    }

    private void confirmOrder(Customer customer, Bill bill) {
        System.out.println("Đơn đặt hàng của khách hàng " + customer.getName() + " đã được xác nhận.");
        System.out.println("Chi tiết đơn hàng:");
        bill.displayBill();
    }

    // tao bill , dat don thong qua ung dung
    public void createBill(Customer customer, SanPham[] products, int[] quantities) {
        if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
            if (numOfBills < bills.length) {
                Bill bill = new Bill(customer, products, quantities);
                bills[numOfBills] = bill;
                numOfBills++;
                confirmOrder(customer, bill);
            } else {
                System.out.println("Danh sách hóa đơn đã đầy. Không thể thêm hóa đơn mới.");
            }
        } else {
            System.out.println("Không thể đặt đơn khi không ở trạng thái 'Đang Đặt'.");
        }
    }

    // Hạn chế việc thay đổi khi đơn đã đặt
    public void changeOrder(Bill bill, SanPham newProduct, int newQuanlity) {
        if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
        } else {
            System.out.println("Không thể thay đổi đơn hàng đã đặt.");
        }

    }

    // Kiem tra ton tai don hang
    public static SanPham findProdductByID(String productID, SanPham[] products) {
        for (SanPham product : products) {
            if (product.getMaSanPham().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    // Phương thức để thay đổi nước uống hoặc thêm/sửa đổi món
    public void modifyOrder(Bill bill) {
        if ("Đang Đặt".equalsIgnoreCase(this.getStatus())) {
            System.out.println("Đơn hàng hiện tại:");
            bill.displayBill();
            // Hỏi khách hàng muốn thực hiện thay đổi gì
            System.out.println("1. Thay đổi nước uống");
            System.out.println("2. Thêm/Sửa đổi món");
            System.out.print("Chọn hành động (1 hoặc 2): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Thực hiện thay đổi nước uống
                    System.out.println("Nhập mã sản phẩm mới: ");
                    String newProductCode = scanner.next();
                    System.out.println("Nhập số lượng mới: ");
                    int newQuantity = scanner.nextInt();
                    // Tìm sản phẩm trong đơn hàng và thay đổi
                    for (int i = 0; i < bill.getProducts().length; i++) {
                        if (bill.getProducts()[i].getMaSanPham().equals(newProductCode)) {
                            bill.getQuantities()[i] = newQuantity;
                            System.out.println("Thay đổi nước uống thành công.");
                            break;
                        }
                    }
                    break;
                case 2:
                    // Thực hiện thêm/sửa đổi món
                    System.out.println("Nhập mã sản phẩm mới: ");
                    String newProductCode2 = scanner.nextLine();
                    System.out.println("Nhập số lượng mới: ");
                    int newQuantity2 = scanner.nextInt();
                    // Tìm sản phẩm trong đơn hàng và thêm/sửa đổi
                    boolean found = false;
                    for (int i = 0; i < bill.getProducts().length; i++) {
                        if (bill.getProducts()[i].getMaSanPham().equals(newProductCode2)) {
                            bill.getQuantities()[i] += newQuantity2;
                            System.out.println("Thêm/Sửa đổi món thành công.");
                            found = true;
                            break;
                        }
                    }
                    // Nếu sản phẩm chưa có trong đơn hàng, thêm mới
                    if (!found) {

                        // Thêm sản phẩm mới vào đơn hàng

                        System.out.print("Nhập mã sản phẩm mới: ");
                        // String newProductCode = scanner.nextLine();
                        // kiem tra san pham ton tai khong

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