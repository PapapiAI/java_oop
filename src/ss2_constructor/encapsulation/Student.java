package ss2_constructor.encapsulation;

public class Student {
    private int id;
    private String name;
    private double score;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


/// Tự động tạo getter and setter
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public void setScore(double score) {
//        this.score = score;
//    }


/// Kiểm tra trước dữ liệu cần bảo vệ
//    public void setScore(double score) {
//        if (score < 0 || score > 10) {
//            // Ném ra ngoại lệ => Exception
//            System.out.println("Điểm không hợp lệ!");
//        } else {
//            this.score = score;
//        }
//    }


}
