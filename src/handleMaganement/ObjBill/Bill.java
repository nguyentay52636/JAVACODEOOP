package handleMaganement.ObjBill;

import java.util.ArrayList;
import java.util.Date;

import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjOrder.SanPham;

public class Bill {
	ArrayList<SanPham> products = new ArrayList<SanPham>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();
    private Date date;
    private Customer customer;

    public Bill(Customer customer,ArrayList<SanPham> products,ArrayList<Integer> quantities) {
    	this.customer = customer;
        this.products.addAll(products);
        this.quantities.addAll(quantities);
        this.date = new Date();
    }

    public void addProduct(SanPham product, int quantity) {
        products.add(product);
        quantities.add(quantity);
    }

    public ArrayList<SanPham> getProducts() {
        return products;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public Date getDate() {
        return date;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
//        	System.out.println(products);
            SanPham product = products.get(i);
            int quantity = quantities.get(i);
            totalPrice += product.getGia() * quantity;
        }
        return totalPrice;
    }

    public void displayBill() {
        System.out.println("Hóa đơn ngày: " + date);
        System.out.println("Khách hàng: " + customer.getName());
        System.out.println("Sản phẩm\tSố lượng\tĐơn giá\t\tThành tiền");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < products.size(); i++) {
            SanPham product = products.get(i);
            int quantity = quantities.get(i);
            int totalPrice = product.getGia() * quantity;
            System.out.printf("%-20s %-16d %-16d %-16d%n", product.getTenSanPham(), quantity, product.getGia(),
                    totalPrice);
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Tổng tiền: " + calculateTotalPrice());
    }

    public Customer getCustomer() {
        return customer;
    }
}