package ss7_list.ss7_exercises.ex_02;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();

        // a. addFirst (int element)
        myList.addFirst(10);
        myList.addFirst(20);
        myList.addFirst(30);

        // b. toString (): Trả về thông tin đối tượng
        System.out.println("Danh sách ban đầu: " + myList.toString());

        // c. addLast (int element)
        myList.addLast(40);
        myList.addLast(50);

        // d. add (int index, int element)
        myList.add(2, 25);
        System.out.println("Danh sách sau khi thêm 25 vào vị trí 2: " + myList.toString());

        // e. removeFirst ()
        myList.removeFirst();
        System.out.println("Danh sách sau khi xóa phần tử đầu tiên: " + myList.toString());

        // f. removeLast ()
        myList.removeLast();
        System.out.println("Danh sách sau khi xóa phần tử cuối cùng: " + myList.toString());

        // g. remove (int index)
        myList.remove(2);
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 2: " + myList.toString());

        // h. getFirst ()
        Integer firstElement = myList.getFirst();
        System.out.println("Phần tử đầu tiên trong danh sách: " + firstElement);

        // i. getLast ()
        Integer lastElement = myList.getLast();
        System.out.println("Phần tử cuối cùng trong danh sách: " + lastElement);

        // j. get (int index)
        Integer elementAtIndex = myList.get(1);
        System.out.println("Phần tử tại vị trí 1 trong danh sách: " + elementAtIndex);

        // k. set (int index, int element)
        myList.set(0, 15);
        System.out.println("Danh sách sau khi thay thế phần tử tại vị trí 0 thành 15: " + myList.toString());

        // l. indexOf (int element)
        Integer indexOfElement = myList.indexOf(20);
        System.out.println("Vị trí index của phần tử 20 là: " + indexOfElement);

        // m. lastIndexOf (int element)
        Integer lastIndexOfElement = myList.lastIndexOf(25);
        System.out.println("Vị trí index cuối cùng của phần tử 25 là: " + lastIndexOfElement);
    }
}
