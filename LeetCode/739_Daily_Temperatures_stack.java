class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.empty() && temperatures[i] > temperatures[s.peek()] ) {
                int pre = s.pop();
                ans[pre] = i - pre;
            }
            s.push(i);
        }
        return ans;
    }
}
