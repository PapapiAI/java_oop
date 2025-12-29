package ss8_generic_stack_queue.ex_01.c2_array_list;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        // a. push(): thêm
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Ngăn xếp: " + stack.toString()); // In ra: Ngăn xếp: 30 20 10

        // b. peek(): lấy ra xem
        Integer peekValue = stack.peek();
        System.out.println("Giá trị ở đầu ngăn xếp: " + peekValue); // In ra: Giá trị ở đầu ngăn xếp: 30

        // c. pop(): lấy ra xem và xóa
        Integer poppedValue = stack.pop();
        System.out.println("Giá trị lấy ra: " + poppedValue); // In ra: Giá trị lấy ra: 30

        // d. isEmpty(): kiểm tra rỗng
        boolean isEmpty = stack.isEmpty();
        System.out.println("Ngăn xếp có trống không: " + isEmpty); // In ra: Ngăn xếp có trống không: false

        // e. size(): trả về số lượng phần tử
        int stackSize = stack.size();
        System.out.println("Kích thước ngăn xếp: " + stackSize); // In ra: Kích thước ngăn xếp: 2
    }
}