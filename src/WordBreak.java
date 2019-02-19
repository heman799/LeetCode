import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);

        //dp array
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                lastWordLength <= maxLength && lastWordLength <= i;
                lastWordLength++) {

                //dp[j] has to be true
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }

                //可以直接取， 只需要在字典中查找s.substr(j, i - j)是否存在
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }

            }
        }

        return canSegment[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("lint");
        set.add("code");

        String s = "lintcode";

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, set));
    }
}
