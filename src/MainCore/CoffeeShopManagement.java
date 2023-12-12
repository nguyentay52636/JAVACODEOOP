package MainCore;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import HandleList.ListEmployee;
import handleMaganement.ObjOrder.QuanNuoc;
import handleMaganement.ObjTable.TableManager;
import handleMaganement.ObjTable.TableMenu;

public class CoffeeShopManagement {
    public void CoffeeMenu() {
        Scanner scanner = new Scanner(System.in);
        TableManager tableManager = new TableManager(10);
        QuanNuoc quannuoc = new QuanNuoc();
        // ListEmployee listEmployee = new ListEmployee();

        boolean flag = true;
        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|        Hệ thống quản lý nhà hàng            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Quản lý bàn                              |");
            System.out.println("| 2. Quản lý thực đơn                         |");
            System.out.println("| 3. Quản lý sản phẩm                         |");
            System.out.println("| 4. Quản lý khách hàng                       |");
            System.out.println("| 5. Quản lý nhân viên                        |");
            System.out.println("| 6. Đặt đơn và tính tiền                     |");
            System.out.println("| 7. Món thêm                                 |");
            System.out.println("| 8. Đăng kí thành viên                       |");
            System.out.println("| 9. Thống kê và báo cáo                      |");
            System.out.println("| 10. Thoát                                   |");
            System.out.println("+---------------------------------------------+");

            System.out.print("Mời bạn chọn trong các menu trên: ");
            System.out.print("Mời bạn chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TableMenu.displayTableMenu(tableManager);

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
                    // quan li nhan vien
                    System.out.println("Ban chon danh sach nhan vien");
                    listEmployee();

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

    public void listEmployee() {
        Matcher matcher;
        String selectTemp;
        int select;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach nhan vien            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them thong tin nhan vien                 |");
            System.out.println("| 2. Sua thong tin nhan vien                  |");
            System.out.println("| 3. Xoa thong tin nhan vien                  |");
            System.out.println("| 4. Tim kiem thong tin nhan vien             |");
            System.out.println("| 5. Xuat thong tin nhan vien                 |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");

            do {
                System.out.print("Nhap lua chon: ");
                selectTemp = sc.nextLine();
                String s = "^[0-9]{1}";
                Pattern pattern = Pattern.compile(s);
                matcher = pattern.matcher(selectTemp);
            } while (!matcher.find());
            select = Integer.parseInt(selectTemp);
            ListEmployee listEmployee = new ListEmployee();
            listEmployee.readListEmployee();

            switch (select) {
                case 1:
                    System.out.println("Ban chon them thong tin nhan vien");
                    listEmployee.add();
                    break;
                case 2:
                    System.out.println("Ban chon sua thong tin nhan vien");
                    listEmployee.edit();
                    break;
                case 3:
                    System.out.println("Ban chon xoa thong tin nhan vien");
                    listEmployee.remove();
                    break;
                case 4:
                    System.out.println("Ban chon tim kiem thong tin nhan vien");
                    listEmployee.find();
                    break;
                case 5:
                    System.out.println("Ban chon xuat thong tin nhan vien");
                    listEmployee.display();
                    break;
                case 0:
                    System.out.println("Tro ve");
                    break;
                default:
                    System.out.println("Lua chon loi! Vui long chon lai");
                    break;
            }

        } while (select != 0);
    }
}
