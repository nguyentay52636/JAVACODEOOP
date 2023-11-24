public class SanPham {
    private String tenSanPham;
    private String loai;
    private int gia;
    private boolean coDa;
    private String moTaDa;
    private boolean coSize;
    private String size;
    private String ghiChu;

    public SanPham(String tenSanPham, String loai, int gia, boolean coDa, String moTaDa, boolean coSize, String size) {
        this.tenSanPham = tenSanPham;
        this.loai = loai;
        this.gia = gia;
        this.coDa = coDa;
        this.moTaDa = moTaDa;
        this.coSize = coSize;
        this.size = size;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getLoai() {
        return loai;
    }

    public int getGia() {
        return gia;
    }

    public boolean getCoDa() {
        return coDa;
    }

    public void setCoDa(boolean coDa) {
        this.coDa = coDa;
    }

    public String getMoTaDa() {
        return moTaDa;
    }

    public boolean isCoSize() {
        return coSize;
    }

    public void setCoSize(boolean coSize) {
        this.coSize = coSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
