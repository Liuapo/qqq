public class LinkedListDeque<T> {

    // wrapper class inside the Deque
    private class ListNode<T> {
        T val;
        ListNode<T> next, prev;
        public ListNode(T val) {
            this.val = val;
        }
    }
    private ListNode<T> dummy;
    private int size;

    // constructor
    public LinkedListDeque() {
        this.dummy = new ListNode(null);
        this.dummy.next = dummy;
        this.dummy.prev = dummy;
        this.size = 0;
    }


    // Adds an item to the front of the Deque.
    public void addFirst(T item) {
        ListNode temp = new ListNode(item);
        ListNode head = this.dummy.next;
        temp.next = head;
        this.dummy.next = temp;
        temp.prev = this.dummy;
        head.prev = temp;
        this.size++;
    }

    // Adds an item to the end of the Deque.
    public void addLast(T item) {
        ListNode temp = new ListNode(item);
        ListNode tail = this.dummy.prev;
        temp.prev = tail;
        temp.next = this.dummy;
        this.dummy.prev = temp;
        tail.next = temp;
        this.size++;
    }

    //  Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
      return this.size == 0;
    }

    // Returns the number of items in the Deque.
    public int size() {
        int ans = this.size;
        return ans;
    }

    // Prints the items in the Deque from first to last, separated by a space.
    public void printDeque() {
        int len = this.size;
        if (len == 0) return;
        ListNode head = this.dummy.next;
        for (int i = 1; i <= len; i++) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        //System.out.print(head.val);
    }

    // Removes and returns the item at the front of the Deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (this.isEmpty()) return null;
        ListNode head = this.dummy.next;
        dummy.next = head.next;
        head.next.prev = dummy;
        this.size--;
        T ans = (T)head.val;
        return ans;

    }

    //  Removes and returns the item at the back of the Deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (this.isEmpty()) return null;
        ListNode tail = this.dummy.prev;
        this.dummy.prev = tail.prev;
        tail.prev.next = this.dummy;
        this.size--;
        T ans = (T)tail.val;
        return ans;
    }


    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (this.size - 1 < index || index < 0) return null;
        ListNode head = dummy.next;
        while (index > 0) {
            head = head.next;
            index--;
        }
        return (T)head.val;
    }
}
