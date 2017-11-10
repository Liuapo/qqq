public class ArrayDeque<T> {
    private T[] arr;
    private int start, end, size;
    private static final int INITIAL = 8;
    // constructor
    public ArrayDeque() {
        this.arr = (T[])new Object[INITIAL];
        this.start = 0;
        this.end = 1;
        this.size = 0;
    }

    // Adds an item to the front of the Deque.
    public void addFirst(T item) {
        if (this.size == this.arr.length) {
            resize(this.arr.length * 2);
        }
        this.arr[this.start] = item;
        this.start = (this.start + this.arr.length - 1) % this.arr.length;
        this.size++;
    }

    // Adds an item to the back of the Deque.
    public void addLast(T item) {
        if (this.size == this.arr.length) {
            resize(this.arr.length * 2);
        }
        this.arr[this.end] = item;
        this.end = (this.end + 1) % this.arr.length;
        this.size++;
    }

    // Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Returns the number of items in the Deque.
    public int size() {
        int len = this.size;
        return len;
    }

    private void resize(int n) {
        T[] nArray = (T[])new Object[n];
        int i = 0;
        start = (start + 1) % arr.length;
        for (i = 0; i < this.size; i++) {
            nArray[i] = this.arr[start];
            this.start = (this.start + 1) % this.arr.length;
        }
        this.arr = nArray;
        this.start = nArray.length - 1;
        this.end = i;

    }

    // Prints the items in the Deque from first to last, separated by a space.
    public void printDeque() {
        int i = (this.start + 1) % this.arr.length;
        int count = 0;
        while (count < this.size) {
            count++;
            System.out.print(this.arr[i] + " ");
            i = (i + 1) % this.arr.length;
        }
        // System.out.print(this.arr[i]);

    }

    // Removes and returns the item at the front of the Deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        this.start = (this.start + 1) % this.arr.length;
        T ans = this.arr[this.start];
        this.arr[this.start] = null;
        this.size--;
        if (this.arr.length >= 16 && this.size * 4 < this.arr.length) {
            resize(this.arr.length / 2);
        }
        return ans;
    }

    // Removes and returns the item at the back of the Deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        this.end = (this.end - 1 + this.arr.length) % this.arr.length;
        T ans = this.arr[this.end];
        this.arr[this.end] = null;
        this.size--;
        if (this.arr.length >= 16 && this.size * 4 < this.arr.length) {
            resize(this.arr.length / 2);
        }
        return ans;
    }


    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    // If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if (size - 1 < index || index < 0) return null;
        int front = (this.start + 1) % this.arr.length;
        index = (front + index) % this.arr.length;
        return this.arr[index];
    }

    public double getFactor() {
        return (double)this.size / this.arr.length;
    }

    public int getArrSize() {
        return this.arr.length;
    }



}
