class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                int c = 0;
                if (t.equals("+")) {
                    c = a + b;
                } else if (t.equals("-")) {
                    c = a - b;
                } else if (t.equals("*")) {
                    c = a * b;
                } else {
                    c = a / b;
                }
                s.push(c);
            } else {
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
}
