package MainCore;

public class Memu {
    private String name;
    private int Price;

    public Memu(String name, int price) {
        this.name = name;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return Price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

}
