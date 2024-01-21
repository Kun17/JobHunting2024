class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<String>();
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String trans = mapping[digit - '0'];
            int size = ans.size();
            for (char c : trans.toCharArray()) {
                if (size == 0) {
                    ans.add(String.valueOf(c));
                }
                for (int j = 0; j < size; j++) {
                    ans.add(ans.get(j) + c);
                }
            }
            for (int j = 0; j < size; j++) {
                ans.remove(0);
            }
        }
        return ans;
    }
}
