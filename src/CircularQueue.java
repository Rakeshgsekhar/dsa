class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList {
    DNode head;
    DNode tail;

    // Insertion at the end
    public void insert(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            DNode temp = tail;
            newNode.prev = tail;
            newNode.next = head;
            temp.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    public void insertFront(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            tail = newNode;
        } else {
            DNode temp = head.prev;
            newNode.next = head;
            newNode.prev = temp;
            head.prev = newNode;
            temp.next = newNode;
            head = newNode;
        }
    }

    public void deleteLast(){
        if(tail == null) return;
        if(tail.next == tail) {
            tail = null;
            head = null;
            return;
        }
        DNode temp = tail.prev;
        temp.next = tail.next;
        tail.next.prev = temp;
        tail = temp;
    }

    public void deleteFront(){
        DNode temp = head.next;
        temp.prev = head.prev;
        head.prev.next = temp;
        head = temp;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        DNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }


}
class MyCircularDeque {
    CircularDoublyLinkedList list;
    int capacity;
    int size;
    public MyCircularDeque(int k) {
        list = new CircularDoublyLinkedList();
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if(this.isFull()) return false;
        this.list.insertFront(value);
        this.size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(this.isFull()) return false;
        this.list.insert(value);
        this.size++;
        return true;
    }

    public boolean deleteFront() {
        if(this.isEmpty()) return false;
        this.list.deleteFront();
        this.size--;
        return true;
    }

    public boolean deleteLast() {
        if(this.isEmpty()) return false;
        this.list.deleteLast();
        this.size--;
        return true;
    }

    public int getFront() {
        if(this.size == 0) return -1;
        return list.head.data;
    }

    public int getRear() {
        if(this.size == 0) return -1;
        return list.tail.data;
    }

    public boolean isEmpty() {
        if(this.size == 0) return true;
        return false;
    }

    public boolean isFull() {
        if(this.size == this.capacity) return true;
        return false;
    }

    public void print(){
        list.printList();
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
public class CircularQueue {
    public static void main(String[] args) {

        MyCircularDeque deque = new MyCircularDeque(10);
        deque.insertFront(89);
        deque.print();
        deque.getRear();
        deque.deleteLast();
        deque.print();
        deque.insertFront(19);
        deque.insertFront(23);
        deque.insertFront(23);
        deque.insertFront(82);
        deque.insertFront(45);

        deque.print();





    }
}
