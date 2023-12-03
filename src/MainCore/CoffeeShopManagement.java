package MainCore;

import java.util.Scanner;

import handleMaganement.ObjOrder.QuanNuoc;
import handleMaganement.ObjTable.TableManager;
import handleMaganement.ObjTable.TableMenu;

public class CoffeeShopManagement {
    public void CoffeeMenu() {
        Scanner scanner = new Scanner(System.in);
        TableManager tableManager = new TableManager(10);
        QuanNuoc quannuoc = new QuanNuoc();

        boolean flag = true;
        do {
            System.out.println("Mời bạn chọn trong các menu dưới đây: ");
            System.out.println("1. Quản lý bàn.");
            System.out.println("2. Quản lý thực đơn.");
            System.out.println("3. Quản lý sản phẩm.");
            System.out.println("4. Quản lý khách hàng.");
            System.out.println("5. Quản lý nhân viên.");
            System.out.println("6. Đặt đơn và tính tiền.");
            System.out.println("7. Món thêm.");
            System.out.println("8. Đăng kí thành viên.");
            System.out.println("9. Thống kê và báo cáo.");
            System.out.println("10. Thoát.");
            System.out.print("Mời bạn chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TableMenu.displayTableMenu(tableManager, scanner);

                    break;

                case 2:
                    quannuoc.thucHienChucNang();
                    break;
                case 3:
                    // Code quản lý sản phẩm
                    break;
                case 4:
                    // Code quản lý khách hàng
                    break;
                case 5:
                    // Code quản lý nhân viên
                    break;
                case 6:
                    // Code đặt đơn và tính tiền
                    break;
                case 7:
                    // Code món thêm
                    break;
                case 8:
                    // Code đăng kí thành viên
                    break;
                case 9:
                    // Code thống kê và báo cáo
                    break;
                case 10:
                    System.out.println("Tạm biệt!");
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
                    break;
            }
        } while (flag);
    }
}
