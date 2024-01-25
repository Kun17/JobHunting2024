class Solution {    
    public void dfs(int x, int y, int m, int n, char[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') return;
        if (grid[x][y] == '1') grid[x][y] = '0';
        dfs(x - 1, y, m, n, grid);
        dfs(x + 1, y, m, n, grid);
        dfs(x, y - 1, m, n, grid);
        dfs(x, y + 1, m, n, grid);
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                dfs(i, j, m, n, grid);
                ans++;
            }
        }
        return ans;
    }
}
