package Object;

enum Size {
    SMALL, MEDIUM, LARGE;
}
/*1. Bàn: Quán có nhiều bàn được đánh số thứ tự theo cách sắp xếp của quản
lý. Có 3 loại bàn bàn theo số chỗ ngồi: 2, 4 và 8 chỗ. Khách hàng không được
tự ý chuyển chỗ bàn ghế.
 */
public class Table {
    private int tableNumber;
    private String tableSize;
    private boolean occupied;

    public Table(int tableNumber, String tableSize, boolean occupied) {
        this.tableNumber = tableNumber;
        this.tableSize = tableSize;
        this.occupied = occupied;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableSize() {
        return tableSize;
    }

    public void setTableSize(String tableSize) {
        this.tableSize = tableSize;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
