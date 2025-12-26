package ss8_generic_stack_queue.ex_02.c2_array_list;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        // a. Thêm phần tử vào hàng đợi
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Hàng đợi: " + queue.toString()); // In ra: 30 20 10

        // b. Lấy ra phần tử đầu tiên mà không xóa nó
        Integer peekValue = queue.peek();
        System.out.println("Giá trị ở đầu hàng đợi: " + peekValue); // In ra: 10

        // c. Lấy ra và xóa phần tử đầu tiên (vị trí tail)
        Integer polledValue = queue.poll();
        System.out.println("Giá trị lấy ra: " + polledValue); // In ra: 10

        // d. Kiểm tra xem hàng đợi có trống không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Hàng đợi có trống không: " + isEmpty); // In ra: false

        // e. Lấy kích thước của hàng đợi
        int queueSize = queue.size();
        System.out.println("Kích thước hàng đợi: " + queueSize); // In ra: 2
    }
}
