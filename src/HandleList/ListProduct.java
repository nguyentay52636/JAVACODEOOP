// import java.util.Arrays;

// public class ListProduct {
// private Product[] productList;
// private int size;

// public ListProduct(int capacity) {
// this.productList = new Product[capacity];
// this.size = 0;
// initializeProducts();
// }

// private void initializeProducts() {
// addProduct(new Product(1, "Trà sữa", "Trà sữa đường đen", 15000, true, new
// String[]{"Nhỏ", "Vừa", "Lớn"}));
// addProduct(new Product(2, "Trà sữa", "Trà sữa trân châu", 18000, true, new
// String[]{"Nhỏ", "Vừa", "Lớn"}));
// addProduct(new Product(3, "Cà phê", "Cà phê sữa đá", 12000, true, new
// String[]{"Nhỏ", "Vừa", "Lớn"}));
// addProduct(new Product(4, "Nước trái cây", "Nước ép táo", 10000, false, new
// String[]{"Nhỏ", "Vừa", "Lớn"}));
// // Thêm các sản phẩm khác tương tự
// }

// public Product[] getProductList() {
// return Arrays.copyOf(productList, size);
// }

// public void addProduct(Product product) {
// if (size < productList.length) {
// productList[size++] = product;
// } else {
// System.out.println("Danh sách sản phẩm đã đầy, không thể thêm mới.");
// }
// }

// public void removeProduct(int productId) {
// // Xử lý logic xóa sản phẩm theo id
// // ...
// }

// public Product getProductById(int productId) {
// // Xử lý logic lấy sản phẩm theo id
// // ...
// return null;
// }
// }