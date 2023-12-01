package handleMaganement.ObjEmployee;

import handleMaganement.ObjBill.Bill;
import handleMaganement.ObjCustomer.Customer;

public class ManagerEmployee extends Employee {
    private Bill[] completedBills;
    private Bill[] pendingBills;

    public ManagerEmployee(String name, String telephoneNumber, int age, String address, String gender,
            String idEmployee, int daysOff, int dayOfWork, Bill[] completedBills, Bill[] pendingBills) {
        super(name, telephoneNumber, age, address, gender, idEmployee, daysOff, dayOfWork);
        this.completedBills = completedBills;
        this.pendingBills = pendingBills;
    }

    public Bill[] getCompletedBills() {
        return completedBills;
    }

    public void setCompletedBills(Bill[] completedBills) {
        this.completedBills = completedBills;
    }

    public Bill[] getPendingBills() {
        return pendingBills;
    }

    public void setPendingBills(Bill[] pendingBills) {
        this.pendingBills = pendingBills;
    }

    // Phương thức xác nhận đơn đặt hàng cho khách hàng
    public void confirmOrder(Customer customer, Bill bill) {
        System.out.println("Đơn đặt hàng của khách hàng " + customer.getName() + " đã được xác nhận.");
        System.out.println("Chi tiết đơn hàng:");
        bill.displayBill();
    }

}