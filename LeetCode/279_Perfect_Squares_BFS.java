class Solution {
    public int numSquares(int n) {
        int[] candidates = new int[100];
        for (int i = 1; i < 100; i++) candidates[i - 1] = i * i;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        q.add(null);
        int step = 0;
        Set<Integer> seen = new HashSet<Integer>();
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            if (cur == null) {
                step++;
                if (q.peek() != null) {
                    q.add(null);
                }
            } else if (cur == 0) {
                return step;
            } else {
                for (int i = 0; i < 100 && candidates[i] <= cur; i++) {
                    int temp = cur - candidates[i];
                    if (seen.contains(temp)) continue;
                    q.add(temp);
                    seen.add(temp);
                }
            }
        }
        return -1;
    }
}
