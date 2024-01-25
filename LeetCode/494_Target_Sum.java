class Solution {
    private int calculate(int[] nums, int end, int sum, int target, int total, int[][] memo) {
        if (end == 0) {
            return target == sum ? 1 : 0;
        }
        int i = total + sum;
        if (memo[end - 1][i] != Integer.MIN_VALUE) {
            return memo[end - 1][i];
        }
        memo[end - 1][i] = calculate(nums, end - 1, sum + nums[end - 1], target, total, memo)
                + calculate(nums, end - 1, sum - nums[end - 1], target, total, memo);
        return memo[end - 1][i];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, nums.length, 0, target, total, memo);
    }
}
