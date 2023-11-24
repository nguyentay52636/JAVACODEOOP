import MainCore.Person;

public class Employee extends Person {
    private String idEmployee;
    private int daysOff;
    private int dayOfWork;
    private Bill[] bills;
    private int numOfBills;

    public Employee(String name, String telephoneNumber, int age, String address, String gender, String idEmployee,
            int daysOff, int dayOfWork, int maxBills) {
        super(name, telephoneNumber, age, address, gender);
        this.idEmployee = idEmployee;
        this.daysOff = daysOff;
        this.dayOfWork = dayOfWork;
        this.bills = new Bill[maxBills];
        this.numOfBills = 0;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public Bill[] getBills() {
        return bills;
    }

    public void createBill(Customer customer, SanPham[] products, int[] quantities) {
        if (numOfBills < bills.length) {
            Bill bill = new Bill(customer, products, quantities);
            bills[numOfBills] = bill;
            numOfBills++;
        } else {
            System.out.println("Danh sách hóa đơn đã đầy. Không thể thêm hóa đơn mới.");
        }
    }

}