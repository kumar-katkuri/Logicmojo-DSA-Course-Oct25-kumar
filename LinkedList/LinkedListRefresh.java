public class LinkedListRefresh {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.addFirst(1);
        sll.addFirst(0);
        sll.addFirst(-1);
        System.out.println(sll);
        //Node node = sll.removeFirst();
        //System.out.println("Removed: "+ node.value);
        sll.removeFirst();
        System.out.println(sll);
        sll.removeFirst();
        System.out.println(sll);
        sll.addLast(2);
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);
        System.out.println(sll);
        sll.removeLast();
        sll.add(1, 3);
        sll.add(4, 10);
        System.out.println(sll);
        sll.remove(4);
        sll.remove(0);
        System.out.println(sll);
        System.out.println("Size: "+ sll.size);
    }
}

// Single linked list -> value + pointer to next node
class Node {
    int value;
    Node next; // next is referred here as pointer
    public Node(int value) {
        this.value = value;
    }
    public Node(int value, Node node) {
        this.value = value;
        this.next = node;
    }
}

// Single Linked List Implementaion class
class SingleLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public Node removeFirst() {
        Node current = head;
        if (current == null || current.next == null) {
            return null;
        }
        Node removed = new Node(current.value, null);
        head = current.next;
        size--;
        return removed;
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public Node removeLast() {
        Node current = head;
        if (current == null || current.next == null) {
            return null;
        }
        while (current.next.next != null) {
            current = current.next;
        }
        Node removed = current.next;
        current.next = null;
        tail = current;
        size--;
        return removed;
    }

    public void add(int index, int value) {
        if (head == null || head.next == null || index == 0) {
            addFirst(value);
            return;
        }
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count == index-1) {
                Node node = new Node(value);
                node.next = current.next;
                current.next = node;
                size++;
                break;
            } else {
                current = current.next;
                count++;
            }
        }
    }

    public Node remove(int index) {
        if (head == null || head.next == null) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        Node current = head;
        Node previous = head;
        Node removed = null;
        int count = 0;
        while (current != null) {
            if (count == index) {
                removed = new Node(current.value, null);
                previous.next = current.next;
                size--;
                break;
            } else {
                previous = current;
                current = current.next;
                count++;
            }
        }
        return removed;
    }

    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            str += current.value + " -> ";
            current = current.next;
        }
        str += "null";
        return str;
    }
}