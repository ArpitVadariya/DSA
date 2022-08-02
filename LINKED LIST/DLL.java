public class DLL {

    private Node head;

    /*
     * insert element at first index. --> insertFirst(value)
     * insert at last index. --> insertLast(value)
     * find element. --> find(value)
     * insert element at particular index. --> insert(after, value)
     * display all elements. --> display()
     */

    // folowing are same as LL

    /*
     * delete element at first index. --> deleteFirst(value)
     * delete last element. --> deleteLast(value)
     * delete particular element. --> delete(value)
     * get particular element. --> get(value)
     * display elements from particular index. --> display(Node)
     */

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public Node find(int value) {
        Node node = head;

        while (node != null) {
            if (node.value == value) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    public void insert(int after, int value) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public void display() {
        Node node = head;
        Node last = null;

        while (node != null) {
            System.out.print(node.value + " --> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println();

        System.out.println("Reverse");

        while (last != null) {
            System.out.print(last.value + " --> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        // node create at particular position
        // public Node(int value, Node next, Node prev) {
        // this.value = value;
        // this.next = next;
        // this.prev = prev;
        // }
    }
}