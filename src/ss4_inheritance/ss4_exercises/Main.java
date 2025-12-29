package ss4_inheritance.ss4_exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static ArrayList<NewPhone> newPhones = new ArrayList<>();

    static {
        // Thêm điện thoại cũ
        oldPhones.add(new OldPhone(
                "DTC001",
                "Iphone 15 Promax",
                20000000.0,
                6,
                "Apple",
                95,
                "Đã qua sử dụng, tình trạng tốt"
        ));

        // Thêm điện thoại cũ
        oldPhones.add(new OldPhone(
                "DTC002",
                "Iphone 12 Promax",
                9000000.0,
                6,
                "Apple",
                75,
                "Đã qua sử dụng, màn hình nứt nhẹ"
        ));

        // Thêm điện thoại mới
        newPhones.add(new NewPhone(
                "DTM001",
                "Samsung Galaxy S22",
                11990000.0,
                12,
                "Samsung",
                15
        ));

        // Thêm điện thoại mới
        newPhones.add(new NewPhone(
                "DTM002",
                "Samsung Galaxy A54",
                10000000.0,
                12,
                "Samsung",
                10
        ));
    }

    public static void main(String[] args) {
        int choose;

        while (true) {
            do {
                System.out.println("-- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI --");
                System.out.println("1. Xem danh sách điện thoại");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp theo giá");
                System.out.println("6. Tìm kiếm");
                System.out.println("7. Tính tổng tiền");
                System.out.println("8. Giảm giá cho điện thoại cũ");
                System.out.println("9. Thoát");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        menuShowList();
                        break;
                    case 2:
                        menuAddNew();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        menuSort();
                        break;
                    case 6:
                        menuSearch();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại");
                }

            } while (choose < 1 || choose > 5);
        }
    }

    private static void menuShowList() {
        int choose;
        while (true) {
            do {
                System.out.println("DANH SÁCH ĐIỆN THOẠI");
                System.out.println("1. Xem tất cả");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                // Giả định scanner đã được khai báo ở phạm vi lớp (static)
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        System.out.println("==== Danh sách tất cả điện thoại ====");
                        // Hiển thị danh sách điện thoại cũ
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            oldPhones.get(i).output();
                        }

                        // Hiển thị danh sách điện thoại mới
                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " +
                                    (i + 1 + oldPhones.size()));
                            newPhones.get(i).output();
                        }
                        break;

                    case 2:
                        System.out.println("==== Danh sách điện thoại cũ ====");
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            oldPhones.get(i).output();
                        }
                        break;

                    case 3:
                        System.out.println("==== Danh sách điện thoại mới ====");
                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            newPhones.get(i).output();
                        }
                        break;

                    case 4:
                        return; // Thoát khỏi phương thức, quay lại menu chính

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                        break;
                }
            } while (choose < 0 || choose > 4);
        }
    }

    private static void menuAddNew() {
        int choose;
        while (true) {
            do {
                System.out.println("THÊM MỚI ĐIỆN THOẠI");
                System.out.println("1. Thêm mới điện thoại cũ");
                System.out.println("2. Thêm mới điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone());
                        oldPhones.add(oldPhone);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        newPhones.add(newPhone);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static String getIdOldPhone() {
        // max id => id + 1
        if (oldPhones.size() == 0) {
            return "DTC001";
        }

        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3));

        for (int i = 1; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    private static String getIdNewPhone() {
        // max id => id + 1
        if (newPhones.size() == 0) {
            return "DTM001";
        }

        int max = Integer.parseInt(newPhones.get(0).getId().substring(3));

        for (int i = 1; i < newPhones.size(); i++) {
            int id = Integer.parseInt(newPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        return String.format("DTM%3d", max + 1).replace(" ", "0");
    }

    private static void update() {
        System.out.print("Nhập vào mã muốn cập nhật: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            boolean isExistPhone = false;
            for (OldPhone oldPhone : oldPhones) {
                if (oldPhone.getId().equals(id)) {
                    isExistPhone = true;
                    oldPhone.input();
                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn cập nhật!");
            }

        } else if (id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (NewPhone newPhone : newPhones) {
                if (newPhone.getId().equals(id)) {
                    isExistPhone = true;
                    newPhone.input();
                    System.out.println("Cập nhật thành công!");
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn cập nhật!");
            }

        } else {
            System.out.println("Mã không hợp lệ!");
        }
    }

    private static void delete() {
        System.out.print("Nhập vào mã muốn xóa: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            boolean isExistPhone = false;
            for (OldPhone oldPhone : oldPhones) {
                if (oldPhone.getId().equals(id)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", id);
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");

                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        oldPhones.remove(oldPhone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn xóa!");
            }

        } else if (id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (NewPhone newPhone : newPhones) {
                if (newPhone.getId().equals(id)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", id);
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");

                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        newPhones.remove(newPhone);
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Đã hủy việc xóa!");
                    }
                    break;
                }
            }

            if (!isExistPhone) {
                System.out.println("Không tìm thấy mã muốn xóa!");
            }

        } else {
            System.out.println("Mã không hợp lệ!");
        }
    }

    private static void menuSort() {
        int choose;
        while (true) {
            do {
                System.out.println("SẮP XẾP ĐIỆN THOẠI THEO GIÁ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 2:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }

            } while (choose < 0 || choose > 3);
        }
    }

    private static void menuSearch() {
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM ĐIỆN THOẠI");
                System.out.println("1. Tìm kiếm tất cả điện thoại");
                System.out.println("2. Tìm kiếm điện thoại cũ");
                System.out.println("3. Tìm kiếm điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                // Chuyển đổi từ String sang Integer để tránh lỗi trôi dòng của Scanner
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        menuSearchAllPhone();
                        break;
                    case 2:
                        menuSearchOldPhone();
                        break;
                    case 3:
                        menuSearchNewPhone();
                        break;
                    case 4:
                        return; // Thoát khỏi phương thức và quay lại menu chính
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSearchAllPhone() {
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM THEO TẤT CẢ ĐIỆN THOẠI");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu Tìm kiếm");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    // Sử dụng Integer.parseInt(scanner.nextLine()) để tránh trôi lệnh
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    // Gán giá trị mặc định nếu người dùng nhập không phải là số
                    choose = -1;
                }

                switch (choose) {
                    case 1:
                        // TODO: Thực hiện ở bài sau
                        System.out.println("Chức năng Tìm kiếm theo giá đang phát triển...");
                        break;
                    case 2:
                        // TODO: Thực hiện ở bài sau
                        System.out.println("Chức năng Tìm kiếm theo tên đang phát triển...");
                        break;
                    case 3:
                        // TODO: Thực hiện ở bài sau
                        System.out.println("Chức năng Tìm kiếm theo hãng đang phát triển...");
                        break;
                    case 4:
                        // Thoát khỏi hàm và trở về menu trước đó
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                        break;
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSearchOldPhone() {
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM THEO ĐIỆN THOẠI CŨ");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu Tìm kiếm");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 2:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 3:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 0 || choose > 4);
        }
    }

    private static void menuSearchNewPhone() {
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM THEO ĐIỆN THOẠI MỚI");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu Tìm kiếm");

                System.out.print("Mời bạn lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 2:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 3:
                        // TODO: Thực hiện ở bài sau
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }

            } while (choose < 0 || choose > 4);
        }
    }
}
