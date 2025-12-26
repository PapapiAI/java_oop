package ss8_generic_stack_queue.ex_01.c2_array_list;

public class MyStack<E> {
    private int capacity;
    private Object[] arr;
    private int size;
    private Object[] emptyArray = {};

    public MyStack() {
        this.arr = emptyArray;
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[this.capacity];
    }

    // a. push(): thêm
    public void push(E element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new Object[this.capacity];
        }

        if (size == capacity) {
            this.capacity *= 1.5;
            if (size == capacity) { // Tránh trường hợp capacity = 0 hoặc 1
                capacity++;
            }

            // Tạo một mảng mới có kích thước là capacity
            Object[] brr = new Object[this.capacity];

            // Copy phần tử
            for (int i = 0; i < size; i++) {
                brr[i] = arr[i];
            }

            // Cho arr tham chiếu đến vùng nhớ mới
            arr = brr;
        }

        arr[size] = element;
        size++;
    }

    // b. peek(): lấy ra xem
    public E peek() {
        if (size == 0) {
            System.out.println("Ngăn xếp rỗng, không thể lấy ra.");
            return null;
        }
        return (E) arr[size - 1];
    }

    // c. pop(): lấy ra xem và xóa
    public E pop() {
        if (size == 0) {
            System.out.println("Ngăn xếp rỗng, không thể lấy ra.");
            return null;
        }

        E element = (E) arr[size - 1];
        arr[size - 1] = null; // Đặt phần tử cuối cùng trong mảng thành null để giảm bộ nhớ.
        size--;

        return element;
    }

    // d. isEmpty(): kiểm tra rỗng
    public boolean isEmpty() {
        return size == 0;
    }

    // e. size(): trả về số lượng phần tử
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }

        return stringBuilder.toString();
    }
}
