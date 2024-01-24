class MinStack {
    Stack<int[]> minStack;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        minStack = new Stack<int[]>();
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        minStack.push(new int[] {val, min});
    }
    
    public void pop() {
        minStack.pop();
        if (minStack.empty()) min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
