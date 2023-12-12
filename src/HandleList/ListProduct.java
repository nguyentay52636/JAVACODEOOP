package HandleList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import handleMaganement.ObjOrder.SanPham;

public class ListProduct {
	private ArrayList<SanPham> sanpham = new ArrayList<SanPham>();

	public ListProduct() {
		initializeProducts();
	}

	private void initializeProducts() {
		// Thực hiện đọc dữ liệu từ tệp và nạp vào danh sách sản phẩm
		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/huy/Documents/Java/projectOOP/src/data/SanPham.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Xử lý dữ liệu từng dòng và tạo đối tượng SanPham
				// sau đó thêm vào danh sách sanpham
				String[] productData = line.split(","); // Giả sử dữ liệu trong tệp được phân tách bằng dấu phẩy
				// Make sure the attributes array has at least 9 elements
				if (productData.length >= 9) {
					String maSanPham = productData[0].trim();
					String tenSanPham = productData[1].trim();
					String loai = productData[2].trim();
					int gia = Integer.parseInt(productData[3].trim());
					boolean coDa = Boolean.parseBoolean(productData[4].trim());
					String moTaDa = productData[5].trim();
					boolean coSize = Boolean.parseBoolean(productData[6].trim());
					String size = productData[7].trim();
					String ghiChu = productData[8].trim();

					SanPham sanPhamData = new SanPham();
					sanPhamData.setMaSanPham(maSanPham);
					sanPhamData.setTenSanPham(tenSanPham);
					sanPhamData.setLoai(loai);
					sanPhamData.setGia(gia);
					sanPhamData.setCoDa(coDa);
					sanPhamData.setMoTaDa(moTaDa);
					sanPhamData.setCoSize(coSize);
					sanPhamData.setSize(size);
					sanPhamData.setGhiChu(ghiChu);
					sanpham.add(sanPhamData);
				} else {
					// Handle the case where the attributes array does not have enough elements
					System.out.println("Invalid data format: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SanPham> getProductList() {
		return sanpham;
	}

//     tạo sản phẩm
	// Thêm sản phẩm vào danh sách và ghi vào tệp
	public void addProduct(SanPham sanPham) {
		sanpham.add(sanPham);
		writeToFile(sanPham); // Ghi thông tin sản phẩm vào tệp
	}

	// Ghi dữ liệu sản phẩm vào tệp
	private void writeToFile(SanPham sanPham) {
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("/home/huy/Documents/Java/projectOOP/src/data/SanPham.txt", true))) {
			// Ghi thông tin sản phẩm vào tệp
			bw.write(sanPham.getMaSanPham() + ",");
			bw.write(sanPham.getTenSanPham() + ",");
			bw.write(sanPham.getLoai() + ",");
			bw.write(sanPham.getGia() + ",");
			bw.write(sanPham.isCoDa() + ",");
			bw.write(sanPham.getMoTaDa() + ",");
			bw.write(sanPham.isCoSize() + ",");
			bw.write(sanPham.getSize() + ",");
			bw.write(sanPham.getGhiChu());
			bw.newLine(); // Xuống dòng cho sản phẩm tiếp theo
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//     xóa sản phẩm
	public void removeProduct(String maSanPham) {
		// Tìm sản phẩm theo mã
		SanPham productToRemove = null;
		for (SanPham sanPham : sanpham) {
			if (sanPham.getMaSanPham().equals(maSanPham)) {
				productToRemove = sanPham;
				break;
			}
		}

		// Nếu tìm thấy sản phẩm, xóa khỏi danh sách và cập nhật tệp
		if (productToRemove != null) {
			sanpham.remove(productToRemove);
			updateFile();
		} else {
			System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
		}
	}

	// Cập nhật tệp sau khi xóa sản phẩm
	private void updateFile() {
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("/home/huy/Documents/Java/projectOOP/src/data/SanPham.txt"))) {
			for (SanPham sanPham : sanpham) {
				// Ghi thông tin sản phẩm vào tệp
				bw.write(sanPham.getMaSanPham() + ",");
				bw.write(sanPham.getTenSanPham() + ",");
				bw.write(sanPham.getLoai() + ",");
				bw.write(sanPham.getGia() + ",");
				bw.write(sanPham.isCoDa() + ",");
				bw.write(sanPham.getMoTaDa() + ",");
				bw.write(sanPham.isCoSize() + ",");
				bw.write(sanPham.getSize() + ",");
				bw.write(sanPham.getGhiChu());
				bw.newLine(); // Xuống dòng cho sản phẩm tiếp theo
			}
			System.out.println("Sản phẩm đã được xóa và tệp đã được cập nhật.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//     lấy data sản phẩm / mã sản phảm
	public SanPham findProductById(String maSanPham) {
		for (SanPham sanPham : sanpham) {
			if (sanPham.getMaSanPham().equals(maSanPham)) {
				return sanPham;
			}
		}
		System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
		return null;
	}

//	cập nhật sản phẩm
	public void updateProduct(String maSanPham) {
		// Tìm sản phẩm theo mã
		SanPham productToUpdate = null;
		for (SanPham sanPham : sanpham) {
			if (sanPham.getMaSanPham().equals(maSanPham)) {
				productToUpdate = sanPham;
				break;
			}
		}

		// Nếu tìm thấy sản phẩm, hiển thị thông tin và cập nhật
		if (productToUpdate != null) {
			System.out.println("Thông tin sản phẩm cần sửa:");
			System.out.println(productToUpdate);

			// Nhập thông tin mới từ người dùng
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập tên sản phẩm mới: ");
			String tenSanPham = scanner.nextLine();
			System.out.print("Nhập loại sản phẩm mới: ");
			String loai = scanner.nextLine();
			System.out.print("Nhập giá sản phẩm mới: ");
			int gia = scanner.nextInt();
			scanner.nextLine(); // Đọc dòng trống
			System.out.print("Có đá hay không (true/false): ");
			boolean coDa = scanner.nextBoolean();
			scanner.nextLine(); // Đọc dòng trống
			System.out.print("Mô tả đá mới: ");
			String moTaDa = scanner.nextLine();
			System.out.print("Có size hay không (true/false): ");
			boolean coSize = scanner.nextBoolean();
			scanner.nextLine(); // Đọc dòng trống
			System.out.print("Nhập size mới: ");
			String size = scanner.nextLine();
			System.out.print("Ghi chú mới: ");
			String ghiChu = scanner.nextLine();

			// Cập nhật thông tin sản phẩm
			productToUpdate.setTenSanPham(tenSanPham);
			productToUpdate.setLoai(loai);
			productToUpdate.setGia(gia);
			productToUpdate.setCoDa(coDa);
			productToUpdate.setMoTaDa(moTaDa);
			productToUpdate.setCoSize(coSize);
			productToUpdate.setSize(size);
			productToUpdate.setGhiChu(ghiChu);

			// Ghi lại toàn bộ danh sách vào tệp
			updateFile();

			System.out.println("Sản phẩm đã được cập nhật và tệp đã được cập nhật.");
		} else {
			System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("+----------------------------------------------+");
			System.out.println("|            Quản lý sản phẩm                  |");
			System.out.println("| -------------------=====---------------------|");
			System.out.println("| 1. Hiển thị danh sách sản phẩm               |");
			System.out.println("| 2. Thêm sản phẩm                             |");
			System.out.println("| 3. Sửa thông tin sản phẩm                    |");
			System.out.println("| 4. Xóa sản phẩm                              |");
			System.out.println("| 5. Tìm kiếm sản phẩm                         |");
			System.out.println("| 0. Quay lại                                  |");
			System.out.println("+----------------------------------------------+");

			System.out.print("Mời bạn chọn: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				ListProduct listProduct = new ListProduct();
				ArrayList<SanPham> productList = listProduct.getProductList();

				// In ra danh sách sản phẩm để kiểm tra
				for (SanPham sanPham : productList) {
					System.out.println(sanPham);
				}
				break;
			case 2:
				// Thêm sản phẩm
				ListProduct listProduct1 = new ListProduct();

				// Nhập thông tin mới từ người dùng
				System.out.print("Nhập mã sản phẩm mới: ");
				String maSanPham = scanner.nextLine();
				System.out.print("Nhập tên sản phẩm mới: ");
				String tenSanPham = scanner.nextLine();
				System.out.print("Nhập loại sản phẩm mới: ");
				String loai = scanner.nextLine();
				System.out.print("Nhập giá sản phẩm mới: ");
				int gia = scanner.nextInt();
				scanner.nextLine(); // Đọc dòng trống
				System.out.print("Có đá hay không (true/false): ");
				boolean coDa = scanner.nextBoolean();
				scanner.nextLine(); // Đọc dòng trống
				System.out.print("Mô tả đá mới: ");
				String moTaDa = scanner.nextLine();
				System.out.print("Có size hay không (true/false): ");
				boolean coSize = scanner.nextBoolean();
				scanner.nextLine(); // Đọc dòng trống
				System.out.print("Nhập size mới: ");
				String size = scanner.nextLine();
				System.out.print("Ghi chú mới: ");
				String ghiChu = scanner.nextLine();

				// Tạo một đối tượng SanPham mới
				SanPham newProduct = new SanPham();
				newProduct.setMaSanPham(maSanPham);
				newProduct.setTenSanPham(tenSanPham);
				newProduct.setLoai(loai);
				newProduct.setGia(gia);
				newProduct.setCoDa(coDa);
				newProduct.setMoTaDa(moTaDa);
				newProduct.setCoSize(coSize);
				newProduct.setSize(size);
				newProduct.setGhiChu(ghiChu);

				// Thêm sản phẩm mới và ghi vào tệp
				listProduct1.addProduct(newProduct);
				break;
			case 3:
				// Sửa thông tin sản phẩm
				System.out.println("Nhập mã sản phẩm bạn muốn sửa:");
				String maSanPhamToEdit = scanner.nextLine();
				ListProduct listProduct2 = new ListProduct();
				listProduct2.updateProduct(maSanPhamToEdit);
				break;
			case 4:
				// Xóa sản phẩm
				System.out.println("nhập mã sản phảm bạn muốn xóa");
				String maSanPham1 = scanner.nextLine();
				ListProduct listProduct3 = new ListProduct();
				listProduct3.removeProduct(maSanPham1);
				break;
			case 5:
				// Tìm kiếm sản phẩm
				System.out.println("nhập mã sản phảm bạn muốn tìm kiếm");
				String maSanPham2 = scanner.nextLine();
				ListProduct listProduct4 = new ListProduct();
				SanPham foundProduct = listProduct4.findProductById(maSanPham2);
				if (foundProduct != null) {
					System.out.println("Thông tin sản phẩm: " + foundProduct);
				}
				break;
			case 0:
				// Quay lại
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
				break;
			}
		} while (choice != 0);
	}

}
