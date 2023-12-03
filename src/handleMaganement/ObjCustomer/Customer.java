package handleMaganement.ObjCustomer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import handleMaganement.Person;
import handleMaganement.ObjOrder.Addon;
import handleMaganement.ObjOrder.SanPham;

public class Customer extends Person {
    private boolean isMember;
    private int birthMonth;
    private double discount;
    private boolean customerType;
    private ArrayList<SanPham> order;
    
 // Empty Constructor
    public Customer() {
        super("", "", 0, "", "");
        this.isMember = false;
        this.birthMonth = 0;
        this.discount = 0.0;
        this.order = new ArrayList<>();
    }

    public Customer(String name, String telephoneNumber, int age, String address, String gender, boolean isMember,
            int birthMonth, double discount) {
        super(name, telephoneNumber, age, address, gender);
        this.isMember = isMember;
        this.birthMonth = birthMonth;
        this.discount = discount;
        this.order = new ArrayList<>();

    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<SanPham> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<SanPham> order) {
        this.order = order;
    }
    
    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }

    public void receiveOrder() {
        System.out.println("Nhân viên " + getName() + " đang nhận đơn hàng từ khách hàng.");
        createOrder();
    }

    public void createOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin đơn hàng:");

        // Nhập thông tin về khách hàng
        System.out.print("Bạn có muốn đăng ký thành viên không? (1. Có / 2. Không): ");
        int choice = scanner.nextInt();
        boolean isMember = choice == 1;

        if (isMember) {
            System.out.print("Nhập tháng sinh nhật của bạn (1-12): ");
            int birthMonth = scanner.nextInt();
            this.setBirthMonth(birthMonth);
            this.setMember(isMember);
        } else {
        	this.setMember(false);
        }
//        System.out.print("Nhập số lượng sản phẩm trong đơn hàng: ");
//
//        int numberOfProducts = scanner.nextInt();
//
//        for (int i = 0; i < numberOfProducts; i++) {
//            System.out.println("Nhập thông tin cho sản phẩm thứ " + (i + 1) + ":");
//            SanPham sanPham = createProduct();
//            order.add(sanPham); // Thêm sản phẩm vào đơn hàng của khách hàng
//        }
        System.out.println("Đơn hàng đã được tạo!");
    }

    public SanPham createProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        String maSanPham = scanner.next();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.next();

        System.out.print("Nhập loại sản phẩm: ");
        String loai = scanner.next();

        System.out.print("Nhập giá sản phẩm: ");
        int gia = scanner.nextInt();

        System.out.print("Có đá hay không? (true/false): ");
        boolean coDa = scanner.nextBoolean();

        // Additional variables assumed to be used in the constructor of SanPham
        System.out.print("Nhập mô tả đá: ");
        String moTaDa = scanner.next();

        System.out.print("Có size hay không? (true/false): ");
        boolean coSize = scanner.nextBoolean();

        String size = "nhỏ"; // Default value for size
        if (coSize) {
            System.out.print("Nhập size: ");
            size = scanner.nextLine();
        }

        System.out.print("Nhập ghi chú: ");
        String ghiChu = scanner.next();

        SanPham sanPham = new SanPham();        
        sanPham.setMaSanPham(maSanPham);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setLoai(loai);
        sanPham.setGia(gia);
        sanPham.setCoDa(coDa);
        sanPham.setMoTaDa(moTaDa);
        sanPham.setCoSize(coSize);
        sanPham.setSize(size);
        sanPham.setGhiChu(ghiChu);
        // Tạo đối tượng SanPham và trả về
        return sanPham;
    }


    public void applyDiscount(double totalAmount) {
        if (isMember() && getBirthMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1) {
            // Nếu là thành viên và là tháng sinh nhật, giảm 10%
            double discountAmount = totalAmount * 0.1;
            setDiscount(discountAmount);
            System.out.println("Bạn đã được giảm giá " + discountAmount + " VND.");
        } else {
            System.out.println("Không có giảm giá nào được áp dụng.");
        }
    }

}
