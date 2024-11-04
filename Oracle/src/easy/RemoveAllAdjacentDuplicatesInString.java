package easy;

import java.util.Stack;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        // Process each character in s
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // Join the stack to a string
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
