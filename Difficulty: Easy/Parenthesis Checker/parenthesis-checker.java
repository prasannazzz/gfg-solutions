import java.util.*;
class Solution {
    public boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char ch = stack.peek();
                if ((curr == ')' && ch == '(') ||
                    (curr == '}' && ch == '{') ||
                    (curr == ']' && ch == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}