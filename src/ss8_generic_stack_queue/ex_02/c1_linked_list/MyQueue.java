package ss8_generic_stack_queue.ex_02.c1_linked_list;

public class MyQueue<E> {
    private class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // a. add(): thêm vào đầu hàng đợi
    public void add(E value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // b. peek(): lấy ra xem phần tử cuối (tail)
    public E peek() {
        if (tail == null) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }
        return tail.value;
    }

    // c. poll(): lấy ra xem và xóa phần tử ở cuối (tail)
    public E poll() {
        if (head == null) {
            System.out.println("Hàng đợi rỗng, không thể lấy ra.");
            return null;
        }

        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            // Duyệt để tìm phần tử kế cuối
            for (int i = 2; i < size; i++) {
                temp = temp.next;
            }

            tail = temp; // Cập nhật tail là phần tử kế cuối
            temp = temp.next; // temp giữ giá trị tail cũ để trả về
            tail.next = null;
        }

        size--;
        return temp.value;
    }

    // d. isEmpty(): kiểm tra rỗng
    public boolean isEmpty() { return size == 0; }

    // e. size(): trả về số lượng phần tử
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }
}
