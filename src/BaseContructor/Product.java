// public class Product {
// private int idProduct;
// private String name;
// private String type;
// private float price;

// public Product(int idProduct, String name, String type, float price) {
// this.idProduct = idProduct;
// this.name = name;
// this.type = type;
// this.price = price;

// /*
// 2. Thực đơn của quán bao gồm 4 loại nước uống chính: Trà sữa, cà phê, sinh
// tố và nước trái cây.

// 3. Sản phẩm: Mỗi loại nước uống có nhiều lựa chọn gọi là sản phẩm của quán
// ví dụ Trà sửa có Trà sữa đường đen, trà sữa trân châu, hồng trà, trà đào, Trà
// chanh,...Nước trái cây có nước ép táo, nước ép thơm,...Mỗi sản phẩm có giá
// riêng.
// */}

// public int getIdProduct() {
// return idProduct;
// }

// public void setIdProduct(int idProduct) {
// this.idProduct = idProduct;
// }

// public String getName() {
// return name;
// }

// public void setName(String name) {
// this.name = name;
// }

// public String getType() {
// return type;
// }

// public void setType(String type) {
// this.type = type;
// }

// public float getPrice() {
// return price;
// }

// public void setPrice(float price) {
// this.price = price;
// }
// public boolean canAddIce() {
// // Kiểm tra loại sản phẩm và áp dụng quy tắc uống đá
// if (type.equals("Cà phê")) {
// return true; // Cà phê có thể uống đá hoặc không đá
// } else if (type.equals("Trà sữa")) {
// // Chỉ cung cấp 1 loại là uống với đá cho trà sữa trân châu và trà sữa đường
// đen
// return name.equals("Trà sữa trân châu") || name.equals("Trà sữa đường đen");
// } else {
// return false; // Các loại khác không uống đá
// }
// }

// }