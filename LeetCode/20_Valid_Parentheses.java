// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (char c : s.toCharArray()) {
//             if (c == '(' || c == '[' || c == '{') {
//                 stack.push(c);
//             } else {
//                 if (stack.empty()) return false;
//                 if (c == ')' && stack.pop() != '(') return false;
//                 if (c == ']' && stack.pop() != '[') return false;
//                 if (c == '}' && stack.pop() != '{') return false;
//             }
//         }
//         return stack.empty();
//     }
// }

class Solution {
    Map<Character, Character> map = new HashMap<>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || map.get(c) != stack.pop()) return false;
            }
        }
        return stack.empty();
    }
}
