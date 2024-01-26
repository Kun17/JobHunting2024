class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1, 0 },
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 0, -1 });

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int[] row : ans) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            int[] c = q.poll();
            for (int[] d : DIRECTIONS) {
                int x = c[0] + d[0];
                int y = c[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || ans[x][y] != Integer.MAX_VALUE)
                    continue;
                ans[x][y] = ans[c[0]][c[1]] + 1;
                q.offer(new int[] { x, y });
            }
        }
        return ans;
    }
}
