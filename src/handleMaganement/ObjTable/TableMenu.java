package handleMaganement.ObjTable;

import java.util.Scanner;

public class TableMenu {
    public static void displayTableMenu(TableManager tableManager, Scanner scanner) {
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
                    handleTable.addNewTable(tableManager, scanner);
                    break;
                case 2:
                    tableManager.displayTables();
                    break;
                case 3:
                    handleTable.searchTable(tableManager, scanner);
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
}
