package handleMaganement.ObjOrder;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner;

    public OrderManager() {
        this.scanner = new Scanner(System.in);
    }

    public boolean askForDineIn() {
        System.out.print("Bạn muốn dùng tại quán (1) hay mang đi (2)? ");
        int choice = scanner.nextInt();
        return choice == 1;
    }

}
