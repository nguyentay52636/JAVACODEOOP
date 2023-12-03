package handleMaganement.ObjEmployee;

import java.util.ArrayList;
import java.util.List;

import handleMaganement.ObjBill.Bill;
import handleMaganement.ObjCustomer.Customer;

public class ManagerEmployee extends Employee {
    private List<Bill> completedBills;
    private List<Bill> pendingBills;
    // key de tham chieu den nhan vien pha che
    private BartenderEmployee bartenderEmployee;

    
 // Empty Constructor
    public ManagerEmployee() {
        super("", "", 0, "", "", "", 0, 0);
        this.completedBills = new ArrayList<>();
        this.pendingBills = new ArrayList<>();
        this.bartenderEmployee = new BartenderEmployee("", "", 0, "", "", "", 0, 0, null);
    }
    
    public ManagerEmployee(String name, String telephoneNumber, int age, String address, String gender,
            String idEmployee,
            int daysOff, int dayOfWork, List<Bill> completedBills, List<Bill> pendingBills,
            BartenderEmployee bartenderEmployee) {
        super(name, telephoneNumber, age, address, gender, idEmployee, daysOff, dayOfWork);
        this.completedBills = completedBills;
        this.pendingBills = pendingBills;
        this.bartenderEmployee = bartenderEmployee;
    }

    public List<Bill> getCompletedBills() {
        return completedBills;
    }

    public void setCompletedBills(List<Bill> completedBills) {
        this.completedBills = completedBills;
    }

    public List<Bill> getPendingBills() {
        return pendingBills;
    }

    public void setPendingBills(List<Bill> pendingBills) {
        this.pendingBills = pendingBills;
    }

    public BartenderEmployee getBartenderEmployee() {
        return bartenderEmployee;
    }

    public void setBartenderEmployee(BartenderEmployee bartenderEmployee) {
        this.bartenderEmployee = bartenderEmployee;
    }

    // Phương thức để đặt đơn đặt hàng vào danh sách chờ
    public void placeOrder(Bill order) {
        if (pendingBills == null) {
            pendingBills = new ArrayList<>();
        }
        pendingBills.add(order);
        System.out.println("Đơn đặt hàng đã được đặt.");
    }

    // Phương thức để xử lý đơn đặt hàng
    public void processOrders() {
        if (pendingBills != null) {
            for (Bill order : pendingBills) {
                System.out.println("Đang xử lý đơn đặt hàng của khách hàng " + order.getCustomer().getName());
                confirmOrder(order.getCustomer(), order);
                completedBills.add(order);
            }
            pendingBills.clear();
        }
    }

    // Hiển thị danh sách các đơn hàng đã hoàn thành

    public void displayCompletedOrders() {
        if (completedBills != null) {
            System.out.println("Danh sách các đơn hàng đã hoàn thành:");
            for (Bill order : completedBills) {
                order.displayBill();
            }
        }
    }

    // Phương thức xác nhận đơn đặt hàng cho khách hàng
    public void confirmOrder(Customer customer, Bill bill) {
        System.out.println("Đơn đặt hàng của khách hàng " + customer.getName() + " đã được xác nhận.");
        System.out.println("Chi tiết đơn hàng:");
        bill.displayBill();
    }
    // Phương thức để tính tổng và in hóa đơn

    public void calculateTotalAndPrintBill(Bill bill) {
        bill.displayBill();
    }
}