package MainCore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private int price;
    private String size;
    private boolean ice;
    private String type;

    public Menu(String name, int price, String size, boolean ice, String type) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.ice = ice;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Hàm đọc dữ liệu từ file và trả về danh sách đối tượng Menu
    public static List<Menu> getMenuData() {
        String filePath = "/home/huy/Documents/vsc/java/JAVACODEOOP/src/data/menu_data.txt";

        List<Menu> menuList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // Xử lý dữ liệu từng dòng ở đây
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());
                    String size = parts[2].trim();
                    boolean ice = Boolean.parseBoolean(parts[3].trim());
                    String type = parts[4].trim();

                    // Tạo đối tượng Menu và thêm vào danh sách
                    Menu menu = new Menu(name, price, size, ice, type);
                    menuList.add(menu);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuList;
    }

    public static void main(String[] args) {
        List<Menu> menuData = getMenuData();
        for (Menu menu : menuData) {
            System.out.println("Name: " + menu.getName() + ", Price: " + menu.getPrice() + ", Size: " + menu.getSize()
                    + ", Ice: " + menu.isIce() + ", Type: " + menu.getType());
        }
    }
}
