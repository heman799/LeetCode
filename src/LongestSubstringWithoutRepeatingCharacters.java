import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        int left = 0, right = 0, res = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            }
            else {
                set.remove(s.charAt(left++));
            }
        }

        return res;

    }
}
