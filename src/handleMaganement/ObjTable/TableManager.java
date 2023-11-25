package handleMaganement.ObjTable;

public class TableManager {
    private Table[] tables;
    private int tableCount;

    public TableManager(int maxTables) {
        this.tables = new Table[maxTables];
        this.tableCount = 0;
    }

    // Thêm một bàn mới
    public void addTable(Table table) {
        if (tableCount < tables.length) {
            tables[tableCount++] = table;
        } else {
            System.out.println("Không thể thêm nhiều hơn, danh sách bàn đã đầy.");
        }
    }

    // Hiển thị thông tin về tất cả các bàn
    public void displayTables() {
        System.out.println("List of Tables:");
        for (int i = 0; i < tableCount; i++) {
            System.out.println(tables[i].toString());
        }
    }

    // Tìm kiếm bàn theo số bàn
    public Table findTable(int tableNumber) {
        for (int i = 0; i < tableCount; i++) {
            if (tables[i].getTableNumber() == tableNumber) {
                return tables[i];
            }
        }
        return null; // Trả về null nếu không tìm thấy bàn
    }


}