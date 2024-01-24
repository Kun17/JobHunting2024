class Solution {
    private Set<Integer> squares = new HashSet<Integer>();

    private boolean canBeDividedby(int num, int count) {
        if (count == 0) return false;
        if (squares.contains(num) && count == 1) return true;
        for (int i = 1; i * i <= num; i++) {
            if (canBeDividedby(num - i * i, count - 1)) return true;
        }
        return false;
    }
    
    public int numSquares(int n) {
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        
        for (int i = 1; i <= n; i++) {
            if (canBeDividedby(n, i)) return i;
        }
        return n;
    }
}
