import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) {
            return false;
        }

        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }

        int maxLength = getMaxLength(set);

        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;

        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                String sub = s.substring(i - j, i);
                if (set.contains(sub) && canBreak[i-j]) {
                    canBreak[i] = true;
                }
            }
        }

        return canBreak[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }

        return maxLength;
    }

    public int leastNumberOfWordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for(String word : wordDict) {
            set.add(word);
        }

        int maxLength = getMaxLength(set);

        int[] dp = new int[s.length() + 1];
        dp[0] = 0;

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                String sub = s.substring(i - j, i);
                if (set.contains(sub)) {
                    dp[i] = Math.min(dp[i - j] + 1, dp[i]);
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//
//        set.add("lint");
//        set.add("code");
//
//        String s = "lintcode";
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("pine", "apple", "pen", "pineapple", "applepen"));

        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
        System.out.println(wordBreak.leastNumberOfWordBreak(s, wordDict));
    }
}
