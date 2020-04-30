import java.util.*;

public class WordSearchII {
    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> results = new ArrayList<>();

        TrieTree tree = new TrieTree(new TrieNode());
        for(String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }

        return results;
    }

    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public void search(char[][] board, int x, int y, TrieNode root, List<String> results) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }
        TrieNode child = root.children.get(board[x][y]);

        if (child.word != null) {
            if(!results.contains(child.word)){
                results.add(child.word);
            }
        }

        char tmp = board[x][y];
        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            if (!isValid(board, x + dx[i], y + dy[i])){
                continue;
            }
            search(board, x + dx[i], y + dy[i], child, results);
        }

        board[x][y] = tmp;
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return board[x][y] != 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("dad");
        list.add("dgdg");
        list.add("can");
        list.add("again");

        Map<int[], Set<String>> map = new HashMap<>();


        for (Map.Entry<int[], Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {

            }
        }

        char[][] board = {
                {'d', 'o', 'a', 'f'},
                {'a', 'g', 'a', 'i'},
                {'d', 'c', 'a', 'n'}
        };

        WordSearchII wordSearchII = new WordSearchII();
        List<String> results = wordSearchII.wordSearchII(board, list);
        for (String s : results) {
            System.out.println(s);
        }

    }
}



class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
};

class TrieTree {
    TrieNode root;

    public TrieTree(TrieNode TrieNode) {
        root = TrieNode;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))){
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
}