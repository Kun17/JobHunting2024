class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % size;
        data[tail] = value;
        if (head == -1) head = 0;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % size;
        }
        return true;
    }
    
    public int Front() {
        if (head < 0) return -1;
        return data[head];
    }
    
    public int Rear() {
        if (tail < 0) return -1;
        return data[tail];
    }
    
    public boolean isEmpty() {
        return tail == -1 && head == -1;
    }
    
    public boolean isFull() {
        return tail - head == -1 || (tail - head == size - 1 && head != -1);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
