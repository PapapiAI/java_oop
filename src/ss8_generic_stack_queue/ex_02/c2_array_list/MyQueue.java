package ss8_generic_stack_queue.ex_02.c2_array_list;

public class MyQueue<E> {
    private int capacity;
    private Object[] arr;
    private int size;
    private Object[] emptyArray = {};

    public MyQueue() {
        this.arr = emptyArray;
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[this.capacity];
    }

    // a. add(): thêm phần tử vào cuối hàng đợi
    public void add(E element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new Object[this.capacity];
        }

        if (size == capacity) {
            this.capacity *= 1.5;
            if (size == capacity) {
                capacity++;
            }

            Object[] brr = new Object[this.capacity];
            for (int i = 0; i < size; i++) {
                brr[i] = arr[i];
            }
            arr = brr;
        }

        arr[size] = element;
        size++;
    }

    // b. peek(): lấy ra xem phần tử ở đầu hàng đợi (vị trí index 0)
    public E peek() {
        if (size == 0) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }
        return (E) arr[0];
    }

    // c. poll(): lấy ra xem và xóa phần tử ở đầu hàng đợi
    public E poll() {
        if (size == 0) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }

        E element = (E) arr[0];

        // Dịch chuyển các phần tử còn lại sang trái để đè lên phần tử đầu tiên
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Đặt phần tử cuối cùng của mảng thành null để giải phóng bộ nhớ
        arr[size - 1] = null;

        size--;
        return element;
    }

    // d. isEmpty(): kiểm tra hàng đợi rỗng
    public boolean isEmpty() { return size == 0; }

    // e. size(): trả về số lượng phần tử hiện có
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }
        return stringBuilder.toString();
    }
}
