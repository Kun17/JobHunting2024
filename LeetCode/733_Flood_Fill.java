class Solution {
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {1, 0},
        new int[] {-1, 0},
        new int[] {0, -1},
        new int[] {0, 1}
    );
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr, sc});
        int m = image.length;
        int n = image[0].length;
        int oc = image[sr][sc];
        while (!stack.empty()) {
            int[] c = stack.pop();
            image[c[0]][c[1]] = color;
            for (int[] d : DIRECTIONS) {
                int x = c[0] + d[0];
                int y = c[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oc || image[x][y] == color) continue;
                stack.push(new int[]{x, y});
            }
        }
        return image;
    }
}
