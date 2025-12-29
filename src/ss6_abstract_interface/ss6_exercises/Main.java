package ss6_abstract_interface.ss6_exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Phone> phones = new ArrayList<>();

    static {
        // Thêm điện thoại cũ
        phones.add(new OldPhone(
                "DTC001",
                "Iphone 15 Promax",
                20000000.0,
                6,
                "Apple",
                95,
                "Đã qua sử dụng, tình trạng tốt"
        ));

        // Thêm điện thoại cũ
        phones.add(new OldPhone(
                "DTC002",
                "Iphone 12 Promax",
                9000000.0,
                6,
                "Apple",
                75,
                "Đã qua sử dụng, màn hình nứt nhẹ"
        ));

        // Thêm điện thoại mới
        phones.add(new NewPhone(
                "DTM001",
                "Samsung Galaxy S22",
                11990000.0,
                12,
                "Samsung",
                15
        ));

        // Thêm điện thoại mới
        phones.add(new NewPhone(
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
                    case 7:
                        System.out.println("Tổng giá của tất cả các điện thoại: "
                                + calculateTotalPriceInStore());
                        break;

                    case 8:
                        System.out.print("Nhập vào phần trăm muốn giảm giá: ");
                        double percentDiscount = Double.parseDouble(scanner.nextLine());
                        applyDiscountToOldPhones(percentDiscount);
                        System.out.println("Đã giảm giá thành công");
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
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Thông tin điện thoại thứ " + (i + 1));
                            phones.get(i).output();
                        }
                        break;

                    case 2:
                        System.out.println("==== Danh sách điện thoại cũ ====");
                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof OldPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("==== Danh sách điện thoại mới ====");
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof NewPhone) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
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
                        phones.add(oldPhone);
                        System.out.println("Thêm mới thành công");
                        break;

                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        phones.add(newPhone);
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

    // Tỉnh tổng giá của tất cả các điện thoại trong cửa hàng
    private static double calculateTotalPriceInStore() {
        double total = 0.0;
        for (Phone phone : phones) {
            total += phone.calculateTotalPrice();
        }
        return total;
    }

    public static void applyDiscountToOldPhones(double percentDiscount) {
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).applyDiscount(percentDiscount);
            }
        }
    }

    private static String getIdOldPhone() {
        // max id => id + 1
        ArrayList<OldPhone> oldPhones = getOldPhones();

        if (oldPhones.isEmpty()) {
            return "DTC001";
        }

        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3)); // 1

        for (int i = 1; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }

        // 1 => DTC002
        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    // Lọc ra điện thoại cũ
    private static ArrayList<OldPhone> getOldPhones() {
        ArrayList<OldPhone> oldPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                oldPhones.add((OldPhone) phone);
            }
        }

        return oldPhones;
    }

    private static ArrayList<NewPhone> getNewPhones() {
        ArrayList<NewPhone> newPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof NewPhone) {
                newPhones.add((NewPhone) phone);
            }
        }

        return newPhones;
    }

    private static String getIdNewPhone() {
        ArrayList<NewPhone> newPhones = getNewPhones();

        // max id => id + 1
        if (newPhones.isEmpty()) {
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

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    phone.input();
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

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    System.out.printf("Bạn có xóa điện thoại có mã %s không?\n", id);
                    System.out.println("Chọn Yes để xác nhận xóa, No để hủy");
                    if ("yes".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
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
                    case 1: // Sắp xếp giá tăng dần
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = i + 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() > phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
                        break;

                    case 2: // Sắp xếp giá giảm dần
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = i + 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() < phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
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
                        System.out.println("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }

            } while (choose < 0 || choose > 4);
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

                ArrayList<OldPhone> oldPhones = getOldPhones();

                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getPrice() >= priceFrom
                                    && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
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

                // Lấy ra danh sách điện thoại mới từ danh sách điện thoại
                ArrayList<NewPhone> newPhones = getNewPhones();

                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceTo) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Nhập vào tên cần tìm: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Nhập vào hãng điện thoại cần tìm: ");
                        String manufacturer = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getManufacturer().contains(manufacturer)) {
                                System.out.println("Thông tin điện thoại thứ " + count++);
                                phone.output();
                            }
                        }
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
