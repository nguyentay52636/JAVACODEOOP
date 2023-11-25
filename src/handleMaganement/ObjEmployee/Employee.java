package handleMaganement.ObjEmployee;

import handleMaganement.Person;

public class Employee extends Person {
    private String idEmployee;
    private int daysOff;
    protected int dayOfWork;

    public Employee(String name, String telephoneNumber, int age, String address, String gender, String idEmployee,
            int daysOff, int dayOfWork) {
        super(name, telephoneNumber, age, address, gender);
        this.idEmployee = idEmployee;
        this.daysOff = daysOff;
        this.dayOfWork = dayOfWork;
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

}