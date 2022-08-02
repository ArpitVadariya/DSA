public class LL {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    private int size;

    public LL() {
        this.size = 0;
    }

    /*
     * insert element at first index. --> insertFirst(value)
     * delete element at first index. --> deleteFirst(value)
     * delete last element. --> deleteLast(value)
     * delete particular element. --> delete(value)
     * get particular element. --> get(value)
     * find element. --> find(value)
     * insert at last index. --> insertLast(value)
     * insert element at particular index. --> insert(value, index)
     * display all elements. --> display()
     * display elements from particular index. --> display(Node)
     */

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return value;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondlast = get(size - 2);

        int value = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;
        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int value = prev.next.value;
        prev.next = prev.next.next;

        return value;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
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

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayFromIndex(Node node) {
        while (node != null) {
            System.out.print(node.value + " --> ");
            node = node.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // ----------------------------Questions----------------------------
    // 1. insert using recursion
    public void insertRecursion(int value, int index) {
        head = insertRecursion(value, index, head);
    }

    public Node insertRecursion(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRecursion(value, index - 1, node.next);
        return node;
    }

    // 2. remove duplicate nodes in Linked List
    public void removeDuplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // 3. Merge Two Sorted List
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    // public static Node mergeL(Node first, Node second) {
    // Node f = first;
    // Node s = second;

    // LL ans = new LL();

    // while (f != null && s != null) {
    // if (f.value < s.value) {
    // ans.insertLast(f.value);
    // f = f.next;
    // } else {
    // ans.insertLast(s.value);
    // s = s.next;
    // }
    // }

    // while (f != null) {
    // ans.insertLast(f.value);
    // f = f.next;
    // }

    // while (s != null) {
    // ans.insertLast(s.value);
    // s = s.next;
    // }

    // return ans.getHead();
    // }

    // public static Node merge(Node first, Node second) {

    // Node dummyHead = new Node();
    // Node tail = dummyHead;

    // while(first.next != null && second.next != null){
    // if(first.value < second.value){
    // tail.next = first;
    // first = first.next;
    // tail = tail.next;
    // } else{
    // tail.next = second;
    // second = second.next;
    // tail = tail.next;
    // }
    // }

    // tail.next = (first != null) ? first : second;
    // return dummyHead.next;
    // }

    // 4. Detect Cycle Present in List or not
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    // 5. Find Length of Cycle

    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }

        return 0;
    }

    // 5. Detect Cycle Starting

    public Node detectStartOfCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        Node f = head;
        Node s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }

    // 6. isHappy number

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquare(int number) {
        int ans = 0;

        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    // 7. return middle of Linked list

    public Node middleNode(Node head) {
        Node f = head;
        Node s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    // 8. sort linked list

    // public Node sortList(Node head){
    // if(head == null || head.next == null){
    // return head;
    // }

    // Node mid = middleNode(head);

    // Node left = sortList(head);
    // Node right = sortList(mid);

    // return mergeL(left, right);
    // }

    public static void main(String[] args) {
        // LL list1 = new LL();
        // LL list2 = new LL();
        // list1.insertLast(1);
        // list1.insertLast(3);
        // list1.insertLast(5);
        // list1.display();

        // list2.insertLast(1);
        // list2.insertLast(2);
        // list2.insertLast(7);
        // list2.insertLast(12);
        // list2.insertLast(14);
        // list2.display();

        // LL ans = new LL();

        // ans = LL.merge(list1, list2);

        // ans.display();

        // LL list = new LL();
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(3);
        // list.insertLast(4);
        // list.insertLast(5);
        // list.insertLast(6);
        // list.display();
        // list.displayFromIndex(list.middleNode(list.head));

        // LL ml = new LL();

        // ml.insertLast(4);
        // ml.insertLast(1);
        // ml.insertLast(3);
        // ml.insertLast(2);
        // ml.insertLast(5);

        // System.out.println(ml.sortList(ml.head));
    }
}