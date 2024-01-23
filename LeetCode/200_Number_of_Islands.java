class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList (
        new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}  
    );
    
    void BFS (int i, int j, int m, int n, char[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {i, j});
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int[] d : DIRECTIONS) {
                int x = d[0] + c[0];
                int y = d[1] + c[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
                if (grid[x][y] == '1') {
                    grid[x][y] = '2';
                    q.add(new int[] {x, y});
                };
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '2' || grid[i][j] == '0') continue;
                BFS(i, j, m, n, grid);
                ans++;
            }
        }
        return ans;
    }
}
