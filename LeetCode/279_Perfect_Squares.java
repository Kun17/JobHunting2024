class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int max_squre = (int)Math.sqrt(n);

        for (int i = 1; i <= n; i++) {
            for (int j = 1 ; j <= max_squre; j++) {
                if (i < j * j) continue;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
