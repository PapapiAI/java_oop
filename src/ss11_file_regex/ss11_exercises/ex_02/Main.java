package ss11_file_regex.ss11_exercises.ex_02;

import ss11_file_regex.ss11_exercises.ex_02.utils.ReadFileUtil;
import ss11_file_regex.ss11_exercises.ex_02.utils.WriteFileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_PHONE = "src/ss11_file_regex/ss11_exercises/ex_02/data/phone.csv";

    public static void main(String[] args) {
        int choose;

        while (true) {
            try {
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
                    try {
                        choose = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        choose = -1; // Xử lý nếu nhập chữ
                    }

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

                } while (choose < 1 || choose > 9);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ứng dụng gặp một số lỗi không mong muốn. Vui lòng thử lại!");
            }
        }
    }

    private static void menuShowList() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("DANH SÁCH ĐIỆN THOẠI");
                System.out.println("1. Xem tất cả");
                System.out.println("2. Xem điện thoại cũ");
                System.out.println("3. Xem điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

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
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuAddNew() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("THÊM MỚI ĐIỆN THOẠI");
                System.out.println("1. Thêm mới điện thoại cũ");
                System.out.println("2. Thêm mới điện thoại mới");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

                switch (choose) {
                    case 1:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone(phones));
                        phones.add(oldPhone);
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 2:
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone(phones));
                        phones.add(newPhone);
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
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

    private static double calculateTotalPriceInStore() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        double total = 0.0;
        for (Phone phone : phones) {
            total += phone.calculateTotalPrice();
        }
        return total;
    }

    public static void applyDiscountToOldPhones(double percentDiscount) throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        boolean hasOldPhone = false;
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                ((OldPhone) phone).applyDiscount(percentDiscount);
                hasOldPhone = true;
            }
        }
        if (hasOldPhone) {
            WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
        }
    }

    private static String getIdOldPhone(List<Phone> phones) {
        ArrayList<OldPhone> oldPhones = getOldPhones(phones);
        if (oldPhones.isEmpty()) {
            return "DTC001";
        }
        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3));
        for (int i = 1; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTC%03d", max + 1);
    }

    private static ArrayList<OldPhone> getOldPhones(List<Phone> phones) {
        ArrayList<OldPhone> oldPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof OldPhone) {
                oldPhones.add((OldPhone) phone);
            }
        }
        return oldPhones;
    }

    private static ArrayList<NewPhone> getNewPhones(List<Phone> phones) {
        ArrayList<NewPhone> newPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof NewPhone) {
                newPhones.add((NewPhone) phone);
            }
        }
        return newPhones;
    }

    private static String getIdNewPhone(List<Phone> phones) {
        ArrayList<NewPhone> newPhones = getNewPhones(phones);
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
        return String.format("DTM%03d", max + 1);
    }

    private static void update() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        System.out.print("Nhập vào mã muốn cập nhật: ");
        String id = scanner.nextLine();

        if (id.startsWith("DTC") || id.startsWith("DTM")) {
            boolean isExistPhone = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExistPhone = true;
                    phone.input();
                    WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
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

    private static void delete() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
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
                        WriteFileUtil.writePhonesFile(PATH_FILE_PHONE, phones);
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

    private static void menuSort() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("SẮP XẾP ĐIỆN THOẠI THEO GIÁ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                System.out.println("3. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

                switch (choose) {
                    case 1:
                        Collections.sort(phones);
                        // Cần in ra danh sách sau khi sắp xếp để người dùng thấy
                        for(Phone p : phones) p.output();
                        break;
                    case 2:
                        phones.sort(Collections.reverseOrder());
                        // Cần in ra danh sách sau khi sắp xếp
                        for(Phone p : phones) p.output();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 3);
        }
    }

    private static void menuSearch() throws IOException {
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM ĐIỆN THOẠI");
                System.out.println("1. Tìm kiếm tất cả điện thoại");
                System.out.println("2. Tìm kiếm điện thoại cũ");
                System.out.println("3. Tìm kiếm điện thoại mới");
                System.out.println("4. Trở về menu chính");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

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
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, xin chọn lại!");
                }
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSearchAllPhone() throws IOException {
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
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
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
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
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSearchOldPhone() throws IOException {
        // Fix: Đọc file để có dữ liệu trước
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM THEO ĐIỆN THOẠI CŨ");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu Tìm kiếm");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

                // Fix: Truyền biến phones vào hàm getOldPhones
                ArrayList<OldPhone> oldPhones = getOldPhones(phones);

                switch (choose) {
                    case 1:
                        System.out.println("Nhập vào khoảng giá muốn tìm");
                        System.out.print("Nhập vào giá từ: ");
                        int priceFrom = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập vào giá đến: ");
                        int priceTo = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : oldPhones) {
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
            } while (choose < 1 || choose > 4);
        }
    }

    private static void menuSearchNewPhone() throws IOException {
        // Fix: Đọc file dữ liệu trước
        List<Phone> phones = ReadFileUtil.readPhonesFile(PATH_FILE_PHONE);
        int choose;
        while (true) {
            do {
                System.out.println("TÌM KIẾM THEO ĐIỆN THOẠI MỚI");
                System.out.println("1. Tìm kiếm theo giá");
                System.out.println("2. Tìm kiếm theo tên");
                System.out.println("3. Tìm kiếm theo hãng");
                System.out.println("4. Trở về menu Tìm kiếm");

                System.out.print("Mời bạn lựa chọn: ");
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    choose = -1;
                }

                // Fix: Truyền danh sách phones vào
                ArrayList<NewPhone> newPhones = getNewPhones(phones);

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
            } while (choose < 1 || choose > 4);
        }
    }
}