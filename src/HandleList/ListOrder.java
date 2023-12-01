package HandleList;

import handleMaganement.ObjOrder.SanPham;

public class ListOrder extends SanPham {
    private SanPham[] products;

    public ListOrder() {
        super("", "", "", 0, false, "", false, "", "");
        this.products = new SanPham[0];
    }

    public ListOrder(String maSanPham, String tenSanPham, String loai, int gia, boolean coDa, String moTaDa,
            boolean coSize, String size, String ghiChu, SanPham[] products) {
        super(maSanPham, tenSanPham, loai, gia, coDa, moTaDa, coSize, size, ghiChu);
        this.products = products;
    }

    public SanPham[] getProducts() {
        return products;
    }

    public void setProducts(SanPham[] products) {
        this.products = products;
    }

    public SanPham findProductByCode(String productCode) {
        for (SanPham product : products) {
            if (product.getMaSanPham().equals(productCode)) {
                return product;
            }
        }
        return null;
    }

    public void addToOrder(String productCode, int quantity) {
        SanPham product = findProductByCode(productCode);

        if (product != null) {
            // Thêm logic xử lý khi sản phẩm tồn tại
            // Ví dụ: thêm vào đơn hàng, hiển thị thông tin, v.v.
            System.out.println("Thêm sản phẩm vào đơn hàng: " + product.getTenSanPham() + ", Số lượng: " + quantity);
        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }
}