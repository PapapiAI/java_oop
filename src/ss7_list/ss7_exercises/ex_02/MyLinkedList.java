package ss7_list.ss7_exercises.ex_02;


public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // a. addFirst (int element)
    public void addFirst(int value) {
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

    // b. toString (): Trả về thông tin đối tượng
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

    // c. addLast (int element)
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // d. add (int index, int element)
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Ngoài phạm vi");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    // e. removeFirst ()
    public Integer removeFirst() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return temp.value;
    }

    // f. removeLast ()
    public Integer removeLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            // Duyệt đến phần tử kế cuối
            for (int i = 2; i < size; i++) {
                temp = temp.next;
            }
            tail = temp;
            temp = temp.next; // Đây là node cuối cần xóa
            tail.next = null;
        }
        size--;
        return temp.value;
    }

    // g. remove (int index)
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    // h. getFirst ()
    public Integer getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    // i. getLast ()
    public Integer getLast() {
        if (tail == null) {
            return null;
        }
        return tail.value;
    }

    // j. get (int index)
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    // k. set (int index, int element): Thay thế phần tử tại vị trí index
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Index ngoài phạm vi");
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = element;
        }
    }

    // l. indexOf (int element): Tìm vị trí đầu tiên của phần tử
    public Integer indexOf(int element) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                return i;
            }
            temp = temp.next;
        }
        return -1; // Không tìm thấy
    }

    // m. lastIndexOf (int element): Tìm vị trí cuối cùng của phần tử
    public Integer lastIndexOf(int element) {
        int lastIndex = -1;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                lastIndex = i;
            }
            temp = temp.next;
        }
        return lastIndex;
    }
}
