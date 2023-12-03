package HandleList;

import java.util.Arrays;

import handleMaganement.ObjOrder.SanPham;

public class ListOrder {
    private SanPham[] products;

    public ListOrder() {
        this.products = new SanPham[0];
    }

    public ListOrder(SanPham[] products) {
        this.products = products;
    }

    public SanPham[] getProducts() {
        return products;
    }

    public SanPham findProductByCode(String productCode) {
        for (SanPham product : products) {
            if (product.getMaSanPham().equals(productCode)) {
                return product;
            }
        }
        return null;
    }

    public void addToOrder(SanPham product, int quantity) {
        if (product != null) {
            if (isProductInOrder(product)) {
                updateQuantity(product, quantity);
            } else {
                addNewProductToOrder(product, quantity);
            }
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    private boolean isProductInOrder(SanPham product) {
        for (SanPham p : products) {
            if (p.getMaSanPham().equals(product.getMaSanPham())) {
                return true;
            }
        }
        return false;
    }

    private void updateQuantity(SanPham product, int quantity) {
        // Thực hiện cập nhật số lượng sản phẩm trong đơn hàng
        // Ví dụ: tăng số lượng sản phẩm theo quantity
        System.out.println("Sản phẩm đã tồn tại trong đơn hàng. Cập nhật số lượng.");
        for (SanPham p : products) {
            if (p.getMaSanPham().equals(product.getMaSanPham())) {
                // Thay đổi số lượng sản phẩm
                p.setGia(p.getGia() + quantity);
                break;
            }
        }
    }

    private void addNewProductToOrder(SanPham product, int quantity) {
        // Thêm sản phẩm mới vào đơn hàng
        // Ví dụ: products = Arrays.copyOf(products, products.length + 1);
        // products[products.length - 1] = product;
        System.out.println("Thêm sản phẩm vào đơn hàng: " + product.getTenSanPham() + ", Số lượng: " + quantity);
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }
}
