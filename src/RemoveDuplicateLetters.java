import java.util.*;

public class RemoveDuplicateLetters {

    //lexicographical: 按照字典顺序排列
    public static String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (stack.contains(c)) {
                counts[c - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && counts[stack.peek() - 'a'] > 1 && stack.peek() > c) {
                char top = stack.pop();
                counts[top - 'a']--;
            }
            stack.push(c);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "cbacdcbc";
        System.out.print(removeDuplicateLetters(a));
    }
}

