
/*2. Thực đơn của quán bao gồm 4 loại nước uống chính: Trà sữa, cà phê, sinh
tố và nước trái cây.
3. Sản phẩm: Mỗi loại nước uống có nhiều lựa chọn gọi là sản phẩm của quán
ví dụ Trà sửa có Trà sữa đường đen, trà sữa trân châu, hồng trà, trà đào, Trà
chanh,...Nước trái cây có nước ép táo, nước ép thơm,...Mỗi sản phẩm có giá
riêng.
Mỗi sản phẩm có thể uống đá hoặc không đá nhưng phụ thuộc vào từng sản
phẩm. ví dụ cà phê có thể uống đá hoặc không nhưng trà sữa trân châu hoặc
Trà sữa đường đen thì chỉ cung cấp 1 loại là uống với đá.
Mỗi phần sẽ có 3 cỡ: cỡ nhỏ, vừa và lớn.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class QuanNuoc {

    // Tạo danh sách sản phẩm
    private ArrayList<SanPham> menu = new ArrayList<>();
    private OrderManager orderManager = new OrderManager();

    public QuanNuoc() {
        // Constructor - Thêm các sản phẩm vào menu ở đây
        themSanPhamVaoMenu();
    }

    public void thucHienChucNang() {
        hienThiMenu();

        // Nhập số lượng món nước cần gọi
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng món nước bạn muốn gọi: ");
        int soLuong = scanner.nextInt();

        // Kiểm tra xem số lượng có hợp lệ không
        if (soLuong <= 0) {
            System.out.println("Số lượng không hợp lệ.");
            return;
        }

        // Mảng để lưu thông tin về món nước đã chọn
        SanPham[] monsDaChon = new SanPham[soLuong];

        // Nhập loại món nước cụ thể
        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập loại món nước thứ " + (i + 1) + ": ");
            int loaiMonNuoc = scanner.nextInt();

            // Kiểm tra xem loại món có tồn tại trong menu không
            if (loaiMonNuoc >= 1 && loaiMonNuoc <= menu.size()) {
                SanPham sanPham = menu.get(loaiMonNuoc - 1);

                // Kiểm tra có uống đá hay không
                System.out.print("Có uống đá không? (1. Có / 2. Không): ");
                int luaChonDa = scanner.nextInt();
                sanPham.setCoDa(luaChonDa == 1);

                // Kiểm tra có chọn size hay không
                if (sanPham.isCoSize()) {
                    System.out.print("Chọn size (1. Nhỏ / 2. Vừa / 3. Lớn): ");
                    int luaChonSize = scanner.nextInt();
                    sanPham.setSize(getSizeFromChoice(luaChonSize));
                }

                // Nhập ghi chú cho món nước
                System.out.print("Nhập ghi chú cho món nước: ");
                scanner.nextLine(); // Đọc bỏ dòng trắng
                String ghiChu = scanner.nextLine();

                // Lưu thông tin vào mảng
                sanPham.setGhiChu(ghiChu);
                monsDaChon[i] = sanPham;
            } else {
                System.out.println("Loại món nước không hợp lệ.");
                return;
            }
        }

        // Hiển thị thông tin về các món đã chọn
        System.out.println("Thông tin về các món đã chọn:");

        for (SanPham sanPham : monsDaChon) {
            System.out.println("Món: " + sanPham.getTenSanPham() + ", Loại: " + sanPham.getLoai() + ", Giá: "
                    + sanPham.getGia() + " VND, Ghi chú: " + sanPham.getGhiChu() + ", Size: " + sanPham.getSize()
                    + ", Đá: " + (sanPham.getCoDa() ? "Có" : "Không"));
        }
    }
    //
    // orderManager.addOrder(new Order(monsDaChon));

    private void themSanPhamVaoMenu() {
        // Thêm các sản phẩm vào menu ở đây
        menu.add(new SanPham("Trà sữa đường đen", "Trà sữa", 15000, true, "Không đường", true, "Nhỏ"));
        menu.add(new SanPham("Trà sữa trân châu", "Trà sữa", 18000, true, "Trân châu trắng", true, "Vừa"));
        menu.add(new SanPham("Cà phê đen", "Cà phê", 12000, true, "Đen không đường", true, "Lớn"));
        menu.add(new SanPham("Sinh tố trái cây", "Sinh tố", 25000, false, null, true, "Nhỏ"));
    }

    private void hienThiMenu() {
        System.out.println("Menu:");

        for (int i = 0; i < menu.size(); i++) {
            SanPham sanPham = menu.get(i);
            System.out.println((i + 1) + ". " + sanPham.getTenSanPham() + " - " + sanPham.getLoai() + " - "
                    + sanPham.getGia() + " VND");
        }
    }

    private static String getSizeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Nhỏ";
            case 2:
                return "Vừa";
            case 3:
                return "Lớn";
            default:
                return "Nhỏ"; // Hoặc giá trị mặc định khác tùy theo yêu cầu của bạn
        }
    }

}
