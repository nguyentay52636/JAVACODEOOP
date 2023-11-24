public class Drink extends Product {
    private boolean ice;
    private int[] size;
    private int quantity;

    public Drink(int idProduct, String name, String type, float price, boolean ice, int[] size) {
        super(idProduct, name, type, price);
        this.ice = ice;
        this.size = size;
        this.quantity = quantity;
    }

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public int[] getSize() {
        return size;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

}
