public class LinkedListImpl {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.add(0, 0);
        ll.remove(0);
        System.out.println(ll);
    }
}

class Node {
    int val;
    Node pointer;

    public Node(int val) {
        this.val =val;
    }
}

class LinkedList {
    int val;
    Node head;
    Node tail;
    int size;

    public void addLast(int val) {
        Node current = new Node(val);
        if (head == null) {
            current.pointer = tail;
            head = current;
            tail = current;
        } else {
            tail.pointer = current;
            tail = current;
        }
        size++;
    }

    public void addFirst(int val) {
        Node current = new Node(val);
        if (head == null) {
            current.pointer = tail;
            head = current;
            tail = current;
        } else {
            current.pointer = head;
            head = current;
        }
        size++;
    }

    public void removeLast() {
        Node curr = head;

        if (size == 0 || size == 1) {
            size = 0;
            head = null;
            tail = null;
        }

        while (curr.pointer != null && curr.pointer.pointer != null) {
            curr = curr.pointer;
        }
        curr.pointer = null;
        tail = curr;
        size--;
    }

    public void removeFirst() {
        if (size == 0 || size == 1) {
            removeLast();
        }
        Node curr = head.pointer;
        head.pointer = null;
        head = curr;
        size--;
    }

    public void add(int index, int val) {
        Node curr = head;
        int i = 0;
        if (index == 0) {
            addFirst(val);
        }
        while (i < index) {
            if (index > 0 && i == index - 1) {
                Node node = new Node(val);
                node.pointer = curr.pointer;
                curr.pointer = node;
                size++;
                break;
            } else {
                i++;
                curr = curr.pointer;
            }
        }
        size--;
    }

    public void remove(int index) {
        Node curr = head;
        int i = 0;
        if (index == 0) {
            removeFirst();
        }
        while (i < index) {
            if (index > 0 && i == index-1) {

                Node next = curr.pointer;
                if (next.pointer == null) {
                    curr.pointer = null;
                    tail = curr;
                } else {
                    curr.pointer = curr.pointer.pointer;
                }
                break;
            } else {
                i++;
                curr = curr.pointer;
            }
        }
        size--;
    }

    public String toString() {
        String string = "";
        Node current = head;

        while (current != null) {
            string += current.val + " -> ";
            current = current.pointer;
        }

        string += "null";
        return string;
    }

}