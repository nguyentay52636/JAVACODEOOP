package handleMaganement.ObjTable;

import java.util.Scanner;

public class handleTable {
    public static void displayMenu(TableManager tableManager, Scanner scanner) {
        boolean tableMenuFlag = true;
        do {
            System.out.println("Chức năng quản lý bàn:");
            System.out.println("1. Thêm bàn mới.");
            System.out.println("2. Hiển thị danh sách bàn.");
            System.out.println("3. Tìm kiếm bàn.");
            System.out.println("4. Quay lại menu chính.");
            System.out.print("Mời bạn chọn: ");
            int tableChoice = scanner.nextInt();
 
            switch (tableChoice) {
                case 1:

                    break;
                case 2:
                    tableManager.displayTables();
                    break;
                case 3:
                    searchTable(tableManager, scanner);
                    break;
                case 4:
                    tableMenuFlag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
                    break;
            }
        } while (tableMenuFlag);
    }

    public static void addNewTable(TableManager tableManager, Scanner scanner) {
        System.out.print("Nhập số bàn: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Nhập số chỗ ngồi: ");
        int capacity = scanner.nextInt();

        // Tạo đối tượng Table từ số bàn và số chỗ ngồi
        Table newTable = new Table(tableNumber, capacity, false);

        // Gọi phương thức addTable của TableManager
        tableManager.addTable(newTable);
    }

    public static void searchTable(TableManager tableManager, Scanner scanner) {
        System.out.print("Nhập số bàn cần tìm: ");
        int searchTableNumber = scanner.nextInt();
        Table foundTable = tableManager.findTable(searchTableNumber);
        if (foundTable != null) {
            System.out.println("Bàn được tìm thấy: " + foundTable.toString());
        } else {
            System.out.println("Không tìm thấy bàn có số " + searchTableNumber);
        }
    }
}
