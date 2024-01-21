class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        int len = digits.length();
        if (len == 0) return ans;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String trans = mapping[digits.charAt(len - 1) - '0'];
        List<String> pre_ans = letterCombinations(digits.substring(0, len - 1));
        for (char c : trans.toCharArray()) {
            if (pre_ans.isEmpty()) {
                pre_ans.add("");
            }
            for (String s : pre_ans) {
                ans.add(s + c);
            }
        }
        return ans;
    }
}
