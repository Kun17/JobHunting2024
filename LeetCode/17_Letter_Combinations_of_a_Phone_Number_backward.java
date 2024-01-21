class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String trans = mapping[digit - '0'];
            while (ans.peek().length() == i) {
              String pre = ans.poll();
              for (char c : trans.toCharArray()) {
                ans.add(pre + c);
              }
            }
        }
        return ans;
    }
}
