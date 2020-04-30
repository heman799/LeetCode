import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<String>> allPathsSourceTarget(String[] list) {
        Set<String> words = new HashSet<>();
        for(String word : list) {
            words.add(word);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        //put all words into a map
        Map<Character, Set<String>> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word.charAt(0))) {
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(word.charAt(0), set);
            }
            Set<String> currSet = map.get(word.charAt(0));
            currSet.add(word);
            map.put(word.charAt(0), currSet);
        }

        for (Map.Entry<Character, Set<String>> entry : map.entrySet()) {
            dfs(map, entry.getKey(), res, path, 0);
        }

        return res;
    }

    private void dfs(Map<Character, Set<String>> map, char c, List<List<String>> res, List<String> path, int index) {
        if (index == 2) {
            res.add(new ArrayList<String>(path));
            return;
        }
        if (!map.containsKey(c)) {
            return;
        }
        for (String nextWord : map.get(c)) {
            path.add(nextWord);
            dfs(map, nextWord.charAt(nextWord.length() - 1), res, path, index + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"ABOD", "AVVC", "COOK", "DEFK", "ABOD", "ABLI", "IABK", "DMGK", "ALCE"};
        AllPathsFromSourceToTarget ins = new AllPathsFromSourceToTarget();
        List<List<String>> res = ins.allPathsSourceTarget(words);
        for(List<String> list : res) {
            System.out.println("***********");
            for (String key : list) {
                System.out.println(key);
            }
        }
    }
}
