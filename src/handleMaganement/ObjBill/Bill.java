package handleMaganement.ObjBill;

import java.util.Date;

import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjOrder.SanPham;

public class Bill {
    private SanPham[] products;
    private int[] quantities;
    private int size; // Kích thước hiện tại của mảng
    private Date date;
    private Customer customer;

    public Bill(Customer customer, SanPham[] products, int[] quantities) {
        this.products = products;
        this.quantities = quantities;
        this.size = products.length; // Đặt size là chiều dài của mảng products
        this.date = new Date(); // Sử dụng ngày hiện tại làm ngày của hóa đơn
    }

    public void addProduct(SanPham product, int quantity) {
        if (size < products.length) {
            products[size] = product;
            quantities[size] = quantity;
            size++;
        } else {
            System.out.println("Mảng đã đầy, không thể thêm sản phẩm mới.");
        }
    }

    public SanPham[] getProducts() {
        return products;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public Date getDate() {
        return date;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < size; i++) {
            SanPham product = products[i];
            int quantity = quantities[i];
            totalPrice += product.getGia() * quantity;
        }
        return totalPrice;
    }

    public void displayBill() {
        System.out.println("Hóa đơn ngày: " + date);
        System.out.println("Khách hàng: " + customer.getName());
        System.out.println("Sản phẩm\t\tSố lượng\t\tĐơn giá\t\tThành tiền");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < size; i++) {
            SanPham product = products[i];
            int quantity = quantities[i];
            int totalPrice = product.getGia() * quantity;
            System.out.printf("%-20s %-16d %-16d %-16d%n", product.getTenSanPham(), quantity, product.getGia(),
                    totalPrice);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Tổng tiền: " + calculateTotalPrice());
    }
}