package Object;

enum Size {
    SMALL, MEDIUM, LARGE;
}

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
