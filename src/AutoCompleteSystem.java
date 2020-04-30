import java.util.*;

public class AutoCompleteSystem {
    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children;
        String s;
        int times;
        List<TrieNode> hot;

        public TrieNode() {
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        public int compareTo(TrieNode o) {
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            }
            return o.times - this.times;
        }

        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }
            Collections.sort(hot);
            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }
    TrieNode root;
    TrieNode cur;
    StringBuilder sb;
    //constructor
    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public void add(String sentence, int t) {
        TrieNode tmp = root;
        List<TrieNode> visited = new ArrayList<>();
        for (char c : sentence.toCharArray()){
            if (tmp.children[c] == null) {
                tmp.children[c] = new TrieNode();
            }
            tmp = tmp.children[c];
            visited.add(tmp);
        }
        tmp.s = sentence;
        tmp.times += t;

        for (TrieNode node : visited) {
            node.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }
        sb.append(c);
        if (cur != null) {
            cur = cur.children[c];
        }
        if (cur == null) return res;
        for (TrieNode node : cur.hot) {
            res.add(node.s);
        }
        return res;
    }
//    class TrieNode {
//        Map<Character, TrieNode> children;
//        Map<String, Integer> counts;
//        boolean isWord;
//        public TrieNode() {
//            children = new HashMap<>();
//            counts = new HashMap<>();
//            isWord = false;
//        }
//    }
//    TrieNode root;
//    TrieNode cur;
//    StringBuilder sb;
//    public AutoCompleteSystem(String[] sentences, int[] times) {
//        root = new TrieNode();
//        cur = root;
//        sb = new StringBuilder();
//
//        for (int i = 0; i < sentences.length; i++) {
//            add(sentences[i], times[i]);
//        }
//    }
//
//    private void add(String s, int count) {
//        TrieNode tmp = root;
//        for (char c : s.toCharArray()) {
//            if (!tmp.children.containsKey(c)) {
//                tmp.children.put(c, new TrieNode());
//            }
//            tmp = tmp.children.get(c);
//            tmp.counts.put(s, tmp.counts.getOrDefault(s, 0) + count);
//        }
//    }
//
//    public List<String> input(char c) {
//        List<String> res = new ArrayList<>();
//        if (c == '#') {
//            add(sb.toString(), 1);
//            sb = new StringBuilder();
//            cur = root;
//            return res;
//        }
//        sb.append(c);
//        if (cur != null) {
//            cur = cur.children.get(c);
//        }
//        if (cur == null) return res;
//        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
//                (a, b) -> (a.getValue() == b.getValue() ?
//                        a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
//        pq.addAll(cur.counts.entrySet());
//        int k = 3;
//        while(!pq.isEmpty() && k > 0) {
//            res.add((String) pq.poll().getKey());
//            k--;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutoCompleteSystem autoCompleteSystem = new AutoCompleteSystem(sentences, times);
        List<String> res = autoCompleteSystem.input('i');
        List<String> res1 = autoCompleteSystem.input(' ');
        List<String> res2 = autoCompleteSystem.input('a');
        List<String> res3 = autoCompleteSystem.input('#');
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
