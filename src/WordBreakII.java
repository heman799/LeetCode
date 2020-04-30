import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
        return helper(s, wordDict, memo);
    }

    private ArrayList<String> helper(String s, Set<String> dict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        ArrayList<String> results = new ArrayList<>();

        if (s.length() == 0) {
            return results;
        }

        if (dict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); len++) {
            String right = s.substring(len);
            if (!dict.contains(right)) {
                continue;
            }

            String left = s.substring(0, len);
            ArrayList<String> segmentations = helper(left, dict, memo);

            for (String segmentation : segmentations) {
                results.add(segmentation + " " + right);
            }
        }
        memo.put(s, results);
        return results;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        WordBreakII wordBreak = new WordBreakII();
        List<String> result = wordBreak.wordBreak(s, set);
        for (String item : result) {
            System.out.println(item);
        }
    }
}
