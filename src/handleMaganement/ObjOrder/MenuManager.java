// package handleMaganement.ObjOrder;

// import java.util.ArrayList;
// import java.util.Scanner;

// public class MenuManager {
//     private ArrayList<SanPham> menu;
//     Scanner scanner = new Scanner(System.in);

//     public MenuManager() {
//         this.menu = new ArrayList<>();
//         // Khởi tạo menu và thêm các sản phẩm vào đây
//         themSanPhamVaoMenu();
//     }

//     public ArrayList<SanPham> getMenu() {
//         return menu;
//     }

//     public void themSanPhamVaoMenu() {
//         ArrayList<String> monThemTraSuaDen = new ArrayList<>();
//         ArrayList<Integer> giaMonThemTraSuaDen = new ArrayList<>();
//         monThemTraSuaDen.add("Kem");
//         giaMonThemTraSuaDen.add(2000);
//         monThemTraSuaDen.add("Trân châu");
//         giaMonThemTraSuaDen.add(3000);

//         ArrayList<String> monThemTraSuaTranChau = new ArrayList<>();
//         ArrayList<Integer> giaMonThemTraSuaTranChau = new ArrayList<>();
//         monThemTraSuaTranChau.add("Kem");
//         giaMonThemTraSuaTranChau.add(2000);

//         menu.add(new SanPham("1", "Trà sữa đường đen", "Trà sữa", 15000, true, "Không đường", true, "Nhỏ", "Ghi chú",
//                 null));
//         menu.add(new SanPham("2", "Trà sữa trân châu", "Trà sữa", 18000, true, "Trân châu trắng", true, "Vừa",
//                 "Ghi chú", null));
//         menu.add(
//                 new SanPham("3", "Cà phê đen", "Cà phê", 12000, true, "Đen không đường", true, "Lớn", "Ghi chú", null));
//         menu.add(new SanPham("4", "Sinh tố trái cây", "Sinh tố", 25000, false, null, true, "Nhỏ", "Ghi chú", null));
//     }

//     public boolean askForDineIn() {
//         System.out.print("Bạn muốn dùng tại quán (1) hay mang đi (2)? ");
//         int choice = scanner.nextInt();
//         return choice == 1;
//     }
// }
package handleMaganement.ObjOrder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
    private ArrayList<SanPham> menu;
    Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        this.menu = new ArrayList<>();
        // Khởi tạo menu và thêm các sản phẩm vào đây
        docTuTapTin("/Users/m1lt43/Desktop/DOAN2/Data/SanPham.txt");
    }

    public ArrayList<SanPham> getMenu() {
        return menu;
    }

    public void docTuTapTin(String tenTapTin) {
        File file = new File(tenTapTin);
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.replaceAll("\"", "").split(", ");

                if (parts.length == 7 || parts.length == 8) {
                    SanPham sanPham = new SanPham();
                    sanPham.setTenSanPham(parts[0]);
                    sanPham.setLoai(parts[1]);
                    sanPham.setGia(Integer.parseInt(parts[2]));
                    sanPham.setCoDa(Boolean.parseBoolean(parts[3]));
                    sanPham.setMoTaDa(parts[4]);
                    sanPham.setCoSize(Boolean.parseBoolean(parts[5]));
                    sanPham.setSize(parts[6]);

                    if (parts.length == 8) {
                        sanPham.setGhiChu(parts[7]);
                    }

                    menu.add(sanPham);
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Các phương thức khác ở đây
}
