
package handleMaganement.ObjEmployee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import handleMaganement.Person;

public class Employee extends Person {
    private String idEmployee;
    private String position;
    private String salary;

    public Employee() {
        //
    }

    public Employee(String idEmployee, String name, String address, int age, String telephoneNumber, String gender,
            String position, String salary) {
        // Gọi constructor của lớp cha
        super(name, telephoneNumber, age, address, gender);
        this.idEmployee = idEmployee;
        this.position = position;
        this.salary = salary;
    }

    // Getter và setter cho idEmployee
    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    // Getter và setter cho position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Getter và setter cho salary
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    // Các phương thức khác trong lớp

    public void inputForEmployee() {
        Scanner sc = new Scanner(System.in);
        Matcher matcher;
        do {
            System.out.print("Nhap ma nhan vien: ");
            setIdEmployee(sc.nextLine());
            String s = "^NV[0-9]{2}$";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(getIdEmployee());
        } while (!matcher.find());

        do {
            System.out.print("Nhap ten nhan vien: ");
            super.setName(sc.nextLine());
            String s = "[^0-9]";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(super.getName());
        } while (!matcher.find());

        System.out.print("Nhap dia chi nhan vien: ");
        super.setAddress(sc.nextLine());

        do {
            System.out.print("Nhap tuoi nhan vien: ");
            super.setAge(Integer.parseInt(sc.nextLine()));
            String s = "^[0-9]{2}";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(Integer.toString(super.getAge()));

        } while (!matcher.find());

        do {
            System.out.print("Nhap so dien thoai nhan vien: ");
            super.setTelephoneNumber(sc.nextLine());
            String s = "^[0-9]{10,11}";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(super.getTelephoneNumber());
        } while (!matcher.find());
    }

    public void position() {
        setPosition("none");
    }

    public void salary() {
        setSalary("none");
    }

    // ... (giữ nguyên phần code của bạn)

    // Các phương thức khác giữ nguyên phần code của bạn

    @Override
    public String toString() {
        // Đổi tên phương thức getEmployeeId() thành getIdEmployee()
        return String.format("| %-10s %-20s %-30s %-10s %-15s %-15s %-20s |",
                getIdEmployee(), super.getName(), super.getAddress(), super.getAge(), super.getTelephoneNumber(),
                getPosition(),
                getSalary());
    }

    public void output() {
        System.out.println(toString());
    }

    public void getLineFromFile(String line) {
        String[] str = line.split(";");
        setIdEmployee(str[0]);
        super.setName(str[1]);
        super.setAddress(str[2]);
        super.setAge(Integer.parseInt(str[3]));
        super.setTelephoneNumber(str[4]);
        setPosition(str[5]);
        setSalary(str[6]);
    }

    public String mergeInformationToFile() {
        return String.format("%s;%s;%s;%s;%s;%s;%s", getIdEmployee(), super.getName(), super.getAddress(),
                super.getAge(), super.getTelephoneNumber(), getPosition(), getSalary());
    }
}
