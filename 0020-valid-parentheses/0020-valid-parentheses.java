// class Solution {
//     public boolean isValid(String s) {
//         if (s.length() % 2 != 0) return false;

//         char[] stack = new char[s.length()];
//         int head = 0;

//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 stack[head++] = ')';
//             } else if (c == '{') {
//                 stack[head++] = '}';
//             } else if (c == '[') {
//                 stack[head++] = ']';
//             } else {
//                 if (head == 0 || stack[--head] != c) {
//                     return false;
//                 }
//             }
//         }

//         return head == 0;
//     }
// }
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}