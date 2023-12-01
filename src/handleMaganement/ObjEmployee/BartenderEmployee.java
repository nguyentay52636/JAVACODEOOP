package handleMaganement.ObjEmployee;

import handleMaganement.ObjOrder.Order;

/*Bước 3: Pha chế, các đơn đặt sẽ được thực hiện theo thứ tự thời điểm đặt.
Nhân viên pha chế sẽ biết được đơn đặt hiện tại là gì và người quản lý sẽ biết
được danh sách các đơn hàng đã được giải quyết và các đơn đặt đang chờ.
 */
public class BartenderEmployee extends Employee {
    private Order orderCurrent;

    public BartenderEmployee(String name, String telephoneNumber, int age, String address, String gender,
            String idEmployee,
            int daysOff, int dayOfWork, Order orderCurrent) {
        super(name, telephoneNumber, age, address, gender, idEmployee, daysOff, dayOfWork);
        this.orderCurrent = orderCurrent;
    }

    public Order getOrderCurrent() {
        return orderCurrent;
    }

    public void setOrderCurrent(Order orderCurrent) {
        this.orderCurrent = orderCurrent;
    }

    // qua trinh xu li don hang
    public void startProcessOrder(Order order) {
        if (orderCurrent == null) {
            System.out.println("Bắt đầu xử lý đơn hàng " + order.getOrderId());
            orderCurrent = order;
        } else {
            System.out.println("Đã có đơn hàng đang được xử lý. Không thể thực hiện thêm đơn hàng mới.");
        }
    }

    public void completeOrder() {
        if (orderCurrent != null) {
            System.out.println("Đã hoàn thành xử lý đơn hàng " + orderCurrent.getOrderId());
            // Sử dụng 'this' để tham chiếu đến đối tượng BartenderEmployee hiện tại
            this.notifyOrderCompletion(orderCurrent);
            orderCurrent = null;
        } else {
            System.out.println("Không có đơn hàng đang được xử lý.");
        }
    }

    public boolean isProcessingOrder() {
        return orderCurrent != null;
    }

    public void notifyOrderCompletion(Order order) {
        System.out.println("Thông báo cho quản lý: Đơn hàng " + order.getOrderId() + " đã hoàn thành.");

    }
    // isProcessingOrder kiem tra don hang co duoc xu li hay k
}